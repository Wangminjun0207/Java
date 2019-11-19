// ThrDownload.java

import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;
// �����߳���
class ThrDownload extends Thread{
	private RandomAccessFile out;  // �����ȡ�ļ�����
	private InputStream in;        // �ֽ��������
	private URL url;               // url
	private int start, end;        // url�ļ���ʼ�ͽ���λ��
	private int no;                // �̺߳�
	private byte []b;              // ��д������
	private int len;               // ��ǰ�����ֽ���
	public static int file_len = 0;     // �����ļ�����
	public static int buf_len = 8192;   // ��������С8K
	public static int thread_num = 1;   // �߳���
	public static String url_name;      // url��
	public static String save_name;     // �����ļ���
	public static ThrDownload []t;
	// ��ʼ������
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
			t[i] = new ThrDownload(i+1); // ���������߳�
		}
		return true;
	}
	
	// ���캯��
	public ThrDownload(int no){
		// ÿ���߳�ƽ������
		int block_len = file_len / thread_num;
		start = block_len * (no-1); // no��Ŵ�1��ʼ
		end = start + block_len -1;
		if(no==thread_num){
			end = file_len -1;
		}
		len = 0; // ��ʼ����ǰ�����ֽ�Ϊ0
		try{
			url = new URL(url_name);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestProperty("Range","bytes="+start+"-"+end);
			in = con.getInputStream();
			if(con.getResponseCode()>=300){
				new Exception("http��Ӧ����:"+con.getResponseCode());
			}
			out = new RandomAccessFile(save_name,"rw");
			this.no = no;
			out.seek(start);
			b = new byte[buf_len];
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	// �����߳���
	public void run(){
		int L;
		try{
			while(true){
				L = in.read(b);
				if(L==-1){ // LΪʵ�ʶ������ֽ���
					break; 
				}
				out.write(b,0,L);
				len = len + L; // ��ǰ�����ֽ���+L
			}
			in.close();
			out.close();
		}catch(Exception e){
			// TODE
		}
	}
	
	// ���ص�ǰ���س��Ⱥ���
	public int getLen(){
		return len;
	}
}
