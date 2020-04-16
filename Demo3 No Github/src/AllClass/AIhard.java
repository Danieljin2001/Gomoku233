package AllClass;

import java.util.ArrayList;
import java.util.Arrays;


/**
  * @ClassName: AIhard
  * @Description: This is the latest version of the AI file.
It uses a minimax algorithm and an Alpha-belta algorithm.
Because of the large amount of calculations, it does not respond quickly.
The search tree depth can be set by changing the difficulty variable in the AI file.
  * @author Comsys-zyf
  * @date 2020.4.10
  *
  */
public class AIhard {

	
	
	private static final String[] winGroup1={"11111","011110","011100","001110","011010","010110","211110","011112","11011","10111","11101","001100","001010","010100","000100","001000","12220","02221","022120","021220","22122","21222","22212","002210","012200","002120","021200","001200","002100","122221"};
	
	private static final String[] winGroup2= {"22222","022220","022200","002220","022020","020220","122220","022221","22022","20222","22202","002200","002020","020200","000200","002000","21110","01112","011210","012110","11211","12111","11121","001120","021100","001210","012100","002100","001200","211112"};

	private static final double[] grade= {2000000,200000,1200,1200,1200,1200,1200,1200,1200,1200,1200,120,120,120,20,20,1200,1200,1200,1200,5000,5000,5000,240,240,240,240,40,40,1500};
	/**
	  * @Fields difficulty : Represents the depth of the search tree for the maximum and minimum algorithm.The greater the value, the smarter the AI, but the speed of AI make decision will decrease.
	  */
	private int difficulty=1;
	/**
	  * @Fields go : Represents the color of chess pieces controlled by AI. go is either 1 or 2 (1 represent "black" , 2 represent "White"）.
	  */
	private int go;  
	/**
	  * @Fields chessBoard : A two-dimensional array storing the position information of the chess pieces of both players.
	  */
	private int [][]chessBoard;
	
	public AIhard(int go)
	{   
		chessBoard = new int[15][15];
		for (int i = 0; i < 15; i++)
		{
			for (int j = 0; j < 15; j++)
			{
				chessBoard[i][j] = 0;
			}
		}
		this.go=go;
	}
	
	
	/**
	  * reset :Reset the entire board to start a new game
	  * TODO(Traverse every position of the chessBoard array,Traverse each position of the chessboard array and assign them zero)
	  *
	  * @Title: reset
	  * @Description: TODO
	  * @param     none
	  * @return void    
	  * @throws
	  */
	
	
	public void reset()
	{
		for (int a = 0; a < 15; a++)
		{
			for (int b = 0; b < 15; b++)
			{
				chessBoard[a][b] = 0;
			}
		}
	}
	
	
	public void play1 (int x, int y)
	{
		chessBoard[x][y] = 1;
	}
	
	public void back(int x, int y)
	{
		chessBoard[x][y] = 0;
	}
	

	/**
	  * getGo :Returns the number representing the color of the chess piece controlled by the AI
	  * TODO(1 for black chess 2 for white chess)
	  *
	  * @Title: getGo
	  * @Description: TODO
	  * @param  none
	  * @return int  return an integer value
	  * @throws
	  */
	
	
	public int getGo()
	{return go;}


	//This method check if AI can play chess at (x,y).
	/**
	  * canPlay: This method check if AI can play chess at a specific location.
	  *
	  * @Title: canPlay
	  * @Description: TODO
	  * @param @param a : The integer a represents the abscissa of a specific position on the board
	  * @param @param b : The integer b represents the ordinate of a specific position on the board
	  * @param @return   If the return value is true, this position is empty, AI can play chess at this position. vice versa. 
	  * @return boolean    
	  * @throws
	  */
	
	
	public boolean canPlay(int a,int b)
	{   
		if(chessBoard[a][b]==0)
	    return true;

		return false;
	}
	

	/**
	  * play(this method play chess on this position : (x,y);)
	  *
	  * @Title: play
	  * @Description: TODO
	  * @param @param x The integer x represents the abscissa of a specific position on the board
	  * @param @param y The integer y represents the ordinate of a specific position on the board
	  * @param @param piece    The variable piece represents the color of the piece which will be played.
	  * @return void    no return value
	  * @throws
	  */
	
	
	public void play(int x,int y, int piece)
	{
		chessBoard[x][y]=piece;
	}
	
	
	/**
	  * turn(This method is used to switch the color of the current piece.When the value of the input variable is one (representing black pieces), the return value is two (representing white pieces), and vice versa)
	  * @Title: turn
	  * @Description: TODO
	  * @param @param go Represents the color of the currently controlled piece.
	  * @param @return   Return the color of piece of the the next step.
	  * @return int    The return value is an integer.
	  * @throws
	  */
	
	
	public int turn(int go)
	{
		if(go==1)
			return 2;
		else
			return 1;
	}

	
	/**
	  * eval(Evaluate the score on a six-tuple on the board from the perspective of AI.The six tuple represents six consecutive positions on the board in a straight line)

	  *
	  * @Title: eval
	  * @Description: TODO
	  * @param @param s  This is a string. It recorded the situation of a specific six-tuple on the board.
	  * @param @param go  Represents the color of the currently controlled piece.
	  * @param @return    Return assessment score.
	  * @return double    
	  * @throws
	  */
	
	
	public double eval(String sixTuple,int go)
	{    
	double mark=0;
	String [] winGroupA=winGroup1;
	String [] winGroupB=winGroup2;
	if(go==2)
	{
		winGroupA=winGroup2;
	    winGroupB=winGroup1;
	}
	int i=0;
		for(String t:winGroupA)
		{
			if(sixTuple.indexOf(t)!=-1)
				mark=grade[i];
				i++;
		}
	
		i=0;
		for(String t:winGroupB)
		{
			if(sixTuple.indexOf(t)!=-1)
				mark=-grade[i];
			i++;
		}
		
		
		return mark;
		}


	/**
	  * evalPointMark(This function can also evaluate the positive benefits of playing chess at a specific location position to the player. 
	  *
	  * @Title: evalPointMark
	  * @Description: TODO
      * @param @param x The integer x represents the abscissa of a specific position on the board
	  * @param @param y The integer y represents the ordinate of a specific position on the board
	  * @param @param go The variable go represents the color of the piece which will be played.
	  * @param @return   Returns the evaluation score of the input coordinates.The higher the score, the player playing chess at this position is conducive to winning
	  * @return int    
	  * @throws
	  */
	
	
	public int evalPointMark(int x,int y,int go)
	{   int evaluateMark=0;

String []s={"","","",""};
	    int start=x-4,end=x+4; 
	    if(x<4)
	    	start=0;
	    if(x>10)
	    	end=14;
	    for(int i=start;i<=end;i++) 
	    {
	    	s[0]=s[0]+chessBoard[i][y];
	    }

	    
	    
	    
	    start=y-4;end=y+4;  
	    if(y>10)
	    	end=14;
	    
	    if(y<4)
	    	start=0;
	    
	    for(int j=start;j<=end;j++) 
	    {
	    	s[1]=s[1]+chessBoard[x][j];
	    }

	    
	    int startx=x-4;
	    int endx=x+4;
	    int starty=y-4;
	    int endy=y+4;
	    
	    if(x<4||y<4)
	    	if(x<y)
	    	{
	    	startx=0;
	        starty=y-x;
	    	}
	    	else
	    	{
		    startx=x-y;
		    starty=0;	
	    	}
	    if(x>10)
	    	endx=14;    
	    if(y>10)
	    	endy=14;
	    for(int i=startx,j=starty;i<=endx&&j<=endy;i++,j++) 
	    {
	    	s[2]=s[2]+chessBoard[i][j];
	    }
	    
	    startx=x-4;
	    endx=x+4;
	    starty=y+4;
	    endy=y-4;
	    
	    if(x<4||y>10)
	    	if(x<14-y)
	    	{
	    	startx=0;
	        starty=y+x;
	    	}
	    	else
	    	{
		    startx=x-14+y;
		    starty=14;	
	    	}
	    if(x>10)
	    	endx=14;    
	    if(y<4)
	    	endy=0;

	    for(int i=startx,j=starty;i<=endx&&j>=endy;i++,j--) 
	    {
	    	s[3]=s[3]+chessBoard[i][j];
	    }

	    
	    
	    for(String sup:s)
	    {
	    	for(int i=0;i<sup.length()-5;i++)
	    		evaluateMark+=eval(sup.substring(i,i+6),go);
	    }
		return evaluateMark;
	}
	
	
	
	
	
/**
  * evaluateEntireBoard(From the standpoint of AI, assess whether the situation on the whole board is favorable)
  *
  * @Title: evaluateBoard
  * @Description: TODO
  * @param @param board  An array that stores the positions of all the chess pieces.
  * @param @return  Returns the evaluateMark for the current situation. The larger this value, the better the overall situation is for AI. 
  * @return int    
  * @throws
  */


public int evaluateEntireBoard(int [][]board)
{
	int mark=0;
	String s="";
	
for(int i=0;i<board.length;i++)
for(int j=0;j<board[0].length-5;j++)	
{s="";
	for(int k=0;k<6;k++)
	s+=board[i][j+k];
	mark+=eval(s,getGo());
	
}

for(int i=0;i<board.length-5;i++)
for(int j=0;j<board[0].length;j++)	
{s="";
	for(int k=0;k<6;k++)
	s+=board[i+k][j];
	mark+=eval(s,getGo());
	
}



for(int i=0;i<board.length-5;i++)
for(int j=0;j<board[0].length-5;j++)	
{s="";
	for(int k=0;k<6;k++)
	s+=board[i+k][j+k];
	mark+=eval(s,getGo());
	
}


for(int i=0;i<board.length-5;i++)
for(int j=0;j<board[0].length-5;j++)	
{s="";
	for(int k=0;k<6;k++)
	s+=board[i+k][j+5-k];
	mark+=eval(s,getGo());
	
}




	return mark;
}

	
	

	

	/**
	  * playChess(This method iterates through every position on the chessBoard;It calculate the evaluateMark of every position and return the position (an integer array have two value: x, y) that have the highest score;)
	  * @Title: playChess
	  * @Description: TODO
	  * @param @return Returns an array of integers. The first value in the array represents the horizontal coordinate of the optimal chess position, and the second value in the array represents the vertical coordinate of the optimal chess position.   
	  * @return int[]    
	  * @throws
	  */
	
	
	public int[] playChess()
	{   int x=0,y=0;
		int evaluateMark=-1000000000;
		int []result=new int[2];
	for(int i=0;i<chessBoard.length;i++)
		for(int j=0;j<chessBoard[0].length;j++)
		{
			if(canPlay(i,j))
			{
				if(i<13&&i>1&&j<13&&j>1)
				{
					if(chessBoard[i-2][j-2]+chessBoard[i+2][j+2]+chessBoard[i-2][j+2]+chessBoard[i+2][j-2]+chessBoard[i-2][j]+chessBoard[i+2][j]+chessBoard[i][j-2]+chessBoard[i][j+2]+chessBoard[i-1][j-1]+chessBoard[i+1][j+1]+chessBoard[i-1][j+1]+chessBoard[i+1][j-1]+chessBoard[i-1][j]+chessBoard[i+1][j]+chessBoard[i][j-1]+chessBoard[i][j+1]>=1)
				{
					play(i,j,getGo());
				int mark=maxMin(difficulty,-1000000000,1000000000,chessBoard,turn(getGo()));
				if(evaluateMark<=mark)
				{       
					{evaluateMark=mark;
						x=i;y=j;}
				
				}
				chessBoard[i][j]=0;
				}}
					else
					{
						play(i,j,getGo());
					int mark=maxMin(difficulty,-1000000000,1000000000,chessBoard,turn(getGo()));
					if(evaluateMark<=mark)
					{       
						{evaluateMark=mark;
							x=i;y=j;}
					
					}
					chessBoard[i][j]=0;
					}
			}
		}
	result[0]=x;
	result[1]=y;
	return result;
	}
	
	/**
	  * maxMin: Method of using recursion to realize maximum and minimum algorithm.
	  * TODO(In order to improve the speed of AI decision-making, the alpha beta pruning method is also used.)
	  *
	  * @Title: maxMin
	  * @Description: TODO
	  * @param @param level This integer represents the depth of the search tree. The deeper the search tree, the better the AI's ability to play chess.
	  * @param @param alpha The maximum in alpha-beta pruning algorithm.
	  * @param @param beta The minimum in alpha-beta pruning algorithm.
	  * @param @param board An array that stores the positions of all the chess pieces.
	  * @param @param go  Represents the color of the currently controlled piece.
	  * @param @return    Returns the highest situation score after several steps calculated by the maximum and minimum algorithm
	  * @return int    
	  * @throws
	  */
	
	
	public int maxMin(int level, int alpha,int beta,int [][]board,int go)
	{
	    if(level == 0)  return evaluateEntireBoard(board);
	    int[][]p=gen(board,go);
	    int i=0,j=0;
	 if(go==getGo())
	 {
	    for(int[] a:p)
			{
	    	i=a[0];
			j=a[1];			
				board[i][j]=go;
	            int newval = maxMin(level-1,alpha,beta,board,turn(go));
	            board[i][j]=0;
	            if (newval > alpha)
	                alpha = newval;
	            
	            if(alpha >= beta)
	                return alpha;
	            }

	    return alpha;
	 }
	    else
	    {
	    	for(int[] a:p)
			{ 
	    	i=a[0];
			j=a[1];			
            board[i][j]=go;
			int newval = maxMin(level-1,alpha,beta,board,turn(go));
			    board[i][j]=0;	            
			    if (newval < beta)
	                beta = newval;

	        if(alpha >= beta)
	            return beta;
	                 }

	    return beta;
	    }
	}

	//
	/**
	  * gen: Select a number of valuable positions on the board, store them in an array and return instead of traversing the whole board.)
	  * TODO(This method also uses the evaluatePointMark method to evaluate and sort the position information stored in the array
This is conducive to the fast operation of the pruning algorithm and can improve the speed of AI decision-making.
	  *
	  * @Title: gen
	  * @Description: TODO
	  * @param @param board An array that stores the positions of all the chess pieces.
	  * @param @param go An array that stores the positions of all the chess pieces.
	  * @param @return    Returns a two-dimensional array, which stores information about the positions that are beneficial to the player
	  * @return int[][]    
	  * @throws
	  */
	
	public int[][] gen(int [][]board,int go)
	{ArrayList<int[]> position=new ArrayList<int[]>();

					
					
		for(int i=1;i<board.length-1;i++)
		for(int j=1;j<board[0].length-1;j++)
		{
		if(board[i][j]+board[i-1][j-1]+board[i+1][j+1]+board[i-1][j+1]+board[i+1][j-1]+board[i-1][j]+board[i+1][j]+board[i][j-1]+board[i][j+1]>=1&&board[i][j]==0)
		{
			int []a=new int[3];
			a[0]=i;
			a[1]=j;

			a[2]=evalPointMark(i,j, go);


			position.add(a);
		}
		
		
		
		
		}
		if(position.size()==0)
		{int []a=new int[3];
			a[0]=7;
			a[1]=7;
			a[2]=evalPointMark(7,7, go);
			position.add(a);
		}
		int len=position.size();

		
		int[][] p=new int [len][];
		for(int i=0;i<len;i++)
		{
			p[i]=position.get(i);
		}
		int []temp=new int[3];

		if(go==getGo())
		{
		for(int i=0;i<p.length-1;i++)
			for(int j=0;j<p.length-i-1;j++)
			{
				if(p[j][2]<p[j+1][2])
				{
					temp=p[j];
					p[j]=p[j+1];
					p[j+1]=temp;
				}			
			}
		}
		else
		{
			for(int i=0;i<p.length-1;i++)
				for(int j=0;j>p.length-i-1;j++)
				{
					if(p[j][2]<p[j+1][2])
					{
						temp=p[j];
						p[j]=p[j+1];
						p[j+1]=temp;
					}			
				}	
		}

		return p;
		
	}
	

	
	


}