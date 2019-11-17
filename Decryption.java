// Decrypt.java
// 实现文件的解密功能
import java.io.*;
import java.lang.String;
class Decrypt{
	String fileName;// 要解密的文件名
	int key;       // 密匙
	// 构造函数
	public Decrypt(String fileName){
		this.fileName = fileName;
	}
	// 解密函数
	public void decryptForFile()throws IOException{
		FileInputStream fis = new FileInputStream(fileName);
		FileOutputStream fos = new FileOutputStream("Text\\decryptFile.java");
		this.key = fis.read(); // 文件第一个字节的密匙读出
		while(true){
			int ch = fis.read();
			// 到达文件末尾
			if(ch==-1){
				break;
			}
			ch = ch ^ this.key;  // 对文件字节解密
			fos.write(ch); // 强制转换为字节
		}
		fos.close();
		fis.close();
	}
}
public class Decryption{
	public static void main(String args[]){
		try{
			// 创建解密对象
			Decrypt decrypt = new Decrypt("Text\\encryptFile.java");
			decrypt.decryptForFile(); // 解密
		}catch(IOException e){
		System.out.println(e.toString());
		}
	}
}