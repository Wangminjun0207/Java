// Decrypt.java
// ʵ���ļ��Ľ��ܹ���
import java.io.*;
import java.lang.String;
class Decrypt{
	String fileName;// Ҫ���ܵ��ļ���
	int key;       // �ܳ�
	// ���캯��
	public Decrypt(String fileName){
		this.fileName = fileName;
	}
	// ���ܺ���
	public void decryptForFile()throws IOException{
		FileInputStream fis = new FileInputStream(fileName);
		FileOutputStream fos = new FileOutputStream("Text\\decryptFile.java");
		this.key = fis.read(); // �ļ���һ���ֽڵ��ܳ׶���
		while(true){
			int ch = fis.read();
			// �����ļ�ĩβ
			if(ch==-1){
				break;
			}
			ch = ch ^ this.key;  // ���ļ��ֽڽ���
			fos.write(ch); // ǿ��ת��Ϊ�ֽ�
		}
		fos.close();
		fis.close();
	}
}
public class Decryption{
	public static void main(String args[]){
		try{
			// �������ܶ���
			Decrypt decrypt = new Decrypt("Text\\encryptFile.java");
			decrypt.decryptForFile(); // ����
		}catch(IOException e){
		System.out.println(e.toString());
		}
	}
}