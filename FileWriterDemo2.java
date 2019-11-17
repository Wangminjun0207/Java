// FileWriterDemo.java
// 演示对已有文件的数据续写
import java.io.*;

public class FileWriterDemo2{
	public static void main(String []args){
		FileWriter fw = null;
		try{
			// 传递一个true参数表示不覆盖，在文件末尾续写
			fw = new FileWriter("Text\\file_demo.txt",true);
			fw.write("FileWriter");
			// 续写，\r\nWindows表示换行
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