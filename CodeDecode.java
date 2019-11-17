// CodeDecode.java
// ͼ�λ�����ʵ�ֱ������
import java.lang.String;
import java.lang.Integer;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.JDialog;

class FrameCode{
	private Frame frame;     // ����
	private MenuBar menubar; // �˵���
	private Menu menu;       // �˵�
	private Button button;   // ȷ�ϻ�ȡ�ܳ׵�button
	private MenuItem codeMenu, decodeMenu;  // ���ܡ����ܲ˵���
	private MenuItem compareMenu, exitMenu; // �Ƚϡ��˳��˵���
	private MenuItem clearMenu;             // �����˵���
	private FileDialog openDia, saveDia;    // �����Ի���
	private FileDialog fileDia1, fileDia2;  // ѡ��Ƚ��ļ��Ի���
	private JDialog keyDia;              	// ��ȡ�ܳ׵ĶԻ���
	private	int key;         // �ܳ�
	private TextField text;  // ���������ܳ׵��ı���
	private TextArea tarea;  // ����ȽϽ�����ı���
	private int count = 0;   // ���������������
	
	// ���캯��
	public FrameCode(){
		init();
	}
	
	// ��ʼ�����庯��
	private void init(){
		// ��ʼ������
		frame = new Frame("�ļ������ܽ���2017112381");
		frame.setBounds(400,300,800,500);// ���ô����С
		// ��ʼ���ȽϽ�����ı���
		tarea = new TextArea();
		//tarea.setColumns(30); 
		//tarea.setRows(10);
		frame.add(tarea);
		// ��ʼ���˵���
		menubar = new MenuBar();
		menu = new Menu("����˵�");
		codeMenu = new MenuItem("�����ļ�");
		decodeMenu = new MenuItem("�����ļ�");
		compareMenu = new MenuItem("�Ա������ļ�");
		clearMenu = new MenuItem("�����Ļ");
		exitMenu = new MenuItem("�˳�����");
		// button����һ����������¼������µ�ʱ���������ܳ׶���key��
		// ֮����Ҫ��button���������ʼ������Ϊ��myEvent�����лᱨ��java.lang.NullPointerException
		button = new Button("ȷ��"); 
		// �˵���Ӳ˵���
		menu.add(codeMenu);
		menu.add(decodeMenu);
		menu.add(compareMenu);
		menu.add(clearMenu);
		menu.add(exitMenu);
		// �˵�����Ӳ˵�
		menubar.add(menu);
		// ������Ӳ˵���
		frame.setMenuBar(menubar);
		myEvent();
		frame.setVisible(true); // ��ʾ����
	}
	
	// ��ȡ�ܳ�
	private void getKey(){
		// ��ȡ�ܳ�
		keyDia = new JDialog(frame, "�����ܳ�"); 
		text = new TextField();
		text.setColumns(10); // �����ı�������
		keyDia.setLayout(new FlowLayout());
		keyDia.add(text);
		keyDia.add(button);
		keyDia.setBounds(600,400,300,200);
		keyDia.setVisible(true);
	}
	
	// ���ܺ���
	private void encryption(){
		// �����������ļ�
		openDia = new FileDialog(frame,"�������ļ�",FileDialog.LOAD);
		openDia.setVisible(true); // �����Ի���
		String dirName = openDia.getDirectory(); // ��ȡĿ¼��
		String fileName = openDia.getFile();     // ��ȡ�ļ���
		File file = new File(dirName,fileName);
		
		// ���������ļ�
		saveDia = new FileDialog(frame,"�����ļ�",FileDialog.SAVE);
		saveDia.setVisible(true); // �����Ի���
		String dirName1 = saveDia.getDirectory();  // ��ȡĿ¼��
		String fileName1 = saveDia.getFile();      // ��ȡ�ļ���
	
		// ����ļ�����
		if(file.exists()){
			FileInputStream fis = null;
			FileOutputStream fos = null;
			try{
				fis = new FileInputStream(file);
				fos = new FileOutputStream(dirName1+fileName1);
				fos.write(key); // ���ܳ�д���ļ���һ���ֽ�
				while(true){
					int ch = fis.read();
					// �����ļ�ĩβ
					if(ch==-1){
						break;
					}
					ch = ch ^ key;  // ���ļ��ֽڼ���
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
	
	
	// �Ƚ����ļ��ĺ���
	private boolean compare(){
		// ѡ��Ƚ��ļ�1
		fileDia1 = new FileDialog(frame,"�Ա��ļ�1",FileDialog.LOAD);
		fileDia1.setVisible(true); // �����Ի���
		String dirName = fileDia1.getDirectory(); // ��ȡĿ¼��
		String fileName = fileDia1.getFile();     // ��ȡ�ļ���
		File file1 = new File(dirName,fileName);
		
		// ѡ��Ƚ��ļ�2
		fileDia2 = new FileDialog(frame,"�Ա��ļ�2",FileDialog.LOAD);
		fileDia2.setVisible(true); // �����Ի���
		String dirName1 = fileDia2.getDirectory();  // ��ȡĿ¼��
		String fileName1 = fileDia2.getFile();      // ��ȡ�ļ���
		File file2 = new File(dirName1,fileName1);
		
		// ���ļ��ĳ��Ȳ�ͬ��ֱ�ӷ��ز���Ƚ��
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
				// �����ֽڲ����
				if(ch1!=ch2){
					return false;
				}
				// �����ļ��������β�������
				else if(ch1==-1&&ch2==-1){
					return true;
				}
				// ����һ���ļ������β
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
		return false; // ����˴����ؿ����ļ���û��
	}
	
	// ���ܺ��� openDia1, saveDia1
	private void decryption(){
		// �����������ļ�
		openDia = new FileDialog(frame,"�������ļ�",FileDialog.LOAD);
		openDia.setVisible(true); // �����Ի���
		String dirName = openDia.getDirectory(); // ��ȡĿ¼��
		String fileName = openDia.getFile();     // ��ȡ�ļ���
		File file = new File(dirName,fileName);
		
		// ���������ļ�
		saveDia = new FileDialog(frame,"�����ļ�",FileDialog.SAVE);
		saveDia.setVisible(true); // �����Ի���
		String dirName1 = saveDia.getDirectory();  // ��ȡĿ¼��
		String fileName1 = saveDia.getFile();      // ��ȡ�ļ���
		int key;  // �ܳ�
		// ����ļ�����
		if(file.exists()){
			FileInputStream fis = null;
			FileOutputStream fos = null;
			try{
				fis = new FileInputStream(file);
				fos = new FileOutputStream(dirName1+fileName1);
				key = fis.read(); // ��ȡ�ܳ�
				while(true){
					int ch = fis.read();
					// �����ļ�ĩβ
					if(ch==-1){
						break;
					}
					ch = ch ^ key;  // ���ļ��ֽڽ���
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
	
	// �¼�������
	private void myEvent(){
		frame.addWindowListener(new WindowAdapter()
		{
			// ����ر�
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		// �ܳ�ȷ�ϰ����ļ����¼�
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				key = Integer.valueOf(text.getText()).intValue();  // ��ȡ�û�������ܳ�
				keyDia.setVisible(false); // �رնԻ���
				tarea.append(count++ +". �ܳ׻�ȡ���\r\n");
				encryption();    // ��ʼ����
				tarea.append(count++ +". �ļ��������\r\n");
			}
		});
		// �˳������¼�����
		exitMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		// �����¼�����
		codeMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				// Ϊʲô�Ǽ��ܵ��õĻ�ȡ�ܳ׺���������Ϊ��ȡ�ܳ׵���ȷ�����ſ�ʼ���ܹ���
				// ���Լ��ܺ�����button���¼�����������
				getKey(); 
			}
		});
		// �����¼�����
		decodeMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				decryption();
				tarea.append(count++ +". �ļ��������\r\n");
			}
		});
		// �Ƚ��¼�����
		compareMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				boolean comp = compare();
				if(comp==true){
					tarea.append(count++ +". �Ա���ɣ������ļ���ͬ\r\n");
				}else{
					tarea.append(count++ +". �Ա���ɣ������ļ�����ͬ\r\n");
				}
			}
		});
		// �����¼�����
		clearMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				count=0;
				tarea.setText("");
			}
		});
	}
}
// �ͻ��˴���
public class CodeDecode{
	public static void main(String args[]){
		FrameCode frame = new FrameCode();
	}
}