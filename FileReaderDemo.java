// FielReaderDemo.java
// �ļ��е��ַ���ȡ
import java.io.*;
import java.lang.String;

class FileReaderDemo{
	public static void main(String []args) throws IOException{
		// ����һ���ļ���ȡ������ָ�����ļ�����
		// Ҫ��֤���ļ�ʱ�Ѿ����ڵģ���������ڻ��׳��쳣FileNotFoundException
		// �쳣FileNotFoundException��IOExcepton������
		FileReader fr = new FileReader("Text\\file_demo.txt");
		// ��ȡһ���ַ��������Զ����¶�
		int ch1 = fr.read(); 
		int ch2 = fr.read(); 
		// �����ĵ����ַ�ʱint���͵ģ���Ҫ����ǿ��ת��
		System.out.println("ch1:"+(char)ch1+"   ch2:"+(char)ch2);
		
		// ���Ҫ�ж��Ƿ������β���ж�read���ص��Ƿ���-1
		
		// ʹ���ַ������ȡ�ַ���
		char buf[] = new char[50];
		int num = fr.read(buf);
		System.out.println("num:"+num+"   buf:"+new String(buf,0,num)); 
		
		fr.close();
	}
}