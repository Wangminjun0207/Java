// MulThreadSocket.java
/* 聊天程序
   有收数据的部分，也有发数据的部分
   这两部分同时执行，两线程完成
 */
import java.net.*;
import java.lang.String;
import java.util.Scanner;
import java.io.*;

// 发数据
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
			throw new RuntimeException("发送端失败");
		}
	}
 }
 
// 收数据
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
			throw new RuntimeException("接收端失败");
		}
	}
 }
 
 // 客户端
class MulThreadSocket1{
	 public static void main(String []args) throws Exception{
		 DatagramSocket sendSocket = new DatagramSocket();
		 DatagramSocket recvSocket = new DatagramSocket(6001);
		 new Thread(new Send(sendSocket)).start();
		 new Thread(new Recv(recvSocket)).start();
	 }
 }