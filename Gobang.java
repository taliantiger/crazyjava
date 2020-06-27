
import java.io.*;
// ���������
import java.util.Random;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */

// ����ȫ���ķ�����������Gobang�������
public class Gobang {
	// �������̵Ĵ�С
	private static int BOARD_SIZE = 15;
	// ����һ����ά�������䵱����
	private String[][] board;

	// ����ԭʼ����
	public void initBoard() {
		// ��ʼ����������
		board = new String[BOARD_SIZE][BOARD_SIZE];
		// ��ÿ��Ԫ�ظ�Ϊ"��"�������ڿ���̨��������
		for (int i = 0 ; i < BOARD_SIZE ; i++)
		{
			for ( int j = 0 ; j < BOARD_SIZE ; j++)
			{
				board[i][j] = "��";
			}
		}
	}

	// �ڿ���̨������̵ķ���
	public void printBoard() {
		// ��ӡÿ������Ԫ��
		for (int i = 0 ; i < BOARD_SIZE ; i++)
		{
			for ( int j = 0 ; j < BOARD_SIZE ; j++)
			{
				// ��ӡ����Ԫ�غ󲻻���
				System.out.print(board[i][j]);
			}
			// ÿ��ӡ��һ������Ԫ�غ����һ�����з�
			System.out.print("\n");
		}
	}
	
	// �ж�˭��ʤ��
	// ���ݵ��õ�Symbol��ͬ�����жϵ���Ӯ�������Ӯ
	public static boolean judgematch(String[][] board, String symbol) {
		// �ж�ˮƽ���Ƿ���5����ͬ��������һ��
		// �ȴ�ͷ��ʼ����
		int i = 0; 
		int j = 0;
		int a = 0;
		int b = 0;
		int n = 0;
		int sum = 0;
		int times = 0;
		boolean flag = false;
		// ��ʼ���ַ�������current��ֵ
		String current = "a";
		// һ��һ�з���
		for (i = 0; i <= 14; i++  )  {
			// ÿһ�иտ�ʼ����sum����ֵΪ0.
			sum = 0;
			for (j = 0; j <= 13; j++  ) {
				current = board[i][j] ;
				if (current == symbol ) {
					// ÿ��������ʶ��������ͳ�Ʊ���sum��һ
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

		// һ��һ�з���
		for (j = 0; j <= 14; j++ ) {
			// ÿһ�иտ�ʼ����sum����ֵΪ0.
			sum = 0;
			for (i = 0; i <= 13; i++ ) {
			    current = board[i][j];
				if (current == symbol) {
					// ÿ��������ʶ��������ͳ�Ʊ���sum��1
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
		
		// ���
		// �����߷���
		// �ȷ�������б�����ϰ벿��
		// i ʼ�յ���0 ��j �����ۼ��ƶ�
		// ע�⣬����3���������࣬��������ı�
		for (i = 0, j = 0; j <= 14; j++) {
			// ÿһб�иտ�ʼ����sum����ֵΪ0.
			sum = 0;
			// i �Ǽ���times �Ϳ����ƶ�����
			// ����a ,b ������i, j �ƶ�
			a = i;
			b = j;
			for (times = 0 ; times <= j - 1 ; times++ ) {
				// ȷ���տ�ʼ�ĵ�ǰ�ĵ��ַ�����
				// j��ֵΪx����Ҫ����x��current;
				current = board[a][b] ;
				// �жϵ�ǰ�Ӻ����������Ƿ���ͬ����ͬ��
				if (current == symbol) {
					sum++;      
					// �ж��Ƿ�5������
					if (sum == 5) {
						 flag = true ;
						 return flag;
					}
					// ������������
					// �������������±��ֵ����������������̫������==�� ֻ�ܽ�������if�������ж�
					if (sum == 4) {
						// sumֵΪ4ʱ�Ž���Ԥ�С�
						if (board[a + 1][b - 1] == symbol) {
							flag = true ;
							return flag;
						}
					}
					// �ж���һ���Ƿ���ͬ�����ӣ���ͬ����sun����
					if (board[a + 1][b - 1] != symbol) {
					sum = 0 ;
					}
					// �����½��ƶ�һ��
					a = a + 1;
				    b = b - 1;			
				}
				// �����������Ӳ�ͬʱ��
				if (current != symbol) {
				//	�����½��ƶ�һ��
					a = a + 1;
				    b = b - 1;
				}
			}
		}

	   //		 �ٷ�������б�����°벿��
		// i ʼ�յ���14 ��j ���ϵݼ��ƶ�
		for (i = 14, j = 14; j >= 0; j--) {
			// ÿһб�иտ�ʼ����sum����ֵΪ0.
			sum = 0;
			// i �Ǽ���times �Ϳ����ƶ�����
			// ����a ,b ������i, j �ƶ�
			a = i;
			b = j;
			for (times = 0 ; times <= 14 - j -1 ; times++ ) {
				// ȷ���տ�ʼ�ĵ�ǰ�ĵ��ַ�����
				// j��ֵΪx����Ҫ����x��current;
				current = board[a][b] ;
				// �жϵ�ǰ�Ӻ����������Ƿ���ͬ����ͬ��
				if (current == symbol) {
					sum++;      
					// �ж��Ƿ�5������
					if (sum == 5) {
						 flag = true ;
						 return flag;
					}
					// ������������
					// �������������±��ֵ����������������̫������==�� ֻ�ܽ�������if�������ж�
					if (sum == 4) {
						// sumֵΪ4ʱ�Ž���Ԥ�С�
						if (board[a - 1][b + 1] == symbol) {
							flag = true ;
							return flag;
						}
					}
					// �ж���һ���Ƿ���ͬ�����ӣ���ͬ����sun����
					if (board[a - 1][b + 1] != symbol) {
					sum = 0 ;
					}
					// �����Ͻ��ƶ�һ��
					a = a - 1;
				    b = b + 1;			
				}
				// �����������Ӳ�ͬʱ��
				if (current != symbol) {
				//	�����Ͻ��ƶ�һ��
					a = a - 1;
				    b = b + 1;
				}
			}
		}

		//	 �ٷ�������б�����ϰ벿��
		// i ʼ�յ���0 ��j ���ϵݼ��ƶ�
		for (i = 0, j = 14; j >= 0; j--) {
			// ÿһб�иտ�ʼ����sum����ֵΪ0.
			sum = 0;
			// i �Ǽ���times �Ϳ����ƶ�����
			// ����a ,b ������i, j �ƶ�
			a = i;
			b = j;
			for (times = 0 ; times <= 14 - j -1 ; times++ ) {
				// ȷ���տ�ʼ�ĵ�ǰ�ĵ��ַ�����
				// j��ֵΪx����Ҫ����x��current;
				current = board[a][b] ;
				// �жϵ�ǰ�Ӻ����������Ƿ���ͬ����ͬ��
				if (current == symbol) {
					sum++;      
					// �ж��Ƿ�5������
					if (sum == 5) {
						 flag = true ;
						 return flag;
					}
					// ������������
					// �������������±��ֵ����������������̫������==�� ֻ�ܽ�������if�������ж�
					if (sum == 4) {
						// sumֵΪ4ʱ�Ž���Ԥ�С�
						if (board[a + 1][b + 1] == symbol) {
							flag = true ;
							return flag;
						}
					}
					// �ж���һ���Ƿ���ͬ�����ӣ���ͬ����sun����
					if (board[a + 1][b + 1] != symbol) {
					sum = 0 ;
					}
					// �����½��ƶ�
					a = a + 1;
				    b = b + 1;			
				}
				// �����������Ӳ�ͬʱ��
				if (current != symbol) {
				//	�����½��ƶ�
					a = a + 1;
				    b = b + 1;
				}
			}
		}

		//	 ����������б�����°벿��
		// i ʼ�յ���14 ��j ���ϵ����ƶ�
		for (i = 14, j =0; j <=14; j++) {
			// ÿһб�иտ�ʼ����sum����ֵΪ0.
			sum = 0;
			// i �Ǽ���times �Ϳ����ƶ�����
			// ����a ,b ������i, j �ƶ�
			a = i;
			b = j;
			for (times = 0 ; times <= j - 1 ; times++ ) {
				// ȷ���տ�ʼ�ĵ�ǰ�ĵ��ַ�����
				// j��ֵΪx����Ҫ����x��current;
				current = board[a][b] ;
				// �жϵ�ǰ�Ӻ����������Ƿ���ͬ����ͬ��
				if (current == symbol) {
					sum++;      
					// �ж��Ƿ�5������
					if (sum == 5) {
						 flag = true ;
						 return flag;
					}
					// ������������
					// �������������±��ֵ����������������̫������==�� ֻ�ܽ�������if�������ж�
					if (sum == 4) {
						// sumֵΪ4ʱ�Ž���Ԥ�С�
						if (board[a - 1][b - 1] == symbol) {
							flag = true ;
							return flag;
						}
					}
					// �ж���һ���Ƿ���ͬ�����ӣ���ͬ����sun����
					if (board[a - 1][b - 1] != symbol) {
					sum = 0 ;
					}
					// �����½��ƶ�
					a = a - 1;
				    b = b - 1;			
				}
				// �����������Ӳ�ͬʱ��
				if (current != symbol) {
				//	�����½��ƶ�
					a = a - 1;
				    b = b - 1;
				}
			}
		}

		return flag;
	}


/** 
 * ������
 */
    public static void main(String[] args) throws Exception  {   
		// ��������Gobang ��һ��Gobang���͵�ʵ�� gb
        Gobang gb = new Gobang();
		gb.initBoard();
		gb.printBoard();
		// Ҫ���������������Ӧ��Ҫ����Random�����ʵ����������
		Random rand = new Random();
		int yPos_pc = 0;
		int xPos_pc = 0;
		// ��ʼ����������result_Human
		boolean result_Human = false ;
		// ��ʼ����������result_Human
		boolean result_Computer = false ;
		// �������ڻ�ȡ��������ķ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine()��ÿ���ڼ���������һ�����ݰ��س����û�����������ݽ���br��ȡ����
		while ((inputStr = br.readLine()) != null)
		{
			// ���û�������ַ����Զ��ţ�,����Ϊ�ָ������ָ���2���ַ���
			String[] posStrArr = inputStr.split(",");
			// ��2���ַ���ת�����û����������
			int xPos = Integer.parseInt(posStrArr[0]);
			int yPos = Integer.parseInt(posStrArr[1]);
			// �ж����µ��������Ƿ������ӣ�����У������������������
			if (gb.board[yPos - 1][xPos - 1] == "��")  {
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"��
			// û���������ӣ��������������
			gb.board[yPos - 1][xPos - 1] = "��"; 
			}
			// ����������ӣ���
			else if (gb.board[yPos - 1][xPos - 1] != "��" )  {
				System.out.println("There is a piece on the board, please try to use another place !");
				System.out.println("��������������������꣬Ӧ��x,y�ĸ�ʽ��");
				continue ;
			}
			/*
			 �����������2����������Ϊ������������꣬����board���顣
			 ���漰
				1.�������Ч�ԣ�ֻ�������֣����ܳ������̷�Χ
				2.����µ���ĵ㣬�����ظ����塣
				3.ÿ���������Ҫɨ��˭Ӯ��
			 */
			 // ���������µ���������
			// ͬʱ�жϵ����µ����������Ƿ���Ч
			 for (int i=0; i >=0; i++ ) {
				 yPos_pc = rand.nextInt(14) + 1 ;
			     xPos_pc = rand.nextInt(14) + 1;
				 if ( gb.board[ yPos_pc  ][xPos_pc  ] == "��" )  {
					// Gobang.java:85: ����: �Ƿ��ַ�: '\uff1b'
					// ����ķֺ�д���ˣ��������ĵ� 
					  // gb.board[ yPos_pc - 1][xPos_pc - 1]  = "��" ��
					 //  gb.board[ yPos_pc - 1 ][xPos_pc - 1 ]  = "��" ;
					  gb.board[ yPos_pc - 1 ][xPos_pc - 1 ]  = "��" ;
					  break;
				 }
			 }
			 // ��ӡ����
			 gb.printBoard();


			 // �����ж�˭Ӯ�˵��㷨
			// �ж�����
			// result_Human =  judgematch( board, "*" ) ;
			result_Human =  judgematch( gb.board, "��" ) ;
			// �жϵ���
		    // result_Pc =  judgematch( board, "��" ) ;
			// result_Pc =  judgematch( gb.board, "��" ) ;
			result_Computer =  judgematch( gb.board, "��" ) ;
//			 while (gb.board[ rand.nextInt(16) - 1][rand.nextInt(16) - 1] != "��"  )  {
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
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ��");
		}
    }
}



