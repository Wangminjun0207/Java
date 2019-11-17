// FileWriterDemo1.java
// IOException处理程序标准模板
import java.io.*;

class FileWriterDemo1{
	public static void main(String []args){
		FileWriter fw = null;
		try{
			fw = new FileWriter("Text\\file_demo.txt");
			fw.write("FileWriter");
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