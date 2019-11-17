// TextTransServer.java

import java.net.*;
import java.io.*;
import java.lang.*;
class TextTransServer{
	public static void main(String []args)throws Exception{
		ServerSocket ss = new ServerSocket(10010);
		Socket s = ss.accept();
		
		// ��ȡ���е�����
		BufferedReader bufIn = 
			new BufferedReader(new InputStreamReader(s.getInputStream()));
		// ����д����д�뵽����������͸��ͻ���
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