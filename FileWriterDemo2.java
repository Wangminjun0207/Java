// FileWriterDemo.java
// ��ʾ�������ļ���������д
import java.io.*;

public class FileWriterDemo2{
	public static void main(String []args){
		FileWriter fw = null;
		try{
			// ����һ��true������ʾ�����ǣ����ļ�ĩβ��д
			fw = new FileWriter("Text\\file_demo.txt",true);
			fw.write("FileWriter");
			// ��д��\r\nWindows��ʾ����
			fw.write("\r\ndemo");
		}
		catch(IOException e){
			System.out.println(e.toString());
		}
		finally{
			try{
				if(null!=fw)
					fw.close();
			}
			catch(IOException e){
				System.out.println(e.toString());
			}
		}
	}
} 