package AllClass;




/*
This is the latest version of the AI file.
It uses a minimax algorithm and an Alpha-Beta algorithm.
Because of the large amount of calculations, it does not respond quickly.
The search tree depth can be set by changing the difficulty variable in the AI file.
A simple game file to test AI performance is GGgame
 */
public class AIhard {

	//go is either 1 or 2 (1 represent "black" , 2 represent "White"
	

	private int difficulty=0;
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
	{   /*int [][]ext=new int[19][19];
	
	    for(int i=0;i<19;i++)
		for(int j=0;j<19;j++)
		{ext[i][j]=0;	
		}
	    
	    for(int i=0;i<15;i++)
	    	for(int j=0;j<15;j++)
			{ext[i+2][j+2]=chessBoard[i][j];	
			}	
	    	int x=a+2,y=a+2;
	     int sum=ext[x-1][y-1]+ext[x-2][y-2]+ext[x][y]+ext[x+1][y+1]+ext[x+2][y+2]+ext[x+1][y-1]+ext[x+2][y-2]+ext[x-1][y+1]+ext[x-2][y+2]+ext[x-1][y]+ext[x-2][y]+ext[x+1][y]+ext[x+2][y]+ext[x][y+2]+ext[x][y+1]+ext[x][y-2]+ext[x][y-2];
		*/
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
	
	public int eval(String S,int go)
	{   int mark=0;
		int enemy=turn(go);
		int a=count(S,go);
		int b=count(S,enemy);
		
		if(b==0)
		{
			if(a==1)
			mark =7;
			if(a==2)
			mark =35;
			if(a==3)
			mark =800;
			if(a==4)
			mark =15000;
			if(a==5)
			mark =1000000;
		}
		

		else if(a>=1)
		{if(b==1)
			mark =20;
		if(b==2)
			mark =500;	
		if(b==3)
			mark =4000;	
		if(b==4)
			mark =300000;	
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
				play(i,j);
				int mark=maxMin(difficulty,-1000000000,1000000000,chessBoard,turn(getGo()));
				if(evaluateMark<=mark)
				{       evaluateMark=mark;
						x=i;y=j;
				}
				chessBoard[i][j]=0;
			}
		}
	result[0]=x;
	result[1]=y;
	return result;
	}

	public int[][] copy(int [][]a)
	{int [][]b=new int[15][15];
		for(int i=0;i<chessBoard.length;i++)
			for(int j=0;j<chessBoard[0].length;j++)
			{
				b[i][j]=a[i][j];
			}
		return b;
	}
	
	public int maxMin(int level, int alpha,int beta,int [][]board,int go)
	{
	    if(level == 0)  return evaluate(board);
	 if(go==getGo())
	 {
	    for(int i=0;i<board.length;i++)
			for(int j=0;j<board[0].length;j++)
			{
				if(canPlay(i,j))
				{
					
					board[i][j]=go;
	            int newval = maxMin(level-1,alpha,beta,board,turn(go));
	            board[i][j]=0;
	            if (newval > alpha)
	            {
	                alpha = newval;
	            }
	            if(alpha > beta)
	                return alpha;
	            }
	            }
	    return alpha;
	 }
	    else{
		    for(int i=0;i<board.length;i++)
				for(int j=0;j<board[0].length;j++)
				{
					if(board[i][j]==0)
					{
						int [][]b=copy(board);
						b[i][j]=go;
	            int newval = maxMin(level-1,alpha,beta,b,turn(go));
	            if (newval < beta)
	            {
	                beta = newval;
	                              }
	        if(alpha > beta)
	            return beta;
	                 }
	            }
	    return beta;
	            }
	}
	
	
	
	
public int evaluate(int [][]board)
{
	int mark=0;
	String s="";
	
for(int i=0;i<board.length;i++)
for(int j=0;j<board[0].length-4;j++)	
{s="";
	for(int k=0;k<5;k++)
	s+=board[i][j+k];
	mark+=eval(s,getGo());
	
}

for(int i=0;i<board.length-4;i++)
for(int j=0;j<board[0].length;j++)	
{s="";
	for(int k=0;k<5;k++)
	s+=board[i+k][j];
	mark+=eval(s,getGo());

}



for(int i=0;i<board.length-4;i++)
for(int j=0;j<board[0].length-4;j++)	
{s="";
	for(int k=0;k<5;k++)
	s+=board[i+k][j+k];
	mark+=eval(s,getGo());

}


for(int i=0;i<board.length-4;i++)
for(int j=0;j<board[0].length-4;j++)	
{s="";
	for(int k=0;k<5;k++)
	s+=board[i+k][j+4-k];
	mark+=eval(s,getGo());

}




	return mark;
}


}