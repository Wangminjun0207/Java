// FrameDemo.java
import java.awt.*;
import java.awt.event.*;

class MyFrame{
	// 定义该图形中所需要的组件引用
	private Frame f;
	private Button button;
	
	// 构造函数
	MyFrame(){
		init();
	}
	// 初始化函数
	public void init(){
		f = new Frame("MyFrame");
		// 对窗体进行基本设置
		f.setSize(500,400);
		f.setLocation(500,400);
		f.setLayout(new FlowLayout());
		button = new Button("MyButton");
		// 将组件添加到窗体
		f.add(button);
		// 加载窗体事件
		myEvent();
		// 显示窗体
		f.setVisible(true);	
	}
	// 事件处理
	private void myEvent(){
		f.addWindowListener(new WindowAdapter(){
			// 窗体关闭
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		// 给按钮添加退出程序的功能
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