package AllClass;


public class AI{
	//go is either 1 or 2 (1 represent "black" , 2 represent "White"
	//chessBoard is a TWO dimensional array that record chessBoard information.
	private int go;  
	private int [][]chessBoard;
	public AI(int g,int [][]currentPosition)
	{   this.chessBoard=currentPosition;
		this.go=g;
	}

	
	//This method return the integer which represent the AI player is White or Black.
	public int getGo()
	{return go;}


	//This method check if AI can play chess at (x,y).
	public boolean canPlay(int x,int y)
	{
		if(chessBoard[x][y]==0)
	    return true;
		return false;
	}
	
	//this method play chess on this position : (x,y);
	public void play(int x,int y)
	{
		chessBoard[x][y]=getGo();
	}
	
	
	
	
	
	//This method iterates through every position on the chessBoard;
	//It calculate the evaluateMark of every position and return the position (an integer array have two value: x, y) that have the highest score;
	int[] playChess()
	{   int x=0,y=0;
		int evaluateMark=0;
		int []result=new int[2];
	for(int i=0;i<chessBoard.length;i++)
		for(int j=0;j<chessBoard[0].length;j++)
		{
			if(canPlay(i,j))
			{
				play(i,j);
				int mark=evaluate(i,j);
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
	
	
	//This static method have two argument:
	//The first one is a shorter String.
	//the second one is a longer String.
	//It checks and returns the times of the short string appears in the long string (to calculate the evaluateMark);
	public static int count(String subS,String supS)
	{  int num=0;
		for(int i=0;i<supS.length()-subS.length()+1;i++)
		{
			for(int j=0;j<subS.length();j++)
			{
				if(supS.substring(i,i+subS.length()).equals(subS))
				{
					num++;
				}
			}
		}
		return num;
	}
	
	
	
	
	
	//This method  receive a position (x,y) on the chessBoard
	//It return the evaluateMark of this position.
	//A high evaluateMark indicates that AI play chess at this position is valuable.   
	public int evaluate(int x,int y)
	{   int evaluateMark=0;
		String[] winGroup;
		int go=getGo();
    //Different piece array have different mark.
	// We ranked them according to the probability of winning the game;
	    String[] winGroup1={"11111","12222","22221","22122","21222","22212","11110","01111","11011","10111","11101","022120","021220","12220","02221","011100","001110","011010","010110","002120","021200","002210","012200","001100","001010","010100","000100","001000"};

	    
	    String []winGroup2={"22222","11112","21111","11211","12111","11121","22220","02222","22022","20222","22202","011210","012110","21110","01112","022200","002220","022020","020220","001210","012100","001120","021100","002200","002020","020200","000200","002000"};
	if(go==1)
	{
		winGroup=winGroup1;
	}
	else
		winGroup=winGroup2;
	    int []mark= {50000000,12500000,12500000,12500000,12500000,12500000,2500000,500000,500000,100000,100000,100000,20000,20000,4000,4000,625,625,625,625,125,125,25,25,5,5,5,1,1};
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
	    	for(int i=0;i<winGroup.length;i++)
	    		evaluateMark+=count(winGroup[i],sup)*mark[i];
	    }
		return evaluateMark;
	}
}
