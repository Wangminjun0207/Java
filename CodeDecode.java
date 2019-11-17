// CodeDecode.java
// 图形化界面实现编码解码
import java.lang.String;
import java.lang.Integer;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.JDialog;

class FrameCode{
	private Frame frame;     // 窗体
	private MenuBar menubar; // 菜单栏
	private Menu menu;       // 菜单
	private Button button;   // 确认获取密匙的button
	private MenuItem codeMenu, decodeMenu;  // 加密、解密菜单项
	private MenuItem compareMenu, exitMenu; // 比较、退出菜单项
	private MenuItem clearMenu;             // 清屏菜单项
	private FileDialog openDia, saveDia;    // 两个对话框
	private FileDialog fileDia1, fileDia2;  // 选择比较文件对话框
	private JDialog keyDia;              	// 获取密匙的对话框
	private	int key;         // 密匙
	private TextField text;  // 用来输入密匙的文本框
	private TextArea tarea;  // 输出比较结果的文本框
	private int count = 0;   // 计数器，辅助输出
	
	// 构造函数
	public FrameCode(){
		init();
	}
	
	// 初始化窗体函数
	private void init(){
		// 初始化窗体
		frame = new Frame("文件异或加密解密2017112381");
		frame.setBounds(400,300,800,500);// 设置窗体大小
		// 初始化比较结果的文本框
		tarea = new TextArea();
		//tarea.setColumns(30); 
		//tarea.setRows(10);
		frame.add(tarea);
		// 初始化菜单栏
		menubar = new MenuBar();
		menu = new Menu("程序菜单");
		codeMenu = new MenuItem("加密文件");
		decodeMenu = new MenuItem("解密文件");
		compareMenu = new MenuItem("对比两个文件");
		clearMenu = new MenuItem("清除屏幕");
		exitMenu = new MenuItem("退出程序");
		// button会有一个点击监听事件，按下的时候将输入框的密匙读到key中
		// 之所以要把button放在这里初始化是因为在myEvent函数中会报错java.lang.NullPointerException
		button = new Button("确认"); 
		// 菜单添加菜单项
		menu.add(codeMenu);
		menu.add(decodeMenu);
		menu.add(compareMenu);
		menu.add(clearMenu);
		menu.add(exitMenu);
		// 菜单栏添加菜单
		menubar.add(menu);
		// 窗体添加菜单栏
		frame.setMenuBar(menubar);
		myEvent();
		frame.setVisible(true); // 显示窗体
	}
	
	// 获取密匙
	private void getKey(){
		// 获取密匙
		keyDia = new JDialog(frame, "输入密匙"); 
		text = new TextField();
		text.setColumns(10); // 设置文本框列数
		keyDia.setLayout(new FlowLayout());
		keyDia.add(text);
		keyDia.add(button);
		keyDia.setBounds(600,400,300,200);
		keyDia.setVisible(true);
	}
	
	// 加密函数
	private void encryption(){
		// 创建被加密文件
		openDia = new FileDialog(frame,"被加密文件",FileDialog.LOAD);
		openDia.setVisible(true); // 弹出对话框
		String dirName = openDia.getDirectory(); // 获取目录名
		String fileName = openDia.getFile();     // 获取文件名
		File file = new File(dirName,fileName);
		
		// 创建加密文件
		saveDia = new FileDialog(frame,"加密文件",FileDialog.SAVE);
		saveDia.setVisible(true); // 弹出对话框
		String dirName1 = saveDia.getDirectory();  // 获取目录名
		String fileName1 = saveDia.getFile();      // 获取文件名
	
		// 如果文件存在
		if(file.exists()){
			FileInputStream fis = null;
			FileOutputStream fos = null;
			try{
				fis = new FileInputStream(file);
				fos = new FileOutputStream(dirName1+fileName1);
				fos.write(key); // 将密匙写到文件第一个字节
				while(true){
					int ch = fis.read();
					// 到达文件末尾
					if(ch==-1){
						break;
					}
					ch = ch ^ key;  // 对文件字节加密
					fos.write(ch);
				}
			}catch(IOException exception){
				// TODO
			}finally{
				try{
					fos.close();
					fis.close();
				}catch(IOException exception1){
					//TODO
				}
			}
		}
	}
	
	
	// 比较两文件的函数
	private boolean compare(){
		// 选择比较文件1
		fileDia1 = new FileDialog(frame,"对比文件1",FileDialog.LOAD);
		fileDia1.setVisible(true); // 弹出对话框
		String dirName = fileDia1.getDirectory(); // 获取目录名
		String fileName = fileDia1.getFile();     // 获取文件名
		File file1 = new File(dirName,fileName);
		
		// 选择比较文件2
		fileDia2 = new FileDialog(frame,"对比文件2",FileDialog.LOAD);
		fileDia2.setVisible(true); // 弹出对话框
		String dirName1 = fileDia2.getDirectory();  // 获取目录名
		String fileName1 = fileDia2.getFile();      // 获取文件名
		File file2 = new File(dirName1,fileName1);
		
		// 两文件的长度不同，直接返回不相等结果
		if(file1.length()!=file2.length()){
			return false;
		}
		FileInputStream fis1 = null;
		FileInputStream fis2 = null;
		try{
			fis1 = new FileInputStream(file1);
			fis2 = new FileInputStream(file2);
			while(true){
				int ch1 = fis1.read();
				int ch2 = fis2.read();
				// 出现字节不相等
				if(ch1!=ch2){
					return false;
				}
				// 两个文件都到达结尾并且相等
				else if(ch1==-1&&ch2==-1){
					return true;
				}
				// 其中一个文件到达结尾
				else if(ch1==-1 || ch2==-1){
					return false;
				}
			}
		}catch(IOException exception){
			// TODO
		}finally{
			try{
				fis1.close();
				fis2.close();
			}catch(IOException exception1){
				//TODO
			}
		}
		return false; // 如果此处返回可能文件都没打开
	}
	
	// 解密函数 openDia1, saveDia1
	private void decryption(){
		// 创建被解密文件
		openDia = new FileDialog(frame,"被解密文件",FileDialog.LOAD);
		openDia.setVisible(true); // 弹出对话框
		String dirName = openDia.getDirectory(); // 获取目录名
		String fileName = openDia.getFile();     // 获取文件名
		File file = new File(dirName,fileName);
		
		// 创建解密文件
		saveDia = new FileDialog(frame,"解密文件",FileDialog.SAVE);
		saveDia.setVisible(true); // 弹出对话框
		String dirName1 = saveDia.getDirectory();  // 获取目录名
		String fileName1 = saveDia.getFile();      // 获取文件名
		int key;  // 密匙
		// 如果文件存在
		if(file.exists()){
			FileInputStream fis = null;
			FileOutputStream fos = null;
			try{
				fis = new FileInputStream(file);
				fos = new FileOutputStream(dirName1+fileName1);
				key = fis.read(); // 读取密匙
				while(true){
					int ch = fis.read();
					// 到达文件末尾
					if(ch==-1){
						break;
					}
					ch = ch ^ key;  // 对文件字节解密
					fos.write(ch);
				}
			}catch(IOException exception){
				// TODO
			}finally{
				try{
					fos.close();
					fis.close();
				}catch(IOException exception1){
					//TODO
				}
			}
		}
	}
	
	// 事件处理函数
	private void myEvent(){
		frame.addWindowListener(new WindowAdapter()
		{
			// 窗体关闭
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		// 密匙确认按键的监听事件
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				key = Integer.valueOf(text.getText()).intValue();  // 获取用户输入的密匙
				keyDia.setVisible(false); // 关闭对话框
				tarea.append(count++ +". 密匙获取完成\r\n");
				encryption();    // 开始加密
				tarea.append(count++ +". 文件加密完成\r\n");
			}
		});
		// 退出程序事件监听
		exitMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		// 加密事件监听
		codeMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				// 为什么是加密调用的获取密匙函数，是因为获取密匙点了确定键才开始加密工作
				// 所以加密函数在button的事件处理函数调用
				getKey(); 
			}
		});
		// 解密事件监听
		decodeMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				decryption();
				tarea.append(count++ +". 文件解密完成\r\n");
			}
		});
		// 比较事件监听
		compareMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				boolean comp = compare();
				if(comp==true){
					tarea.append(count++ +". 对比完成，两个文件相同\r\n");
				}else{
					tarea.append(count++ +". 对比完成，两个文件不相同\r\n");
				}
			}
		});
		// 清屏事件监听
		clearMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				count=0;
				tarea.setText("");
			}
		});
	}
}
// 客户端代码
public class CodeDecode{
	public static void main(String args[]){
		FrameCode frame = new FrameCode();
	}
}