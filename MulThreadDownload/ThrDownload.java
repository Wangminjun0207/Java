// ThrDownload.java

import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
// 下载线程类
class ThrDownload extends Thread{
	private RandomAccessFile out;  // 随机读取文件对象
	private InputStream in;        // 字节输出对象
	private URL url;               // url
	private int start, end;        // url文件起始和结束位置
	private int no;                // 线程号
	private byte []b;              // 读写缓冲区
	private int len;               // 当前下载字节数
	public static int file_len = 0;     // 下载文件长度
	public static int buf_len = 8192;   // 缓冲区大小8K
	public static int thread_num = 1;   // 线程数
	public static String url_name;      // url名
	public static String save_name;     // 存盘文件名
	public static ThrDownload []t;
	// 初始化函数
	public static boolean init(String url_name,String save_name,int thread_num){
		ThrDownload.url_name = url_name;
		ThrDownload.save_name = save_name;
		ThrDownload.thread_num = thread_num;
		try{
			URL url = new URL(url_name);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			file_len = con.getContentLength();
		}catch(Exception e){
			return false;
		}
		
		if(file_len == -1){
			return false;
		}
		t = new ThrDownload[thread_num];
		for(int i=0;i<thread_num;i++){
			t[i] = new ThrDownload(i+1); // 建立下载线程
		}
		return true;
	}
	
	// 构造函数
	public ThrDownload(int no){
		// 每个线程平均下载
		int block_len = file_len / thread_num;
		start = block_len * (no-1); // no编号从1开始
		end = start + block_len -1;
		if(no==thread_num){
			end = file_len -1;
		}
		len = 0; // 初始化当前下载字节为0
		try{
			url = new URL(url_name);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestProperty("Range","bytes="+start+"-"+end);
			in = con.getInputStream();
			if(con.getResponseCode()>=300){
				new Exception("http响应问题:"+con.getResponseCode());
			}
			out = new RandomAccessFile(save_name,"rw");
			this.no = no;
			out.seek(start);
			b = new byte[buf_len];
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	// 下载线程体
	public void run(){
		int L;
		try{
			while(true){
				L = in.read(b);
				if(L==-1){ // L为实际读出的字节数
					break; 
				}
				out.write(b,0,L);
				len = len + L; // 当前下载字节数+L
			}
			in.close();
			out.close();
		}catch(Exception e){
			// TODE
		}
	}
	
	// 返回当前下载长度函数
	public int getLen(){
		return len;
	}
}
