// Encryption.java
// ʵ���ļ��ļ��ܹ���
import java.io.*;
import java.lang.String;

class Encrypt{
	String fileName;// Ҫ���ܵ��ļ���
	int key;       // �ܳ�
	// ���캯��
	public Encrypt(String fileName, int key){
		this.fileName = fileName;
		this.key = key;
	}
	// ���ܺ���
	public void encryptForFile()throws IOException{
		FileInputStream fis = new FileInputStream(fileName);
		FileOutputStream fos = new FileOutputStream("Text\\encryptFile.java");
		fos.write(this.key); // ���ܳ�д���ļ���һ���ֽ�
		while(true){
			int ch = fis.read();
			// �����ļ�ĩβ
			if(ch==-1){
				break;
			}
			ch = ch ^ this.key;  // ���ļ��ֽڼ���
			fos.write(ch);
		}
		fos.close();
		fis.close();
	}
}
public class Encryption{
	public static void main(String args[]){
		try{
			// �������ܶ���
			Encrypt encrypt = new Encrypt("Text\\Test.java",'@');
			encrypt.encryptForFile(); // ����
		}catch(IOException e){
		System.out.println(e.toString());
		}
	}
}