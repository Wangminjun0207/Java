import java.util.Scanner;
//�����
class Node{
	int data;
	Node next;
	public Node(int ch,Node new_node){
		data=ch;
		next=new_node;//���ø�ֵ�����½�����
	}
}

class Thr extends Thread{
	int x,minIndex,maxIndex;//�ؼ�������ʼλ���±꣬��ֹλ���±�
	Node h;    // ��ͷ���
	int arr[];   // �洢���������
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
	//��ӡ����ֵ
	public static void ptr(Node h){
		Node p=h.next;
		int count=0;   //�������
		while(p!=null){
			System.out.print(p.data+" ");
			p=p.next;count++;
		}
		System.out.println("\n"+"\t"+"�����ҵ�"+count+"���ؼ���");
	}
	//�Ƚ����������е��±��Ƿ���ȫһ��
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
	//������������������
	public static Node query(int a[],int x)
	{
		Node h=new Node(0,null),p,last=h; //hΪͷ���
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
                pr.next=pt.next;//�ֽ�pt��������ժ��
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
		System.out.print("������x(0��x��1000)��ֵ��");
		int x=in.nextInt();//�ؼ���
		while(x<0||x>=1000)
        {
            System.out.print("�����ֵ����������x(0��x��1000)��ֵ��");
            x=in.nextInt();
        }
		int a[]=new int[100000];
		for(int i=0;i<100000;i++){
			a[i]=(int)(Math.random()*(999-0+1)+0);
		}
		Node h1=new Node(0,null);//�����̹߳��������ͷָ��
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
		System.out.println("��������̲߳��ң�");ptr(h1);
		Node h2=query(a,x);
		System.out.println("��������˳����ң�");ptr(h2);
		if(cmp(h1,h2)) System.out.println("TRUE");
		else System.out.println("FALSE");
	}
}