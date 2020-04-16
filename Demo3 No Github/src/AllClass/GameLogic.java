package AllClass;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class GameLogic
{	
	
	 private int game[][];
	 private ArrayList<Integer> move;

	 public GameLogic ()
	 {
		 game = new int[15][15];
		 for (int a = 0; a < 15; a++)
		 {
			 for (int b = 0; b < 15; b++)
			 {
			 	 game[a][b] = 0;
			 }
		 }
		 move = new ArrayList<Integer>();
	 }
	
	 public void play(int x, int y, int piece)
	 {
		 game[x][y] = piece;
		 this.move.add(x);
		 this.move.add(y);
		 
	 }
	 
	 public void play(int x, int y, int piece, AIhard ai)
	 {
		 game[x][y] = piece;
		 this.move.add(x);
		 this.move.add(y);
		 ai.play(x, y, piece);
	 }
	
	
	 public void setEmpty(int x, int y)
	 {
		 game[x][y] = 0;
	 }
	 
	 public boolean checkRow(int x, int y, int piece) {
			int counter = 0;
			//System.out.println(chessBoard[x][y]);
			for (int i = y + 1; i < 15; i++)
			{
				if (game[x][i] == piece)
				{
					counter++;
				}
				else
				{
					break;
				}
				
			}
			
			for (int i = y; i >= 0; i--) {
				if (game[x][i] == piece)
					counter++;
		     else break;
			}
			//System.out.println(counter);
		 if(counter>=5)
		 {
			return true; 
		 }
			
		 
		 return false;
			
		}
	/*
	 * This method checks whether a player win the game by having # of same piece in a column
	 * 
	 * Usage --> checkcol(int check)
	 * 
	 * Parameter:
	 * int check: the kind of piece (1 for black and 2 for white)
	 * 
	 * return true if player one of the player met the win condition for win in column, else return false.
	 */
	

	
	 public boolean checkCol(int x, int y, int piece) 
		{
			int counter = 0;//
			for (int j = y + 1; j < 15; j++)
			{
				if (game[j][y] == piece)
					counter++;
					else break;
			}
			
			for (int j = y; j >= 0; j--) {
				if (game[j][y] == piece)
					counter++;
		     else break;
			}
		 if(counter>=5)
			return true;
		 return false;
			
		}
	
	/*
	 * Check in diagonal function
	 */
	 public boolean checkDiagonal(int x, int y, int piece)
	 {
	 		int counter = 0;
	 		for (int i = x + 1,j =y+1; i < 15 && j < 15;i++,j++)
	 		{
	 			if (game[i][j] == piece)
	 				counter++;
	 				else break;
	 		}
	 		
	 		for (int i = x,j =y; i >=0 && j >=0;i--,j--) {
	 			if (game[i][j] == piece)
	 				counter++;
	             else break;
	 		}
	         if(counter>=5)
	 		return true;
	         
	         
	         counter = 0;
	 		for (int i = x + 1,j =y-1; i < 15 && j>0;i++,j--)
	 		{
	 			if (game[i][j] == piece)
	 				counter++;
	 				else break;
	 		}
	 		
	 		for (int i = x,j =y; i >=0 && j <15;i--,j++) 
	 		{
	 			if (game[i][j] == piece)
	 				counter++;
	             else break;
	 		}
	         
	 		 if(counter>=5)
	 		return true; 
	         return false;	
	 }
	
	 
	 
	 
	 public boolean canPlay(int x,int y)
		{
			if(game[x][y]==0)
		    return true;
			return false;
		}
	
	 
	 
	 
	 public boolean checkWin(int x,int y, int go)
		{   	
			if(checkDiagonal(x,y, go) || checkRow(x,y, go) || checkCol(x,y, go))
				return true;
			return false;

		}
	 
	 
	 
	 
	 public void clearBoard()
	 {
		 for (int a = 0; a < 15; a++)
		 {
			 for (int b = 0; b < 15; b++)
			 {
			 	 game[a][b] = 0;
			 }
		 }
		 move.clear();
	 }

	 
	 public int[] goBack_One()
	 {
		int a = move.get(move.size() - 2);
		int b = move.get(move.size() - 1);
		game[a][b] = 0;
		move.remove(move.size() - 2); 
		move.remove(move.size() - 1);
		
		int[] List = {a,b};
		return List;
	 }
	 
	 public int[] goBack_Two(AIhard ai)
	 {
			int a = move.get(move.size() - 2);
			int b = move.get(move.size() - 1);
			int c = move.get(move.size() - 4);
			int d = move.get(move.size() - 3);
			game[a][b] = 0;
			game[c][d] = 0;
			move.remove(move.size() - 4);
			move.remove(move.size() - 3);
			move.remove(move.size() - 2); 
			move.remove(move.size() - 1);
   			ai.back(a, b);
   			ai.back(c, d);
   			int[] List = {a,b,c,d};
   			return List;
	 }
	 
	 public int checkSize()
	 {
		 return new Integer(move.size());
	 }
	 
	 
}


