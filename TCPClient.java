// TCPClient.java
import java.net.*;
import java.lang.String;
import java.util.Scanner;
import java.io.*;
// tcp传输客户端
// 给服务端发送数据并接收服务端返回的数据
/*
 1.建立socket服务，指定连接主机和端口
 2.获取socket流中的输出流，将数据写到流中，通过网络发送服务端
 3.获取socket流中的输入流，读取服务端返回的数据
 4.关闭客户端
 */

class TCPClient{
	public static void main(String []srgs)throws Exception{
		// 创建客户端的socket服务，指定目的主机和端口
		Socket s = new Socket("192.168.12.1",10086);
		// 为了发送数据，应该获取socket的输出流
		OutputStream out = s.getOutputStream();
		// 向服务器发送数据
		out.write("tcp data".getBytes());
		// 读取返回的数据
		InputStream in = s.getInputStream();
		byte []buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		// 关闭socket服务
		s.close();
	}
}