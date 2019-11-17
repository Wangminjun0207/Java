// MulThreadSocket.java
/* �������
   �������ݵĲ��֣�Ҳ�з����ݵĲ���
   ��������ͬʱִ�У����߳����
 */
import java.net.*;
import java.lang.String;
import java.util.Scanner;
import java.io.*;

// ������
class Send implements Runnable{
	private DatagramSocket ds;
	public Send(DatagramSocket ds){
		this.ds = ds;
	}
	public void run(){
		try{
			Scanner sc = new Scanner(System.in);
			String line = null;
			while(true){
				line = sc.next();
				if(line.equals("886"))
					break;
				byte []buf = line.getBytes();
				DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.12.1"),8001);
				ds.send(dp);
			}
		}catch(Exception e){
			throw new RuntimeException("���Ͷ�ʧ��");
		}
	}
 }
 
// ������
class Recv implements Runnable{
	private DatagramSocket ds;
	public Recv(DatagramSocket ds){
		this.ds = ds;
	}
	public void run(){
		try{
			while(true){
				byte []buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf,buf.length);
				ds.receive(dp);
				String ip = dp.getAddress().getHostAddress();
				String data = new String(dp.getData(),0,dp.getLength());
				System.out.println(ip+": "+data);
			}
		}catch(Exception e){
			throw new RuntimeException("���ն�ʧ��");
		}
	}
 }
 
 // �ͻ���
class MulThreadSocket1{
	 public static void main(String []args) throws Exception{
		 DatagramSocket sendSocket = new DatagramSocket();
		 DatagramSocket recvSocket = new DatagramSocket(6001);
		 new Thread(new Send(sendSocket)).start();
		 new Thread(new Recv(recvSocket)).start();
	 }
 }