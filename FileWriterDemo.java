// FileWriterDemo.java
// 创建文件并写入数据
import java.io.*;
public class FileWriterDemo{
	public static void main(String []args) throws IOException{
		// 创建一个FileWriter对象，该对象一被初始化就必须明确被操作的对象
		// 而且该文件会被创建到指定目录下
		// 如果此文件已经在目录下存在则被覆盖
		FileWriter fw = new FileWriter("Text\\file_demo.txt");
		// 调用write方法将字符串写入到流
		fw.write("FileWriter");
		// 调用flush方法刷新流中的数据，将数据刷到目的地中
		fw.flush();
		// 再次向文件写入
		fw.write("demo");
		// 关闭此流并释放与该流关联的所有系统资源，关闭之前会完成一次流刷新
		fw.close();
	}
}