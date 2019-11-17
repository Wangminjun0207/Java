// AwtDemo.java
/* 创建图形化界面
   1.创建Frame窗体
   2.对窗体进行基本的设置
   3.定义组件
   4.将组件通过窗体的add方法添加到窗体中
   5.让窗体显示，通过setvisible(true)方法
   
   
   事件监听机制
   1.事件源    awt包中的那些图形组件
   2.事件      每一个事件源都有自己的特有对应事件和共性事件
   3.监听器    将可以触发的事件的动作全部都封装到了监听器中
   4.事件处理  
   前三者已经全部封装，只需要获取事件用就可以
   用户要做的就是对产生的事件进行处理
   */
/*  WindowListener的子类WindowAdapter已经实现了WindowListener的接口
    并且覆盖其中的方法，只需要继承自WindowAdapter覆盖需要的方法即可*/
import java.awt.*;     // 图形化界面包
import java.awt.event.*; // 事件包

class MyWin extends WindowAdapter{
	// 关闭窗口事件
	public void windowClosing(WindowEvent e){
		System.exit(0);  // 退出程序，相对于C语言的exit(0)
	}
	// 窗口处于最前段事件
	public void windowActivaed(WindowEvent e){
	}
}

class AwtDemo{
	public static void main(String []args){
		// 创建一个窗体对象
		// 默认边界布局
		Frame f = new Frame("MyAwt");
		// 设置窗体大小
		f.setSize(500,400);     // 长，宽
		// 设置屏幕上的位置
		f.setLocation(300,200); // 距左边，距上边
		// 设置布局管理
		f.setLayout(new FlowLayout());
		// 创建一个按钮对象
		Button button = new Button("按钮");
		// 窗体添加按钮组件
		f.add(button);
		// 监听窗体事件
		f.addWindowListener(new MyWin());
		// 显示窗体
		f.setVisible(true);
	}
}

