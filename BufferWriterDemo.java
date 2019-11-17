// BufferWriterDemo.java
// �������ĳ�����Ϊ��������Ĳ���Ч��
// �����ڴ���������֮ǰ��������������

import java.io.*;

class BufferWriterDemo{
	public static void main(String []args)throws IOException{
		// ����һ��д��������
		FileWriter fw = new FileWriter("Text\\file_demo.txt");
		// ���뻺�弼��
		/* ���ֹ��캯��
		 * BufferedWriter(fw)     ������Ĭ�ϴ�С
		 * BufferedWriter(fw,len) ������ָ����С
		 */
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("asdfghjkl");
		bw.newLine();  // д��һ���зָ���
		bw.write("asdfghjkl");
		bw.flush();    // ˢ����
		
		// �رչ�����Դ���رջ�������ʵ�ʾ����ڹر���
		bw.close();
	}
}