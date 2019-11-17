// TextTransClient.java
/* ����һ���ı�ת�����������ͻ��˸�����˷����ı���������תΪ��д֮�󷵻ؿͻ���
   �ͻ��˿���һֱ���ͣ�����over����
 1.����socket����
 2.��ȡ����¼��
 3.���ݷ��͸������
 4.��ȡ����˷��ص�����
 5.����֮��ر���Դ
*/


import java.net.*;
import java.io.*;
import java.lang.*;
class TextTransClient{
	public static void main(String []args)throws Exception{
		Socket s = new Socket("192.168.12.1",10010);
		BufferedReader bufr = 
			new BufferedReader(new InputStreamReader(System.in));
		// �����ݷ��͵�������
		BufferedWriter bufOut = 
			new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		// ���մӷ�����������������
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