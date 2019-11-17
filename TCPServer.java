// TCPServer.java
import java.net.*;
import java.lang.String;
import java.util.Scanner;
import java.io.*;
// tcp传输服务端
// 服务端收到数据要给客户端返回数据

class TCPServer{
	public static void main(String []srgs)throws Exception{
		// 创建服务端的serversocket服务
		ServerSocket ss = new ServerSocket(10086);
		// 通过accept获取连的客户端对象
		Socket s = ss.accept();
		// 获取客户端的输入流
		InputStream in = s.getInputStream();
		// 为了发送数据，应该获取socket的输出流
		OutputStream out = s.getOutputStream();
		// 获取数据
		byte []buf = new byte[1024];
		int len = in.read(buf);
		// 获取客户端IP地址
		String ip = s.getInetAddress().getHostAddress();
		// 输出到控制台
		System.out.println(ip+": "+new String(buf,0,len));
		// 给客户端返回数据
		out.write("return data".getBytes());
		// 关闭客户端
		s.close();
	}
}