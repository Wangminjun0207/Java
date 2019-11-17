// InputStreamDemo.java

import java.io.*;
import java.lang.String;

class InputStreamDemo{
	public static void main(String args[])throws IOException{
		FileInputStream ios = new FileInputStream("Text\\fos.txt");
		int ch = ios.read();
		System.out.print((char)ch);
		// 定义一个刚刚好的数组
		byte []buf = new byte[ios.available()];
		// 读取全部字节数据到数组中
		ios.read(buf);
		System.out.print(new String(buf));
		ios.close(); // 只关闭，不刷新
	}
}