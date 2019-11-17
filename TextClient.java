// TextClient.java


import java.io.*;
import java.net.*;
class TextClient{
	public static void main(String []args)throws Exception{
		Socket s = new Socket("192.168.12.1",10088);
		BufferedReader bufr = 
			new BufferedReader(new FileReader("AwtDemo.java"));
		
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		String line = null;
		while((line=bufr.readLine())!=null){
			out.println(line);
		}
		out.println("over");
		BufferedReader bufIn = 
			new BufferedReader(new InputStreamReader(s.getInputStream()));
		line = bufIn.readLine();
		System.out.println(line);
		bufr.close();
		s.close();
	}
}