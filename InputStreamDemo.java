// InputStreamDemo.java

import java.io.*;
import java.lang.String;

class InputStreamDemo{
	public static void main(String args[])throws IOException{
		FileInputStream ios = new FileInputStream("Text\\fos.txt");
		int ch = ios.read();
		System.out.print((char)ch);
		// ����һ���ոպõ�����
		byte []buf = new byte[ios.available()];
		// ��ȡȫ���ֽ����ݵ�������
		ios.read(buf);
		System.out.print(new String(buf));
		ios.close(); // ֻ�رգ���ˢ��
	}
}