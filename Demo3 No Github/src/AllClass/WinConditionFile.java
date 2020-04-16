package AllClass;



public class WinConditionFile {
	
	
	
	public int[][] chessBoard;
	public int step = 0;
	
	
	public WinConditionFile (int aa)
	{
		chessBoard = new int[15][15];
		for (int a = 0; a < 15; a++)
		{
			for (int b = 0; b < 15 ; b++)
			{
				chessBoard[a][b] = 0;
			}
		}
	}
	
	public boolean canPlay(int x,int y)
	{
		if(chessBoard[x][y]==0)
	    return true;
		return false;
	}
	
	
	
	public void play(int x,int y)
	{
		chessBoard[x][y]=step++%2+1;
	}
 

 
	public boolean checkWin(int x,int y, int go)
	{   	
		if(checkDiagonal(x,y, go) || checkRow(x,y,go) || checkCol(x,y,go)) 
			return true;
		return false;

	}


 public boolean checkRow(int x, int y, int piece) {
		int counter = 0;
		//System.out.println(chessBoard[x][y]);
		for (int i = y + 1; i < 15; i++)
		{
			if (chessBoard[x][i] == piece)
			{
				counter++;
			}
			else
			{
				break;
			}
			
		}
		
		for (int i = y; i >= 0; i--) {
			if (chessBoard[x][i] == piece)
				counter++;
	     else break;
		}
		//System.out.println(counter);
	 if(counter>=5)
		return true;
	 
	 return false;
		
	}

	public boolean checkCol(int x, int y, int piece) 
	{
		int counter = 0;//
		for (int j = y + 1; j < 15; j++)
		{
			if (chessBoard[j][y] == piece)
				counter++;
				else break;
		}
		
		for (int j = y; j >= 0; j--) {
			if (chessBoard[j][y] == piece)
				counter++;
	     else break;
		}
	 if(counter>=5)
		return true;
	 return false;
		
	}
public boolean checkDiagonal(int x, int y, int piece)
{
		int counter = 0;
		for (int i = x + 1,j =y+1; i < 15 && j < 15;i++,j++)
		{
			if (chessBoard[i][j] == piece)
				counter++;
				else break;
		}
		
		for (int i = x,j =y; i >=0 && j >=0;i--,j--) {
			if (chessBoard[i][j] == piece)
				counter++;
         else break;
		}
     if(counter>=5)
		return true;
     
     
     counter = 0;
		for (int i = x + 1,j =y-1; i < 15 && j>0;i++,j--)
		{
			if (chessBoard[i][j] == piece)
				counter++;
				else break;
		}
		
		for (int i = x,j =y; i >=0 && j <15;i--,j++) 
		{
			if (chessBoard[i][j] == piece)
				counter++;
         else break;
		}
     
		 if(counter>=5)
		return true; 
     return false;	
}

}
