// TextTransServer.java

import java.net.*;
import java.io.*;
import java.lang.*;
class TextTransServer{
	public static void main(String []args)throws Exception{
		ServerSocket ss = new ServerSocket(10010);
		Socket s = ss.accept();
		
		// 读取流中的数据
		BufferedReader bufIn = 
			new BufferedReader(new InputStreamReader(s.getInputStream()));
		// 将大写数据写入到输出流并发送给客户端
		BufferedWriter bufOut = 
			new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		String line = null;
		while((line=bufIn.readLine())!=null){
			System.out.println(line);
			bufOut.write(line.toUpperCase());
			bufOut.newLine();
			bufOut.flush();
		}
		s.close();
		ss.close();
	}
}