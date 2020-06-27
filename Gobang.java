
import java.io.*;
// 导入随机包
import java.util.Random;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */

// 下面全部的方法函数都在Gobang这个类里
public class Gobang {
	// 定义棋盘的大小
	private static int BOARD_SIZE = 15;
	// 定义一个二维数组来充当棋盘
	private String[][] board;

	// 构造原始棋盘
	public void initBoard() {
		// 初始化棋盘数组
		board = new String[BOARD_SIZE][BOARD_SIZE];
		// 把每个元素赋为"╋"，用于在控制台画出棋盘
		for (int i = 0 ; i < BOARD_SIZE ; i++)
		{
			for ( int j = 0 ; j < BOARD_SIZE ; j++)
			{
				board[i][j] = "╋";
			}
		}
	}

	// 在控制台输出棋盘的方法
	public void printBoard() {
		// 打印每个数组元素
		for (int i = 0 ; i < BOARD_SIZE ; i++)
		{
			for ( int j = 0 ; j < BOARD_SIZE ; j++)
			{
				// 打印数组元素后不换行
				System.out.print(board[i][j]);
			}
			// 每打印完一行数组元素后输出一个换行符
			System.out.print("\n");
		}
	}
	
	// 判断谁获胜了
	// 根据调用的Symbol不同，来判断电脑赢还是玩家赢
	public static boolean judgematch(String[][] board, String symbol) {
		// 判断水平上是否有5个相同符号连在一块
		// 先从头开始遍历
		int i = 0; 
		int j = 0;
		int a = 0;
		int b = 0;
		int n = 0;
		int sum = 0;
		int times = 0;
		boolean flag = false;
		// 初始化字符串变量current的值
		String current = "a";
		// 一行一行分析
		for (i = 0; i <= 14; i++  )  {
			// 每一行刚开始，让sum变量值为0.
			sum = 0;
			for (j = 0; j <= 13; j++  ) {
				current = board[i][j] ;
				if (current == symbol ) {
					// 每次遇到标识符，就让统计变量sum加一
					sum++;
					if (sum == 5) {
						flag = true ;
						return flag;
					}
					if (board[i][j + 1] != symbol) {
						sum = 0;
					}
				}
		  }
		}

		// 一列一列分析
		for (j = 0; j <= 14; j++ ) {
			// 每一列刚开始，让sum变量值为0.
			sum = 0;
			for (i = 0; i <= 13; i++ ) {
			    current = board[i][j];
				if (current == symbol) {
					// 每次遇到标识符，就让统计变量sum加1
					sum++;
					if (sum == 5) {
						flag = true ;
						return flag;
					}
					if (board[i + 1][j] != symbol) {
						sum = 0;
					}
				}
			}
		}
		
		// 这个
		// 中心线分析
		// 先分析“左斜”的上半部分
		// i 始终等于0 ，j 不断累加移动
		// 注意，其他3个和这个差不多，根据这个改变
		for (i = 0, j = 0; j <= 14; j++) {
			// 每一斜行刚开始，让sum变量值为0.
			sum = 0;
			// i 是几，times 就可以移动几次
			// 构造a ,b 来代替i, j 移动
			a = i;
			b = j;
			for (times = 0 ; times <= j - 1 ; times++ ) {
				// 确定刚开始的当前的的字符串；
				// j的值为x，就要分析x次current;
				current = board[a][b] ;
				// 判断当前子和期望的子是否相同，相同则
				if (current == symbol) {
					sum++;      
					// 判断是否5子相连
					if (sum == 5) {
						 flag = true ;
						 return flag;
					}
					// ！！！！！！
					// 分析不了最左下变得值，次数不够；次数太多会溢出==》 只能借助特殊if条件来判断
					if (sum == 4) {
						// sum值为4时才进行预判。
						if (board[a + 1][b - 1] == symbol) {
							flag = true ;
							return flag;
						}
					}
					// 判断下一子是否是同样的子，不同则令sun清零
					if (board[a + 1][b - 1] != symbol) {
					sum = 0 ;
					}
					// 往左下角移动一次
					a = a + 1;
				    b = b - 1;			
				}
				// 当和期望的子不同时：
				if (current != symbol) {
				//	往左下角移动一次
					a = a + 1;
				    b = b - 1;
				}
			}
		}

	   //		 再分析“左斜”的下半部分
		// i 始终等于14 ，j 不断递减移动
		for (i = 14, j = 14; j >= 0; j--) {
			// 每一斜行刚开始，让sum变量值为0.
			sum = 0;
			// i 是几，times 就可以移动几次
			// 构造a ,b 来代替i, j 移动
			a = i;
			b = j;
			for (times = 0 ; times <= 14 - j -1 ; times++ ) {
				// 确定刚开始的当前的的字符串；
				// j的值为x，就要分析x次current;
				current = board[a][b] ;
				// 判断当前子和期望的子是否相同，相同则
				if (current == symbol) {
					sum++;      
					// 判断是否5子相连
					if (sum == 5) {
						 flag = true ;
						 return flag;
					}
					// ！！！！！！
					// 分析不了最左下变得值，次数不够；次数太多会溢出==》 只能借助特殊if条件来判断
					if (sum == 4) {
						// sum值为4时才进行预判。
						if (board[a - 1][b + 1] == symbol) {
							flag = true ;
							return flag;
						}
					}
					// 判断下一子是否是同样的子，不同则令sun清零
					if (board[a - 1][b + 1] != symbol) {
					sum = 0 ;
					}
					// 往右上角移动一次
					a = a - 1;
				    b = b + 1;			
				}
				// 当和期望的子不同时：
				if (current != symbol) {
				//	往右上角移动一次
					a = a - 1;
				    b = b + 1;
				}
			}
		}

		//	 再分析“右斜”的上半部分
		// i 始终等于0 ，j 不断递减移动
		for (i = 0, j = 14; j >= 0; j--) {
			// 每一斜行刚开始，让sum变量值为0.
			sum = 0;
			// i 是几，times 就可以移动几次
			// 构造a ,b 来代替i, j 移动
			a = i;
			b = j;
			for (times = 0 ; times <= 14 - j -1 ; times++ ) {
				// 确定刚开始的当前的的字符串；
				// j的值为x，就要分析x次current;
				current = board[a][b] ;
				// 判断当前子和期望的子是否相同，相同则
				if (current == symbol) {
					sum++;      
					// 判断是否5子相连
					if (sum == 5) {
						 flag = true ;
						 return flag;
					}
					// ！！！！！！
					// 分析不了最左下变得值，次数不够；次数太多会溢出==》 只能借助特殊if条件来判断
					if (sum == 4) {
						// sum值为4时才进行预判。
						if (board[a + 1][b + 1] == symbol) {
							flag = true ;
							return flag;
						}
					}
					// 判断下一子是否是同样的子，不同则令sun清零
					if (board[a + 1][b + 1] != symbol) {
					sum = 0 ;
					}
					// 往右下角移动
					a = a + 1;
				    b = b + 1;			
				}
				// 当和期望的子不同时：
				if (current != symbol) {
				//	往右下角移动
					a = a + 1;
				    b = b + 1;
				}
			}
		}

		//	 最后分析“右斜”的下半部分
		// i 始终等于14 ，j 不断递增移动
		for (i = 14, j =0; j <=14; j++) {
			// 每一斜行刚开始，让sum变量值为0.
			sum = 0;
			// i 是几，times 就可以移动几次
			// 构造a ,b 来代替i, j 移动
			a = i;
			b = j;
			for (times = 0 ; times <= j - 1 ; times++ ) {
				// 确定刚开始的当前的的字符串；
				// j的值为x，就要分析x次current;
				current = board[a][b] ;
				// 判断当前子和期望的子是否相同，相同则
				if (current == symbol) {
					sum++;      
					// 判断是否5子相连
					if (sum == 5) {
						 flag = true ;
						 return flag;
					}
					// ！！！！！！
					// 分析不了最左下变得值，次数不够；次数太多会溢出==》 只能借助特殊if条件来判断
					if (sum == 4) {
						// sum值为4时才进行预判。
						if (board[a - 1][b - 1] == symbol) {
							flag = true ;
							return flag;
						}
					}
					// 判断下一子是否是同样的子，不同则令sun清零
					if (board[a - 1][b - 1] != symbol) {
					sum = 0 ;
					}
					// 往右下角移动
					a = a - 1;
				    b = b - 1;			
				}
				// 当和期望的子不同时：
				if (current != symbol) {
				//	往右下角移动
					a = a - 1;
				    b = b - 1;
				}
			}
		}

		return flag;
	}


/** 
 * 主函数
 */
    public static void main(String[] args) throws Exception  {   
		// 创建对象Gobang 的一个Gobang类型的实例 gb
        Gobang gb = new Gobang();
		gb.initBoard();
		gb.printBoard();
		// 要创建随机数，首先应该要创建Random对象的实例。！！！
		Random rand = new Random();
		int yPos_pc = 0;
		int xPos_pc = 0;
		// 初始化布尔变量result_Human
		boolean result_Human = false ;
		// 初始化布尔变量result_Human
		boolean result_Computer = false ;
		// 这是用于获取键盘输入的方法
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine()：每当在键盘上输入一行内容按回车，用户刚输入的内容将被br读取到。
		while ((inputStr = br.readLine()) != null)
		{
			// 将用户输入的字符串以逗号（,）作为分隔符，分隔成2个字符串
			String[] posStrArr = inputStr.split(",");
			// 将2个字符串转换成用户下棋的座标
			int xPos = Integer.parseInt(posStrArr[0]);
			int yPos = Integer.parseInt(posStrArr[1]);
			// 判断人下的棋子上是否有棋子，如果有，提醒重新下这个棋子
			if (gb.board[yPos - 1][xPos - 1] == "╋")  {
			// 把对应的数组元素赋为"●"。
			// 没有其他棋子，则可以下在这里
			gb.board[yPos - 1][xPos - 1] = "●"; 
			}
			// 如果已有棋子，则
			else if (gb.board[yPos - 1][xPos - 1] != "╋" )  {
				System.out.println("There is a piece on the board, please try to use another place !");
				System.out.println("请重新输入您下棋的座标，应以x,y的格式：");
				continue ;
			}
			/*
			 电脑随机生成2个整数，作为电脑下棋的座标，赋给board数组。
			 还涉及
				1.座标的有效性，只能是数字，不能超出棋盘范围
				2.如果下的棋的点，不能重复下棋。
				3.每次下棋后，需要扫描谁赢了
			 */
			 // 构建电脑下的棋子坐标
			// 同时判断电脑下的棋子坐标是否有效
			 for (int i=0; i >=0; i++ ) {
				 yPos_pc = rand.nextInt(14) + 1 ;
			     xPos_pc = rand.nextInt(14) + 1;
				 if ( gb.board[ yPos_pc  ][xPos_pc  ] == "╋" )  {
					// Gobang.java:85: 错误: 非法字符: '\uff1b'
					// 下面的分号写错了，用了中文的 
					  // gb.board[ yPos_pc - 1][xPos_pc - 1]  = "●" ；
					 //  gb.board[ yPos_pc - 1 ][xPos_pc - 1 ]  = "▲" ;
					  gb.board[ yPos_pc - 1 ][xPos_pc - 1 ]  = "▲" ;
					  break;
				 }
			 }
			 // 打印棋盘
			 gb.printBoard();


			 // 调用判断谁赢了的算法
			// 判断人类
			// result_Human =  judgematch( board, "*" ) ;
			result_Human =  judgematch( gb.board, "●" ) ;
			// 判断电脑
		    // result_Pc =  judgematch( board, "▲" ) ;
			// result_Pc =  judgematch( gb.board, "▲" ) ;
			result_Computer =  judgematch( gb.board, "▲" ) ;
//			 while (gb.board[ rand.nextInt(16) - 1][rand.nextInt(16) - 1] != "●"  )  {
//					gb.board[yPos_pc - 1][xPos_pc - 1] = "$" ;
//			 }
	
			if (result_Human) {
				System.out.println("Human victory");
			//	break;
			}
			if (result_Computer) {
				System.out.println("Computer victory");
				// break;
			}
			System.out.println("请输入您下棋的座标，应以x,y的格式：");
		}
    }
}



