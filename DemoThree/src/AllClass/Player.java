package AllClass;
//this class is to be used in the future
public class Player {
	private int go;  
	private int [][]chessBoard;
	//This method return the integer which represent the AI player is White or Black.
	public int getGo()
	{return go;}
	
	public void setGo(int aGo) {
		this.go = aGo;
	}
	
	public int [][] getChessBoard(){
		return this.chessBoard;
	}
	
	public void setChessBoard(int[][] position) {
		this.chessBoard = position;
	}

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

 
	public boolean checkWin(int x,int y)
	{   	
		if(checkDiagonal(x,y) || checkRow(x,y) || checkCol(x,y)) 
			return true;
		return false;

	}


	public boolean checkRow(int x, int y) {
	int counter = 0;
	for (int i = x + 1; i < 15; i++)
	{
		if (chessBoard[i][y] ==chessBoard[x][y])
			counter++;
			else break;
	}
	
	for (int i = x; i >= 0; i--) {
		if (chessBoard[i][y] ==chessBoard[x][y])
			counter++;
     else break;
	}
	if(counter>=5)
		return true;
	return false;
	
	}

	public boolean checkCol(int x, int y) 
	{
	int counter = 0;//
	for (int j = y + 1; j < 15; j++)
	{
		if (chessBoard[x][j] ==chessBoard[x][y])
			counter++;
			else break;
	}
	
	for (int j = x; j >= 0; j--) {
		if (chessBoard[x][j] ==chessBoard[x][y])
			counter++;
     else break;
	}
	if(counter>=5)
		return true;
	return false;
	
	}
	public boolean checkDiagonal(int x, int y)
	{
		int counter = 0;
		for (int i = x + 1,j =y+1; i < 15 && j < 15;i++,j++)
		{
			if (chessBoard[i][j] ==chessBoard[x][y])
				counter++;
				else break;
		}
		
		for (int i = x,j =y; i >=0 && j >=0;i--,j--) {
			if (chessBoard[i][j] ==chessBoard[x][y])
				counter++;
            else break;
		}
        if(counter>=5)
		return true;
        
        
        counter = 0;
		for (int i = x + 1,j =y-1; i < 15 && j>0;i++,j--)
		{
			if (chessBoard[i][j] ==chessBoard[x][y])
				counter++;
				else break;
		}
		
		for (int i = x,j =y; i >=0 && j <15;i--,j++) 
		{
			if (chessBoard[i][j] ==chessBoard[x][y])
				counter++;
            else break;
		}
        
		 if(counter>=5)
		return true;
        return false;	
	}
 
 
 
	
	
	
}
