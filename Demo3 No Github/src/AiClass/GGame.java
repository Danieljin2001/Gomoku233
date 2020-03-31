package AiClass;
import java.awt.*;

import java.awt.event.ActionListener;

import javax.swing.*;

import javafx.event.ActionEvent;

public class GGame  extends JFrame{

	 private int[][] chessBoard;
     private JButton [][]jb;
     private int step;
     private AI ai;
     
	 public GGame()
	 { 
		 
		 step=0;
		 setSize(600,600);
			JPanel jp= new JPanel();
			jp.setSize(600,600);
			add(jp);
			GridLayout layout=new GridLayout(15,15);
			jp.setLayout(layout);
			jb=new JButton[15][15];
			
			chessBoard=new int[15][15];
			for(int i=0;i<15;i++)
				for(int j=0;j<15;j++)	
					chessBoard[i][j]=0;
			AI ai=new AI(2,chessBoard);
			
			class buttonActionListener implements ActionListener
		    {
			 private int x;
		     private int y;
		     private JButton[][] b;
			    public buttonActionListener(JButton [][]b,int x, int y) 
			    {
			    	this.x=x;
			    	this.y=y;
			    	this.b=b;
			    }
			    
			    public void actionPerformed(java.awt.event.ActionEvent e)
			    {
			    	if(canPlay(x,y))
			    	{	play(x,y);
			    	b[x][y].setBackground(Color.BLACK);
			    	if(checkWin(x,y))
			    		System.out.println("Black win");
			    	
			    	int []a=ai.playChess();
			    	int m=a[0],n=a[1];
			    	play(m,n);
			    	b[m][n].setBackground(Color.WHITE);
			    	if(checkWin(m,n))
			    		System.out.println("white win");
			    	
			    	}
			    }
		    }
			
			
			
			for(int i=0;i<15;i++)
				for(int j=0;j<15;j++)	
			{
				jb[i][j]=new JButton();
	            jb[i][j].setBackground(Color.YELLOW);
				
				jb[i][j].addActionListener(new buttonActionListener(jb,i,j));
				
			    jp.add(jb[i][j]);
			    
			}
		 
		 
		 
	 }
	 public static void main(String[] args)
	 {
			
			GGame game=new GGame();
			game.setVisible(true); 
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
