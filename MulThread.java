import java.util.Scanner;
//结点类
class Node{
	int data;
	Node next;
	public Node(int ch,Node new_node){
		data=ch;
		next=new_node;//引用赋值，不新建对象
	}
}

class Thr extends Thread{
	int x,minIndex,maxIndex;//关键数，起始位置下标，终止位置下标
	Node h;    // 链头结点
	int arr[];   // 存储随机数数组
	public Thr(int a[],int x,int minIndex,int maxIndex,Node h){
		this.x=x;this.minIndex=minIndex;this.maxIndex=maxIndex;this.arr=a;this.h=h;
	}
	public void run(){
		synchronized(h){
			Node last=h;
			while(last.next!=null){
				last=last.next;
			}
			for(int i=minIndex;i<=maxIndex;i++){
				if(x==arr[i]){
					Node p=new Node(i,null);
					last.next=p;last=p;
				}
			}
		}
	}
}

class MulThread {
	//打印链表值
	public static void ptr(Node h){
		Node p=h.next;
		int count=0;   //存放总数
		while(p!=null){
			System.out.print(p.data+" ");
			p=p.next;count++;
		}
		System.out.println("\n"+"\t"+"共查找到"+count+"个关键字");
	}
	//比较两个链表中的下标是否完全一致
	public static boolean cmp(Node h1,Node h2){
		Node p1=h1.next,p2=h2.next;
		while(p1!=null){
			if(p1.data==p2.data){
				p1=p1.next;p2=p2.next;
			}
			else return false;
		}
		return true;
	} 
	//主函数创建单向链表
	public static Node query(int a[],int x)
	{
		Node h=new Node(0,null),p,last=h; //h为头结点
		for(int i=0;i<100000;i++)
		{
			if(a[i]==x)
			{
				p=new Node(i,null);
				last.next=p;last=p;
			}
		}
		last.next=null;
		return h;
	}
	public static Node sort(Node h)
    {
        if(h==null||h.next==null)
            return h;
        Node pr=h,pt=h.next,p=new Node(0,null);
        p.next=h; 
        while(pt!=null){
            if(pt.data<pr.data){
                pr.next=pt.next;//现将pt从链表中摘除
                Node p1=p,p2=p.next;
                while(pt.data>p2.data){
                    p1=p2;p2=p2.next;
                }
                p1.next=pt;
                pt.next=p2;
                pt=pr.next;
            }
            else {pr=pt;pt=pt.next;}
        }
        return p.next;
    }
	public static void main(String[] args) throws InterruptedException{
		Scanner in=new Scanner(System.in);
		System.out.print("请输入x(0≤x＜1000)的值：");
		int x=in.nextInt();//关键数
		while(x<0||x>=1000)
        {
            System.out.print("输入的值有误，请输入x(0≤x＜1000)的值：");
            x=in.nextInt();
        }
		int a[]=new int[100000];
		for(int i=0;i<100000;i++){
			a[i]=(int)(Math.random()*(999-0+1)+0);
		}
		Node h1=new Node(0,null);//创建线程共享的链表头指针
		Thr thread1=new Thr(a,x,0,19999,h1);
		Thr thread2=new Thr(a,x,20000,39999,h1);
		Thr thread3=new Thr(a,x,40000,59999,h1);
		Thr thread4=new Thr(a,x,60000,79999,h1);
		Thr thread5=new Thr(a,x,80000,99999,h1);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread1.join();
		thread2.join(); 
		thread3.join();
		thread4.join();
		thread5.join();
		h1=sort(h1);
		System.out.println("启动五个线程查找：");ptr(h1);
		Node h2=query(a,x);
		System.out.println("主函数按顺序查找：");ptr(h2);
		if(cmp(h1,h2)) System.out.println("TRUE");
		else System.out.println("FALSE");
	}
}