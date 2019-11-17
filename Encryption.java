// Encryption.java
// 实现文件的加密功能
import java.io.*;
import java.lang.String;

class Encrypt{
	String fileName;// 要加密的文件名
	int key;       // 密匙
	// 构造函数
	public Encrypt(String fileName, int key){
		this.fileName = fileName;
		this.key = key;
	}
	// 加密函数
	public void encryptForFile()throws IOException{
		FileInputStream fis = new FileInputStream(fileName);
		FileOutputStream fos = new FileOutputStream("Text\\encryptFile.java");
		fos.write(this.key); // 将密匙写到文件第一个字节
		while(true){
			int ch = fis.read();
			// 到达文件末尾
			if(ch==-1){
				break;
			}
			ch = ch ^ this.key;  // 对文件字节加密
			fos.write(ch);
		}
		fos.close();
		fis.close();
	}
}
public class Encryption{
	public static void main(String args[]){
		try{
			// 创建加密对象
			Encrypt encrypt = new Encrypt("Text\\Test.java",'@');
			encrypt.encryptForFile(); // 加密
		}catch(IOException e){
		System.out.println(e.toString());
		}
	}
}