// FileWriterDemo.java
// �����ļ���д������
import java.io.*;
public class FileWriterDemo{
	public static void main(String []args) throws IOException{
		// ����һ��FileWriter���󣬸ö���һ����ʼ���ͱ�����ȷ�������Ķ���
		// ���Ҹ��ļ��ᱻ������ָ��Ŀ¼��
		// ������ļ��Ѿ���Ŀ¼�´����򱻸���
		FileWriter fw = new FileWriter("Text\\file_demo.txt");
		// ����write�������ַ���д�뵽��
		fw.write("FileWriter");
		// ����flush����ˢ�����е����ݣ�������ˢ��Ŀ�ĵ���
		fw.flush();
		// �ٴ����ļ�д��
		fw.write("demo");
		// �رմ������ͷ����������������ϵͳ��Դ���ر�֮ǰ�����һ����ˢ��
		fw.close();
	}
}