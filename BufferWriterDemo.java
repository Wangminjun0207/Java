// BufferWriterDemo.java
// 缓冲区的出现是为了提高流的操作效率
// 所以在创建缓冲区之前必须先有流对象

import java.io.*;

class BufferWriterDemo{
	public static void main(String []args)throws IOException{
		// 创建一个写入流对象
		FileWriter fw = new FileWriter("Text\\file_demo.txt");
		// 加入缓冲技术
		/* 两种构造函数
		 * BufferedWriter(fw)     缓冲区默认大小
		 * BufferedWriter(fw,len) 缓冲区指定大小
		 */
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("asdfghjkl");
		bw.newLine();  // 写入一个行分隔符
		bw.write("asdfghjkl");
		bw.flush();    // 刷新流
		
		// 关闭关联资源，关闭缓冲区的实质就是在关闭流
		bw.close();
	}
}