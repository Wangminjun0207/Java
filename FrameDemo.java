// FrameDemo.java
import java.awt.*;
import java.awt.event.*;

class MyFrame{
	// �����ͼ��������Ҫ���������
	private Frame f;
	private Button button;
	
	// ���캯��
	MyFrame(){
		init();
	}
	// ��ʼ������
	public void init(){
		f = new Frame("MyFrame");
		// �Դ�����л�������
		f.setSize(500,400);
		f.setLocation(500,400);
		f.setLayout(new FlowLayout());
		button = new Button("MyButton");
		// �������ӵ�����
		f.add(button);
		// ���ش����¼�
		myEvent();
		// ��ʾ����
		f.setVisible(true);	
	}
	// �¼�����
	private void myEvent(){
		f.addWindowListener(new WindowAdapter(){
			// ����ر�
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		// ����ť����˳�����Ĺ���
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}
}
class FrameDemo{
	public static void main(String args[]){
		new MyFrame();
	}
}