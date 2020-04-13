package AllClass;

import java.util.ArrayList;
import java.util.Arrays;

/*This is the latest version of the AI file.
It uses a minimax algorithm and an Alpha-belta algorithm.
Because of the large amount of calculations, it does not respond quickly.
The search tree depth can be set by changing the difficulty variable in the AI file.
A simple game file to test AI performance is GGgame
*/
public class AIhard {

	//go is either 1 or 2 (1 represent "black" , 2 represent "White"
	
	private static final String[] winGroup1={"11111","011110","011100","001110","011010","010110","211110","011112","11011","10111","11101","001100","001010","010100","000100","001000","12220","02221","022120","021220","22122","21222","22212","002210","012200","002120","021200","001200","002100"};
	
	private static final String[] winGroup2= {"22222","022220","022200","002220","022020","020220","122220","022221","22022","20222","22202","002200","002020","020200","000200","002000","21110","01112","011210","012110","11211","12111","11121","001120","021100","001210","012100","002100","001200"};

	private static final double[] grade= {2000000,43200,1200,1200,1200,1200,1200,1200,1200,1200,1200,120,120,120,20,20,5000,5000,5000,5000,5000,5000,5000,240,240,240,240,40,40};
	private int difficulty=1;
	private int go;  
	private int [][]chessBoard;
	
	public AIhard(int g,int [][]currentPosition)
	{   this.chessBoard=currentPosition;
		this.go=g;
	}


	//This method return the integer which represent the AI player is White or Black.
	public int getGo()
	{return go;}


	//This method check if AI can play chess at (x,y).
	public boolean canPlay(int a,int b)
	{   
		if(chessBoard[a][b]==0)
	    return true;

		return false;
	}
	
	//this method play chess on this position : (x,y);
	public void play(int x,int y)
	{
		chessBoard[x][y]=getGo();
	}
	
	public int turn(int go)
	{
		if(go==1)
			return 2;
		else
			return 1;
	}

	
	public double eval(String s,int go)
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
			if(s.indexOf(t)!=-1)
				mark=grade[i];
				i++;
		}
	
		i=0;
		for(String t:winGroupB)
		{
			if(s.indexOf(t)!=-1)
				mark=-grade[i];
			i++;
		}
		
		
		return mark;
		}

	
	public static int count(String S,int go)
	{int num=0;
		for(int i=0;i<S.length();i++)
		{
			if((int)S.charAt(i)==(go+"").charAt(0))
				num++;		
		}
		return num;
	}
	
	
	

	

	//This method iterates through every position on the chessBoard;
	//It calculate the evaluateMark of every position and return the position (an integer array have two value: x, y) that have the highest score;
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
					play(i,j);
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
						play(i,j);
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
	
	public int maxMin(int level, int alpha,int beta,int [][]board,int go)
	{
	    if(level == 0)  return evaluate(board);
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
				if(p[j][2]>p[j+1][2])
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
					if(p[j][2]>p[j+1][2])
					{
						temp=p[j];
						p[j]=p[j+1];
						p[j+1]=temp;
					}			
				}	
		}
		int length=20;
		if(p.length<20)
			length=p.length;
		int[][] result =new int[length][];
		for(int i=0;i<length;i++)
		{
			result[i]=p[i];
		}
		return p;
		
	}
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
	
	
	
	
	
public int evaluate(int [][]board)
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


}