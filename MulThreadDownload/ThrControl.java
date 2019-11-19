// ThrControl.java

import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;

/*
 �������߳�
*/
class ThrControl extends Thread{
	public void run(){
		System.out.println("URL:"+ThrDownload.url_name);
		System.out.println("Save file name:"+ThrDownload.save_name);
		System.out.printf("��%d�ֽ���Ҫ����:\n",ThrDownload.file_len);
		System.out.printf("�߳���=%d\n",ThrDownload.thread_num);
		double begin_time = (new Date()).getTime()/1000.0; // ��λs
		for(int i=0;i<ThrDownload.thread_num;i++){
			ThrDownload.t[i].start();
		}
		while(true){
			boolean stop = true; // �Ƿ��˳���־
			try{
				sleep(1000);
			}catch(InterruptedException e){
				// TODO
			}
			double current_time = (new Date()).getTime()/1000.0;
			double percent = 0, speed = 0;
			// �������ذٷֱȺ�ƽ����������
			for(int i=0;i<ThrDownload.thread_num;i++){
				percent += ThrDownload.t[i].getLen();
			}
			speed = percent/1000.0/(current_time-begin_time); // ��λKB/s
			percent /= ThrDownload.file_len;
			System.out.printf("\r%.2f%%�����أ�ƽ�������ٶ�=%.2fKB/s   ",percent*100,speed);
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
		System.out.printf("\n����ʱ��=%.2fs\n",(new Date()).getTime()/1000.0-begin_time);
	}
}