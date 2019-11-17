// TextTransClient.java
/* 建立一个文本转换服务器，客户端给服务端发送文本，服务器转为大写之后返回客户端
   客户端可以一直发送，输入over结束
 1.建立socket服务
 2.获取键盘录入
 3.数据发送给服务端
 4.读取服务端返回的数据
 5.结束之后关闭资源
*/


import java.net.*;
import java.io.*;
import java.lang.*;
class TextTransClient{
	public static void main(String []args)throws Exception{
		Socket s = new Socket("192.168.12.1",10010);
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));
		// 将数据发送到服务器
		BufferedWriter bufOut = 
			new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		// 接收从服务器发过来的数据
		BufferedReader bufIn = 
			new BufferedReader(new InputStreamReader(s.getInputStream()));
			
		String line = null;
		while((line=bufr.readLine())!=null){
			if("over".equals(line)){
				break;
			}
			bufOut.write(line);
			bufOut.newLine();
			bufOut.flush();
			String str = bufIn.readLine();
			System.out.println("server: "+str);
		}
		bufr.close();
		s.close();
 	}
}