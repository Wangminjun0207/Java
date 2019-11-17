// TextServer.java


import java.io.*;
import java.net.*;
class TextServer{
	public static void main(String []args)throws Exception{
		ServerSocket ss = new ServerSocket(10088);
		Socket s = ss.accept();
		BufferedReader bufIn = 
			new BufferedReader(new InputStreamReader(s.getInputStream()));
		PrintWriter out = new PrintWriter(new FileWriter("server.java"),true);
		String line = null;
		while((line=bufIn.readLine())!=null){
			if("over".equals(line))
				break;
			out.println(line);
		}
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		pw.println("·¢ËÍ³É¹¦");
		out.close();
		s.close();
		ss.close();
	}
}