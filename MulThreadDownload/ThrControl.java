// ThrControl.java

import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;

/*
 主控制线程
*/
class ThrControl extends Thread{
	public void run(){
		System.out.println("URL:"+ThrDownload.url_name);
		System.out.println("Save file name:"+ThrDownload.save_name);
		System.out.printf("共%d字节需要下载:\n",ThrDownload.file_len);
		System.out.printf("线程数=%d\n",ThrDownload.thread_num);
		double begin_time = (new Date()).getTime()/1000.0; // 单位s
		for(int i=0;i<ThrDownload.thread_num;i++){
			ThrDownload.t[i].start();
		}
		while(true){
			boolean stop = true; // 是否退出标志
			try{
				sleep(1000);
			}catch(InterruptedException e){
				// TODO
			}
			double current_time = (new Date()).getTime()/1000.0;
			double percent = 0, speed = 0;
			// 计算下载百分比和平均下载速率
			for(int i=0;i<ThrDownload.thread_num;i++){
				percent += ThrDownload.t[i].getLen();
			}
			speed = percent/1000.0/(current_time-begin_time); // 单位KB/s
			percent /= ThrDownload.file_len;
			System.out.printf("\r%.2f%%已下载，平均下载速度=%.2fKB/s   ",percent*100,speed);
			for(int i=0;i<ThrDownload.thread_num;i++){
				if(ThrDownload.t[i].isAlive())
				{
					stop = false;
					break;
				}
				if(i>=ThrDownload.thread_num)
					break;
			}
			if(stop)
				break;
		}
		System.out.printf("\n下载时间=%.2fs\n",(new Date()).getTime()/1000.0-begin_time);
	}
}