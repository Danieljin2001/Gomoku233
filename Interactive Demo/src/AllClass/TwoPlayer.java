package AllClass;

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

public class TwoPlayer extends Application {
	
	final private String rule = "Player can win a game by having 5 or more vertically, horizontally or diagonally. Now enejoy the game. :-)";
	private Button[][] board;
	private Group window;
	final private int row = 15;
	private int go = 1;
	//private int[][] chessBoard;
	private static Scene scene;
	private Button help;
	private Button quit;
	private Button reset;
	private Button goback;
	private Text text;
	//private int term;
	//ArrayList<Integer> move;
	private boolean won = false;
	
	EventHandler<ActionEvent> click;
	
	public TwoPlayer()
	{
		
		
		//initialize everything
		//term = 1;
		//move = new ArrayList<Integer>();
		GameLogic logic = new GameLogic();
		go = MenuWindow.getGo();
		window = new Group();
		scene = new Scene(window, 900, 600,Color.BURLYWOOD);
		board = new Button[row][row];
		//chessBoard=new int[15][15];
		//for(int i=0;i<15;i++)
			//for(int j=0;j<15;j++)	
				//chessBoard[i][j]=0;
		
		
		//goback button
		MakeButtons undo1 = new MakeButtons();
		goback = undo1.boardButtons("UNDO",330);
		window.getChildren().add(goback);
	
		
		goback.setOnAction(new EventHandler<ActionEvent>()
		{
		   	@Override
		   	public void handle(ActionEvent event)
		   	{
		   		if (logic.checkSize() > 1 && !won)
		   		{
		   			int[] List = logic.goBack_One();
		   			board[List[0]][List[1]].setGraphic(getImage());
		   			System.out.println(go);
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
		   		go = MenuWindow.getGo();
		   		logic.clearBoard();
		   		//move.clear();
		   		//move.clear();
		   		window.getChildren().remove(text);
		   		
				//for(int i=0;i<15;i++)
					//for(int j=0;j<15;j++)	
						//chessBoard[i][j]=0;
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
				   				{System.out.println(c);
				   					if (go == 1)
				   					{
				   						//place down the black piece
				   						logic.play(c,d, go);
				   				    	
				   				    	Image black = new Image ("gomoku_black.png", 90, 90, true, true);
				   						ImageView a = new ImageView(black);
				   						a.setFitWidth(450/14 + 22);
				   						a.setFitHeight(450 /14 + 22);
				   						board[c][d].setGraphic(a);
				   						
				   						board[c][d].setOnAction(null);
				   						//move.add(c);
				   						//move.add(d);
				   						
				   						//System.out.println(go);
				   						if(logic.checkWin(c,d,go)) {
				   							goback.setOnAction(null);
				   				    		window.getChildren().add(winText(go));
				   				    		for (int q = 0; q < row; q++)
				   					   		{
				   					   			for (int r = 0; r < row; r++) {
				   					   				board[q][r].setOnAction(null);
				   					   				}
				   					   			
				   					   			}
				   				    		}
				   						nextTerm();
				   				    	}
				   					
				   					else
				   					{
				   					//place down the white piece piece
				   						
				   				    	logic.play(c,d,go);
				   				    	Image black = new Image ("gomoku white.png", 90, 90, true, true);
				   						ImageView a = new ImageView(black);
				   						a.setFitWidth(450/14 + 22);
				   						a.setFitHeight(450 /14 + 22);
				   						board[c][d].setGraphic(a);
				   						board[c][d].setOnAction(null);
				   						//move.add(c);
				   						//move.add(d);
				   						
				   						//System.out.println(go);
				   						if(logic.checkWin(c,d,go)) {
				   							goback.setOnAction(null);
				   				    		window.getChildren().add(winText(go));
				   				    		for (int q = 0; q < row; q++)
				   					   		{
				   					   			for (int r = 0; r < row; r++) {
				   					   				board[q][r].setOnAction(null);
				   					   				}
				   					   			
				   					   			}
				   				    		}	
				   						nextTerm();
				   				    	}
				   					break;
				   						}
				   					}
				   					//break;
				   				}
				   			}
				   		};
				   		board[a][b].setOnAction(click);
				   		window.getChildren().add(board[a][b]);
				    }
						
				}
				   
				   	
			
				//add it to the parent node
				
			}
		
	
	public Scene getScene()
	{
		
		
		Group window = new Group(this.window);
		return new Scene(window, 900, 600,Color.BURLYWOOD);
		
	}
	public void nextTerm()
	{
		if (go == 1)
			{
				go = 2;
			}
			else
			{
				go = 1;
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
		
		TwoPlayer a = new TwoPlayer();
		launch();
	}
	/*
	public boolean canPlay(int x,int y)
	{
		if(chessBoard[x][y]==0)
	    return true;
		return false;
	}
	
	
	
	public void play(int x,int y)
	{
		chessBoard[x][y]= go;
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
*/

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
   
	
	
	
}