

import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OnePlayer extends Application {
	
	final String rule = "Player can win a game by having 5 or more vertically, horizontally or diagonally. Now enejoy the game. :-)";
	Button[][] board;
	Group window;
	final private int row = 15;
	
	int term;
	
	public static Scene scene;
	
	private int[][] chessBoard;
    private AI ai;
    private int step;
    Text text;
	
	Button help;
	Button quit;
	Button reset;
	Button goback;
	ArrayList<Integer> move;
	boolean won;
	int movePlace = 0;
	EventHandler<ActionEvent> click;
	
	
	
	
	public Text winText(int term) {
		text = new Text();
		text.setX(30);
		text.setY(300);
		text.setFill(Color.RED);
		text.setFont(Font.font("Verdana", 80));
		if(term == 1) {
			text.setText("BLACK WINS!");
		}
		else {
			text.setText("WHITE WINS!");
		}
		
		return this.text;
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

 
	
	
	
	
	public OnePlayer()
	{
		
		
		//initialize everything
		move = new ArrayList<Integer>();
		
		chessBoard=new int[15][15];
		for(int i=0;i<15;i++)
			for(int j=0;j<15;j++)	
				chessBoard[i][j]=0;
		AI ai=new AI(2,chessBoard);
		step = 0;
		won = false;
		term = 1;
		window = new Group();
		scene = new Scene(window, 900, 600,Color.BURLYWOOD);
		Button[][] board = new Button[row][row];
		
		
		//goback button
		MakeButtons undo1 = new MakeButtons();
		goback = undo1.boardButtons("UNDO",330);
		window.getChildren().add(goback);
		
		goback.setOnAction(new EventHandler<ActionEvent>()
		   {
		   	@Override
		   	public void handle(ActionEvent event)
		   	{
		   		if (move.size() > 0 && !won)
		   		{
		   			int a = move.get(movePlace);
		   			int b = move.get(movePlace + 1);
		   			board[a][b].setGraphic(getImage());
		   			board[a][b].setOnAction(click);
		   			chessBoard[a][b] = 0;
		   			movePlace += 2;
		   			nextTerm();
		   		}
		   	}
		   });
		
		
		
		//help button

		MakeButtons help1 = new MakeButtons();
		help = help1.boardButtons("HELP",100);
		window.getChildren().add(help);
		help.setOnAction(new EventHandler<ActionEvent>()
		   {
		   	@Override
		   	public void handle(ActionEvent event)
		   	{
		   		JOptionPane.showMessageDialog(null, rule, "Game rule", JOptionPane.INFORMATION_MESSAGE);
		   	}
		   });
	
	
		//reset button
		MakeButtons reset1 = new MakeButtons();
		reset = reset1.boardButtons("RESET",220);
		window.getChildren().add(reset);
		reset.setOnAction(new EventHandler<ActionEvent>()
		   {
		   	@Override
		   	public void handle(ActionEvent event)
		   	{
		   		for (int e = 0; e < row; e++)
		   		{
		   			for (int f = 0; f < row; f++)
		   			{

		   				board[e][f].setGraphic(getImage());
		   				board[e][f].setOnAction(click);
		   			}
		   		}
		   		term = 1;
		   		window.getChildren().remove(text);
		   		won = false;
		   		movePlace = 0;
		   		
				for(int i=0;i<15;i++)
					for(int j=0;j<15;j++)	
						chessBoard[i][j]=0;
		   	}
		   });
		
		
		
		
		//quit button
		MakeButtons quit1 = new MakeButtons();
		quit = quit1.boardButtons("QUIT",450);
		window.getChildren().add(quit);
		quit.setOnAction(new EventHandler<ActionEvent>()
		   {
		   	@Override
		   	public void handle(ActionEvent event)
		   	{
		   		System.exit(0);
		   	}
		   });
		
		
		

		//create all the buttons
		for (int a = 0; a < row; a++)
		{
			for (int b = 0; b < row; b++)
			{
				board[a][b] = new Button();
				//get the button to the correct position
				board[a][b].setLayoutX(50 + b / 14.0 * 450);
				board[a][b].setLayoutY(50 + a / 14.0 * 450);			
				
				
				
				//get the size of the button
				board[a][b].setMinSize(450/14, 450/14);
				board[a][b].setMaxSize(450/14, 450/14);

				board[a][b].setGraphic(getImage());
				board[a][b].setStyle("-fx-background-color: transparent;");
				
				//When mouse hovers over the button
				board[a][b].setOnMouseEntered(new EventHandler<MouseEvent>() {

				    @Override
				    public void handle(MouseEvent t) {
				    	//System.out.println(((Button) t.getSource()).getStyle());
				        ((Button) t.getSource()).setStyle("-fx-background-color:#dae7f3;");
				    }
				});
				
				//WHen mouse leaves the button
				board[a][b].setOnMouseExited(new EventHandler<MouseEvent>() {

				    @Override
				    public void handle(MouseEvent t) {
				    	((Button) t.getSource()).setStyle("-fx-background-color: transparent;");
				    }
				});
				
			
				
				
				
				
				
				

				//When mouse click the button
				//board[a][b].setOnAction(new EventHandler<ActionEvent>()
				   //{
				 click = new EventHandler<ActionEvent>() {
				    @Override
				    public void handle(ActionEvent event) {
				    	for (int c = 0; c < row; c++)
				   		{
				   			for (int d = 0; d < row; d++)
				   			{
				   				if (board[c][d] == event.getSource())
				   					{
				   						if(canPlay(c,d))
				   				    	{	play(c,d);
				   				    	term = 1;
				   				    	Image black = new Image ("gomoku_black.png", 90, 90, true, true);
				   						ImageView a = new ImageView(black);
				   						a.setFitWidth(450/14 + 22);
				   						a.setFitHeight(450 /14 + 22);
				   						board[c][d].setGraphic(a);
				   						move.add(c);
				   						move.add(d);
				   				    	
				   				    	if(checkWin(c,d)) {
				   				    		window.getChildren().add(winText(term));
				   				    		won = true;
				   				    		for (int q = 0; q < row; q++)
				   					   		{
				   					   			for (int r = 0; r < row; r++) {
				   					   				board[q][r].setOnAction(null);
				   					   			}
				   					   			
				   					   		}
				   				    	}
				   				    		
				   				    	
				   				    	int [] AI = ai.playChess();
				   				    	int m= AI[0],n= AI[1];
				   				    	play(m,n);
				   				    	term = 2;
				   				    	Image white = new Image ("gomoku white.png", 90, 90, true, true);
				   						ImageView b = new ImageView(white);
				   						b.setFitWidth(450/14 + 22);
				   						b.setFitHeight(450 /14 + 22);
				   						board[m][n].setGraphic(b);
				   						move.add(m);
				   						move.add(n);
				   				    	if(checkWin(m,n)){
					   						window.getChildren().add(winText(term));
					   						won = true;
					   						for (int q = 0; q < row; q++)
				   					   		{
				   					   			for (int r = 0; r < row; r++) {
				   					   				board[q][r].setOnAction(null);
				   					   				}
				   					   			}
				   				    		}
				   				    	}
				   					}
				   				}
				   			}
				   		}		 
				};
				
				   board[a][b].setOnAction(click);
				   	
			
				//add it to the parent node
				window.getChildren().add(board[a][b]);
			}
		}
	}
	
	public void nextTerm()
	{
		if (term == 1)
			{
				term = 2;
			}
			else
			{
				term = 1;
			}
	}
	
	public ImageView getImage()
	{
		Image center = new Image ("center.png", 60, 60, false, true);
		ImageView c = new ImageView(center);
		c = new ImageView(center);
		c.setFitWidth(450/14 + 2);
		c.setFitHeight(450 /14 + 2);
		return c;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		

		primaryStage.setTitle("Gomoku");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String args[]) {
		
		OnePlayer a = new OnePlayer();
		launch();
	}
}
