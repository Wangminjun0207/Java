// socketDemo.java

import java.net.*;
import java.lang.String;
import java.util.Scanner;
import java.io.*;
/* 发送端
	1.建立udp socket服务
	2.提供数据，并将数据封装到数据包
	3.通过socket服务发送功能发送数据包
	4.关闭资源
 */
class UDPSendDemo{
	public static void main(String []args)throws Exception{
		// 创建udp服务
		DatagramSocket ds = new DatagramSocket();
		Scanner sc = new Scanner(System.in);
		while(true){
			// 确定数据
			String str = sc.next();
			if(str.equals("886")){
				break;
			}
			byte []buf = str.getBytes();
			DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.12.1"),7000);
			// 通过socket服务发送功能发送数据包
			ds.send(dp);
		}
		// 关闭资源
		ds.close();
	}
}

/* 接收端
   1.定义udp的socket服务
   2.定义一个数据包，用于接收数据
   3.通过receive方法将收到的数据存到数据包
   4.通过数据包对象的方法将不同的数据提取
*/
class UDPRecvDemo{
	public static void main(String []args)throws Exception{
		// 创建udp服务，设置默认端口10000
		DatagramSocket ds = new DatagramSocket(8000);
		// 一直监听
		while(true){
			// 定义数据包，用于存储接收数据
			byte []buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf,buf.length);
			// 通过receive方法将收到的数据存到数据包
			ds.receive(dp);
			// 提取数据
			String ip = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(),0,dp.getLength());
			System.out.println(ip+": "+data);
		}
	}
}