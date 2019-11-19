// MulThreadDownload.java
/*
  多线程HTTP文件下载
*/

public class MulThreadDownload{
	public static void main(String []args){
		if(!ThrDownload.init("http://dl_dir.qq.com/qqfile/qd/QQ2012Beta1_QQProtect2.6.1.exe","2012.exe",3))
			System.out.println("线程初始化失败！");
		ThrControl p = new ThrControl();
		p.start();    // 启动主线程
	}
}