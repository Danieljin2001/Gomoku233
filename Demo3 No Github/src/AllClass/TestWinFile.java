package AllClass;

import static org.junit.Assert.*;

import org.junit.Test;

import AllClass.WinConditionFile;




public class TestWinFile {

	


	//Testing win in row function
	@Test
	public void test_winInRow()
	{
		WinConditionFile a = new WinConditionFile(1);
		for (int b = 0; b < 5 ; b++)
		{
			a.chessBoard[10][b + 5] = 1;
				
		}
		System.out.println("Testing winInRow");
		for (int c = 0; c < 15; c++)
		{
			for (int d = 0; d < 15 ; d++)
			{
				System.out.print(a.chessBoard[c][d]);
			}
			System.out.println(" ");
		}
		assertTrue("You win in this condition || 1, 1 || game board in console",a.checkRow(10, 5, 1));
		assertTrue("You win in this condition || 1, 2 || game board in console",a.checkRow(10, 6, 1));
		assertTrue("You win in this condition || 1, 3 || game board in console",a.checkRow(10, 7, 1));
		assertTrue("You win in this condition || 1, 4 || game board in console",a.checkRow(10, 8, 1));
		assertTrue("You win in this condition || 1, 0 || game board in console",a.checkRow(10, 9, 1));
		//assertFalse("You do not win in this condition || 2, 2 || Game board in console", a.checkRow(2,2));
		assertTrue("The game is over", a.checkWin(10, 6, 1));
		
		
		
	}
	
	
	//Testing win in column function
	@Test
	public void test_winCol() 
	{
		
		WinConditionFile a = new WinConditionFile(1);
		for (int b = 0; b < 5 ; b++)
		{
			a.chessBoard[b][1] = 1;
		}
		
		System.out.println("Testing winInCol");
		for (int c = 0; c < 15; c++)
		{
			for (int d = 0; d < 15 ; d++)
			{
				System.out.print(a.chessBoard[c][d]);
			}
			System.out.println(" ");
		}
		
		assertTrue("You win in this condition || 0, 1 || game board in console",a.checkCol(0, 1, 1));
		assertTrue("You win in this condition || 1, 1 || game board in console",a.checkCol(1, 1, 1));
		assertTrue("You win in this condition || 2, 1 || game board in console",a.checkCol(2, 1, 1));
		assertTrue("You win in this condition || 3, 1 || game board in console",a.checkCol(3, 1, 1));
		assertTrue("You win in this condition || 4, 1 || game board in console",a.checkCol(4, 1, 1));
		//assertFalse("You do not win in this condition || 2, 2 || game board in console", a.checkCol(2,2));
		assertTrue("The game is over", a.checkWin(2, 1, 1));
	}
	
	
	
	//Testing win in diagonal function
	@Test
	public void test_winDiag()
	{
		WinConditionFile a = new WinConditionFile(1);
		for (int b = 0; b < 5 ; b++)
		{
			a.chessBoard[b][b] = 1;
		}
		
		System.out.println("Testing winInDiag");
		for (int c = 0; c < 15; c++)
		{
			for (int d = 0; d < 15 ; d++)
			{
				System.out.print(a.chessBoard[c][d]);
			}
			System.out.println(" ");
		}
		
		assertTrue("You win in this condition || 0, 0 || game board in console",a.checkDiagonal(0, 0, 1));
		assertTrue("You win in this condition || 1, 1 || game board in console",a.checkDiagonal(1, 1, 1));
		assertTrue("You win in this condition || 2, 2 || game board in console",a.checkDiagonal(2, 2, 1));
		assertTrue("You win in this condition || 3, 3 || game board in console",a.checkDiagonal(3, 3, 1));
		assertTrue("You win in this condition || 4, 4 || game board in console",a.checkDiagonal(4, 4, 1));
		assertTrue("The game is over", a.checkWin(2, 2, 1));
	}
		
	
	
}
