import java.awt.*;              //引入抽象窗体工具包
import javax.swing.*;           //引入图形用户界面的包
import java.awt.event.*;
 
//面板布局类
public class Calculator extends JFrame implements ActionListener  //自定义一个布局框架类Calculator继承JFrame
{
        Container cp; 
        JPanel pnl[] = new JPanel[3];           //定义一个主面板作为这个窗体的容器面板
        JTextField text;                        //定义一个文本域
        double num[]={0, 0};                    //定义两个变量用于存储数值
        int index=0;                            //用于指定访问num[0]或num[1]
        char oper;                              //运算符
        String s[]={    "toDegrees","toRadians","Backapace","Clear",
                        "7","8","9","/","sqrt",
                        "4","5","6","*","%",
                        "1","2","3","-","1/x",
                        "0","+/-",".","+","=",
                        "sin","cos","tan","cot","HEX"};
        JButton button[] = new JButton[29];
        Calculator()
        {       
                setTitle("计算器2017112381");     //设置窗体的标题
                setSize(400, 240);                //设置窗体的大小
                setLocation(400, 200);            //设置窗体的显示位置
                cp=getContentPane();
 
                //将pnl[i]添加到容器cp中，按"North","Center","South"布局
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
                text.setHorizontalAlignment(JTextField.RIGHT);  //文本右对齐
                text.setEditable(false);                        //文本域不可编辑
                text.setBackground(new Color(255, 255, 255));   //设置背景色
 
                //向pnl[i]中添加按钮
                pnl[0].add(text);
                for(int i=0; i<29; i++)
                {
                        button[i] = new JButton(s[i]);
                        if(i<=3)pnl[1].add(button[i]);
                        else pnl[2].add(button[i]);
 
                        button[i].addActionListener(this);           //添加按钮事件监听
 
                        //设置以下按钮前景色为红色
                        if(i<=3 || i%5==2 || i==23)button[i].setForeground(new Color(255,0,0));
                }
                setVisible(true);                               //显示窗体
                setDefaultCloseOperation(EXIT_ON_CLOSE);        //退出程序时关闭窗体     
        }
 
        public void actionPerformed(ActionEvent e)              //事件响应
        {
                Object tmp = e.getSource();                     //获取事件源
                String str = text.getText();
 
                if(tmp==button[2] && str.length()>0) str=str.substring(0, str.length()-1);//退格键
                else if(tmp==button[3]){ str=""; index=0; num[0]=0; num[1]=0;}//清空键
 
                //字符输入
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
                        else if(tmp==button[21]) if(str.indexOf('.') == -1) str += '.';      //有一个小数点时不再添加
                
                        if(index==0) num[0] = Double.parseDouble(str);                  //将输入的字符串转化成数值并存储在num中
                        else num[1] = Double.parseDouble(str);
                }
 
                //运算符设置
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
 
                else if(tmp==button[23])                     //" == "输出运算结果
                {
                        if(oper=='/' || oper=='*' || oper=='%' || oper=='-' || oper=='+')
                        {
                                if(oper=='/'){ num[0]/=num[1];}
                                else if(oper=='*'){ num[0]*=num[1];}
                                else if(oper=='%'){ num[0]%=num[1];}
                                else if(oper=='-'){ num[0]-=num[1];}
                                else if(oper=='+'){ num[0]+=num[1];}
 
                                index=0; 
                                num[1]=0;                       //清除num[1]中的数值
                                str=Double.toString(num[index]);
                        }
                }
 
                //单目运算
                if(tmp==button[0] || tmp==button[1] || tmp==button[8] || tmp==button[18] || tmp==button[20] || tmp==button[24] || 
                        tmp==button[25] || tmp==button[26] || tmp==button[27])
                {
                        if(tmp==button[0]) num[index]=java.lang.Math.toDegrees(num[index]);  //弧度->角度
                        if(tmp==button[1]) num[index]=java.lang.Math.toRadians(num[index]);  //角度->弧度
                        if(tmp==button[8]) if(num[index]>=0) num[index]=java.lang.Math.sqrt(num[index]);
                        if(tmp==button[18]) num[index]=1/num[index];                         //求倒数
                        if(tmp==button[20]) num[index]=-num[index];                          //正负变换
                        if(tmp==button[24]) num[index]=java.lang.Math.sin(num[index]);       //正弦
                        if(tmp==button[25]) num[index]=java.lang.Math.cos(num[index]);
                        if(tmp==button[26]) num[index]=java.lang.Math.tan(num[index]);
                        if(tmp==button[27]) num[index]=1/java.lang.Math.tan(num[index]);
 
                        str=Double.toString(num[index]);                //更新str
                }
                
                if(tmp==button[28])       //将num[index]转化成16进制的字符串
                {
                        int num1=(int)num[index], num2=0, oper=0;
                        char tmpC;
                        str="";
                        if(num1<0){ num1=-num1; oper=1;}  //转换为正数
                        while(num1!=0)
                        {
                                num2=num1%16;
                                if(num2>9)tmpC=(char)('A'+num2-10);
                                else tmpC=(char)('0'+num2);
 
                                str=tmpC+str;
                                num1/=16;
                        }
                        if(oper==1)str='-'+str;  //是负数时str添加负号
                }
 
                text.setText(str);   //更新文本框中的显示内容
        }
 
 
        public static void main(String[] args) 
        {
                new Calculator();   //创建一个布局窗体
        }
}
