// socketDemo.java

import java.net.*;
import java.lang.String;
import java.util.Scanner;
import java.io.*;
/* ���Ͷ�
	1.����udp socket����
	2.�ṩ���ݣ��������ݷ�װ�����ݰ�
	3.ͨ��socket�����͹��ܷ������ݰ�
	4.�ر���Դ
 */
class UDPSendDemo{
	public static void main(String []args)throws Exception{
		// ����udp����
		DatagramSocket ds = new DatagramSocket();
		Scanner sc = new Scanner(System.in);
		while(true){
			// ȷ������
			String str = sc.next();
			if(str.equals("886")){
				break;
			}
			byte []buf = str.getBytes();
			DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("192.168.12.1"),7000);
			// ͨ��socket�����͹��ܷ������ݰ�
			ds.send(dp);
		}
		// �ر���Դ
		ds.close();
	}
}

/* ���ն�
   1.����udp��socket����
   2.����һ�����ݰ������ڽ�������
   3.ͨ��receive�������յ������ݴ浽���ݰ�
   4.ͨ�����ݰ�����ķ�������ͬ��������ȡ
*/
class UDPRecvDemo{
	public static void main(String []args)throws Exception{
		// ����udp��������Ĭ�϶˿�10000
		DatagramSocket ds = new DatagramSocket(8000);
		// һֱ����
		while(true){
			// �������ݰ������ڴ洢��������
			byte []buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf,buf.length);
			// ͨ��receive�������յ������ݴ浽���ݰ�
			ds.receive(dp);
			// ��ȡ����
			String ip = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(),0,dp.getLength());
			System.out.println(ip+": "+data);
		}
	}
}