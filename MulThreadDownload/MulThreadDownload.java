// MulThreadDownload.java
/*
  ���߳�HTTP�ļ�����
*/

public class MulThreadDownload{
	public static void main(String []args){
		if(!ThrDownload.init("http://dl_dir.qq.com/qqfile/qd/QQ2012Beta1_QQProtect2.6.1.exe","2012.exe",3))
			System.out.println("�̳߳�ʼ��ʧ�ܣ�");
		ThrControl p = new ThrControl();
		p.start();    // �������߳�
	}
}