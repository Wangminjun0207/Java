// AwtDemo.java
/* ����ͼ�λ�����
   1.����Frame����
   2.�Դ�����л���������
   3.�������
   4.�����ͨ�������add������ӵ�������
   5.�ô�����ʾ��ͨ��setvisible(true)����
   
   
   �¼���������
   1.�¼�Դ    awt���е���Щͼ�����
   2.�¼�      ÿһ���¼�Դ�����Լ������ж�Ӧ�¼��͹����¼�
   3.������    �����Դ������¼��Ķ���ȫ������װ���˼�������
   4.�¼�����  
   ǰ�����Ѿ�ȫ����װ��ֻ��Ҫ��ȡ�¼��þͿ���
   �û�Ҫ���ľ��ǶԲ������¼����д���
   */
/*  WindowListener������WindowAdapter�Ѿ�ʵ����WindowListener�Ľӿ�
    ���Ҹ������еķ�����ֻ��Ҫ�̳���WindowAdapter������Ҫ�ķ�������*/
import java.awt.*;     // ͼ�λ������
import java.awt.event.*; // �¼���

class MyWin extends WindowAdapter{
	// �رմ����¼�
	public void windowClosing(WindowEvent e){
		System.exit(0);  // �˳����������C���Ե�exit(0)
	}
	// ���ڴ�����ǰ���¼�
	public void windowActivaed(WindowEvent e){
	}
}

class AwtDemo{
	public static void main(String []args){
		// ����һ���������
		// Ĭ�ϱ߽粼��
		Frame f = new Frame("MyAwt");
		// ���ô����С
		f.setSize(500,400);     // ������
		// ������Ļ�ϵ�λ��
		f.setLocation(300,200); // ����ߣ����ϱ�
		// ���ò��ֹ���
		f.setLayout(new FlowLayout());
		// ����һ����ť����
		Button button = new Button("��ť");
		// ������Ӱ�ť���
		f.add(button);
		// ���������¼�
		f.addWindowListener(new MyWin());
		// ��ʾ����
		f.setVisible(true);
	}
}

