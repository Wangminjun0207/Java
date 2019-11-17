// CopyPicture.java
// ¸´ÖÆÒ»¸öÍ¼Æ¬

import java.io.*;

class CopyPicture{
	public static void main(String []args)throws IOException{
		FileOutputStream fos = new FileOutputStream("Text\\2.jpg");
		FileInputStream fis = new FileInputStream("Text\\1.jpg");
		byte buf[] = new byte[1024];
		int len = 0;
		while((len=fis.read(buf))!=-1){
			fos.write(buf,0,len);
		}
		fis.close();
		fos.close();
	}
}