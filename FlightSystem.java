import java.util.Scanner;
import java.lang.String;
// Flight类
class Flight
{
	public Flight() {} // 无参数构造函数
	public Flight(String ID,String takeOffTime, String landingTime)
	{
		this.flightID = ID;
		this.takeOffTime = takeOffTime;
		this.landingTime = landingTime;
	}
	// 输出航班信息
	public void printFlightInfo(Flight tmp)
	{
		System.out.println("Flight ID           :"+tmp.flightID);
		System.out.println("Flight take off time:"+tmp.takeOffTime);
		System.out.println("Flight landing time :"+tmp.landingTime);
	}
	// 返回航班号
	String getFlightID()
	{
		return this.flightID;
	}
	private String flightID;      // 航班号
	private String takeOffTime;   // 起飞时间
	private String landingTime;   // 降落时间
}

// FlightSystem类
public class FlightSystem
{

	private static Flight flight[] = new Flight[10]; // 创建10个航班对象
	// 创建对象
	static void initObj(Flight flight[])
	{
		flight[0] = new Flight("UA088","PM15:35","PM17:05");
		flight[1] = new Flight("CA819","AM08:40","AM10:10");
		flight[2] = new Flight("CA981","PM13:00","PM14:20");
		flight[3] = new Flight("CX347","AM10:00","PM20:15");
		flight[4] = new Flight("KE856","PM13:30","PM20:45");
		flight[5] = new Flight("KE085","PM13:30","PM20:45");
		flight[6] = new Flight("UA808","PA12:00","PM17:14");
		flight[7] = new Flight("DL188","PM16:50","PM22:10");
		flight[8] = new Flight("AA180","PM17:20","AM05:57");
		flight[9] = new Flight("UA889","PM16:25","PM23:51");
	}
	// 输出航班
	static void printFlight(Flight flight[], int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.print(flight[i].getFlightID()+"    ");
			if((i+1)%5==0) 
			{
				System.out.println();
			}
		}
	}
	// 查询航班
	static void queryFlight(String ID)
	{
		for(int i=0;i<10;i++)
		{
			// 查询成功
			if(flight[i].getFlightID().compareTo(ID)==0)
			{
				flight[i].printFlightInfo(flight[i]);
				return;
			}
		}
		System.out.println("没有你要查询的航班，只有以下航班：!"); // 查询失败
		printFlight(flight,10); // 输出所有航班的信息
	}
	// 菜单
	static void menu()
	{
		Scanner in = new Scanner(System.in);
		while(true)
		{
			System.out.println("1.输入航班查询");
			System.out.println("2.结束程序运行");
			int select = in.nextInt();
			if(select==1)
			{
				System.out.print("输入航班号查询：");
				String ID = in.next(); // 航班号
				queryFlight(ID);
			}
			else if(select==2) // 程序结束
			{
				break;
			}
			else{
				System.out.println("输入错误，重新输入！");
			}
		}
	}
	public static void main(String args[])
	{
		initObj(flight); // 初始化对象数组
		menu();
	}
}
