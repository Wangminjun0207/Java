// TCPClient.java
import java.net.*;
import java.lang.String;
import java.util.Scanner;
import java.io.*;
// tcp����ͻ���
// ������˷������ݲ����շ���˷��ص�����
/*
 1.����socket����ָ�����������Ͷ˿�
 2.��ȡsocket���е��������������д�����У�ͨ�����緢�ͷ����
 3.��ȡsocket���е�����������ȡ����˷��ص�����
 4.�رտͻ���
 */

class TCPClient{
	public static void main(String []srgs)throws Exception{
		// �����ͻ��˵�socket����ָ��Ŀ�������Ͷ˿�
		Socket s = new Socket("192.168.12.1",10086);
		// Ϊ�˷������ݣ�Ӧ�û�ȡsocket�������
		OutputStream out = s.getOutputStream();
		// ���������������
		out.write("tcp data".getBytes());
		// ��ȡ���ص�����
		InputStream in = s.getInputStream();
		byte []buf = new byte[1024];
		int len = in.read(buf);
		System.out.println(new String(buf,0,len));
		// �ر�socket����
		s.close();
	}
}