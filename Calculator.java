import java.awt.*;              //��������幤�߰�
import javax.swing.*;           //����ͼ���û�����İ�
import java.awt.event.*;
 
//��岼����
public class Calculator extends JFrame implements ActionListener  //�Զ���һ�����ֿ����Calculator�̳�JFrame
{
        Container cp; 
        JPanel pnl[] = new JPanel[3];           //����һ���������Ϊ���������������
        JTextField text;                        //����һ���ı���
        double num[]={0, 0};                    //���������������ڴ洢��ֵ
        int index=0;                            //����ָ������num[0]��num[1]
        char oper;                              //�����
        String s[]={    "toDegrees","toRadians","Backapace","Clear",
                        "7","8","9","/","sqrt",
                        "4","5","6","*","%",
                        "1","2","3","-","1/x",
                        "0","+/-",".","+","=",
                        "sin","cos","tan","cot","HEX"};
        JButton button[] = new JButton[29];
        Calculator()
        {       
                setTitle("������2017112381");     //���ô���ı���
                setSize(400, 240);                //���ô���Ĵ�С
                setLocation(400, 200);            //���ô������ʾλ��
                cp=getContentPane();
 
                //��pnl[i]��ӵ�����cp�У���"North","Center","South"����
                String str[]={"North","Center","South"};
                for(int i=0; i<3; i++)
                {       pnl[i] = new JPanel();
                        cp.add(pnl[i],str[i]);
                }
 
                pnl[0].setLayout(new GridLayout(1,1));
                pnl[1].setLayout(new GridLayout(1,4));
                pnl[2].setLayout(new GridLayout(5,5));
 
                text = new JTextField(25);
                text.setText("0");
                text.setHorizontalAlignment(JTextField.RIGHT);  //�ı��Ҷ���
                text.setEditable(false);                        //�ı��򲻿ɱ༭
                text.setBackground(new Color(255, 255, 255));   //���ñ���ɫ
 
                //��pnl[i]����Ӱ�ť
                pnl[0].add(text);
                for(int i=0; i<29; i++)
                {
                        button[i] = new JButton(s[i]);
                        if(i<=3)pnl[1].add(button[i]);
                        else pnl[2].add(button[i]);
 
                        button[i].addActionListener(this);           //��Ӱ�ť�¼�����
 
                        //�������°�ťǰ��ɫΪ��ɫ
                        if(i<=3 || i%5==2 || i==23)button[i].setForeground(new Color(255,0,0));
                }
                setVisible(true);                               //��ʾ����
                setDefaultCloseOperation(EXIT_ON_CLOSE);        //�˳�����ʱ�رմ���     
        }
 
        public void actionPerformed(ActionEvent e)              //�¼���Ӧ
        {
                Object tmp = e.getSource();                     //��ȡ�¼�Դ
                String str = text.getText();
 
                if(tmp==button[2] && str.length()>0) str=str.substring(0, str.length()-1);//�˸��
                else if(tmp==button[3]){ str=""; index=0; num[0]=0; num[1]=0;}//��ռ�
 
                //�ַ�����
                if(tmp==button[4] || tmp==button[5] || tmp==button[6] || tmp==button[9] || tmp==button[10] || tmp==button[11] || 
                        tmp==button[14] || tmp==button[15] || tmp==button[16] || tmp==button[19] || tmp==button[21])
                {
                        if(tmp==button[4]) str += '7';
                        else if(tmp==button[5]) str += '8';
                        else if(tmp==button[6]) str += '9';
									 
                        else if(tmp==button[9]) str += '4';
                        else if(tmp==button[10]) str += '5';
                        else if(tmp==button[11]) str += '6';
									 
                        else if(tmp==button[14]) str += '1';
                        else if(tmp==button[15]) str += '2';
                        else if(tmp==button[16]) str += '3';
									 
                        else if(tmp==button[19]) str += '0';
                        else if(tmp==button[21]) if(str.indexOf('.') == -1) str += '.';      //��һ��С����ʱ�������
                
                        if(index==0) num[0] = Double.parseDouble(str);                  //��������ַ���ת������ֵ���洢��num��
                        else num[1] = Double.parseDouble(str);
                }
 
                //���������
                else if(tmp==button[7] || tmp==button[12] || tmp==button[13] || tmp==button[17] || tmp==button[22])
                {
                        if(tmp==button[7]) oper='/';
                        else if(tmp==button[12]) oper='*';
                        else if(tmp==button[13]) oper='%';
                        else if(tmp==button[17]) oper='-';
                        else if(tmp==button[22]) oper='+';
 
                        index=1;
                        str="";
                }
 
                else if(tmp==button[23])                     //" == "���������
                {
                        if(oper=='/' || oper=='*' || oper=='%' || oper=='-' || oper=='+')
                        {
                                if(oper=='/'){ num[0]/=num[1];}
                                else if(oper=='*'){ num[0]*=num[1];}
                                else if(oper=='%'){ num[0]%=num[1];}
                                else if(oper=='-'){ num[0]-=num[1];}
                                else if(oper=='+'){ num[0]+=num[1];}
 
                                index=0; 
                                num[1]=0;                       //���num[1]�е���ֵ
                                str=Double.toString(num[index]);
                        }
                }
 
                //��Ŀ����
                if(tmp==button[0] || tmp==button[1] || tmp==button[8] || tmp==button[18] || tmp==button[20] || tmp==button[24] || 
                        tmp==button[25] || tmp==button[26] || tmp==button[27])
                {
                        if(tmp==button[0]) num[index]=java.lang.Math.toDegrees(num[index]);  //����->�Ƕ�
                        if(tmp==button[1]) num[index]=java.lang.Math.toRadians(num[index]);  //�Ƕ�->����
                        if(tmp==button[8]) if(num[index]>=0) num[index]=java.lang.Math.sqrt(num[index]);
                        if(tmp==button[18]) num[index]=1/num[index];                         //����
                        if(tmp==button[20]) num[index]=-num[index];                          //�����任
                        if(tmp==button[24]) num[index]=java.lang.Math.sin(num[index]);       //����
                        if(tmp==button[25]) num[index]=java.lang.Math.cos(num[index]);
                        if(tmp==button[26]) num[index]=java.lang.Math.tan(num[index]);
                        if(tmp==button[27]) num[index]=1/java.lang.Math.tan(num[index]);
 
                        str=Double.toString(num[index]);                //����str
                }
                
                if(tmp==button[28])       //��num[index]ת����16���Ƶ��ַ���
                {
                        int num1=(int)num[index], num2=0, oper=0;
                        char tmpC;
                        str="";
                        if(num1<0){ num1=-num1; oper=1;}  //ת��Ϊ����
                        while(num1!=0)
                        {
                                num2=num1%16;
                                if(num2>9)tmpC=(char)('A'+num2-10);
                                else tmpC=(char)('0'+num2);
 
                                str=tmpC+str;
                                num1/=16;
                        }
                        if(oper==1)str='-'+str;  //�Ǹ���ʱstr��Ӹ���
                }
 
                text.setText(str);   //�����ı����е���ʾ����
        }
 
 
        public static void main(String[] args) 
        {
                new Calculator();   //����һ�����ִ���
        }
}
