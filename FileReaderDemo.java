// FielReaderDemo.java
// 文件中的字符读取
import java.io.*;
import java.lang.String;

class FileReaderDemo{
	public static void main(String []args) throws IOException{
		// 创建一个文件读取流，和指定的文件关联
		// 要保证该文件时已经存在的，如果不存在会抛出异常FileNotFoundException
		// 异常FileNotFoundException是IOExcepton的子类
		FileReader fr = new FileReader("Text\\file_demo.txt");
		// 读取一个字符，而且自动往下读
		int ch1 = fr.read(); 
		int ch2 = fr.read(); 
		// 读到的单个字符时int类型的，需要进行强制转换
		System.out.println("ch1:"+(char)ch1+"   ch2:"+(char)ch2);
		
		// 如果要判断是否读到结尾，判断read返回的是否是-1
		
		// 使用字符书序读取字符串
		char buf[] = new char[50];
		int num = fr.read(buf);
		System.out.println("num:"+num+"   buf:"+new String(buf,0,num)); 
		
		fr.close();
	}
}