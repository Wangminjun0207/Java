// TCPServer.java
import java.net.*;
import java.lang.String;
import java.util.Scanner;
import java.io.*;
// tcp��������
// ������յ�����Ҫ���ͻ��˷�������

class TCPServer{
	public static void main(String []srgs)throws Exception{
		// ��������˵�serversocket����
		ServerSocket ss = new ServerSocket(10086);
		// ͨ��accept��ȡ���Ŀͻ��˶���
		Socket s = ss.accept();
		// ��ȡ�ͻ��˵�������
		InputStream in = s.getInputStream();
		// Ϊ�˷������ݣ�Ӧ�û�ȡsocket�������
		OutputStream out = s.getOutputStream();
		// ��ȡ����
		byte []buf = new byte[1024];
		int len = in.read(buf);
		// ��ȡ�ͻ���IP��ַ
		String ip = s.getInetAddress().getHostAddress();
		// ���������̨
		System.out.println(ip+": "+new String(buf,0,len));
		// ���ͻ��˷�������
		out.write("return data".getBytes());
		// �رտͻ���
		s.close();
	}
}