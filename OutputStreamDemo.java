// OutputStreamDemo.java

import java.io.*;

class OutputStreamDemo{
	public static void main(String args[])throws IOException{
		FileOutputStream fos = new FileOutputStream("Text\\fos.txt");
		fos.write("abcdef".getBytes());   // �ֵ���С���ʽ�����漰��ˢ��
		fos.close(); // ֻ�رգ���ˢ��
	}
}