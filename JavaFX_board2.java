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
import javafx.stage.Stage;

public class JavaFX_board2 extends Application {
	
	final String rule = "Player can win a game by having 5 or more vertically, horizontally or diagonally. Now enejoy the game. :-)";
	Button[][] board;
	Group window;
	final private int row = 15;
	boolean term;
	public static Scene scene;
	Button help;
	Button quit;
	Button reset;
	Button goback;
	ArrayList<int[]> move;
	EventHandler<ActionEvent> click;
	
	public JavaFX_board2()
	{
		
		
		//initialize everything
		move = new ArrayList<int[]>();
		term = true;
		window = new Group();
		scene = new Scene(window, 900, 600,Color.BURLYWOOD);
		Button[][] board = new Button[row][row];
		
		
		//goback button
		goback = new Button("Undo");
		window.getChildren().add(goback);
		goback.setMinSize(200, 60);
		goback.setLayoutX(600);
		goback.setLayoutY(330);
		goback.setOnAction(new EventHandler<ActionEvent>()
		   {
		   	@Override
		   	public void handle(ActionEvent event)
		   	{
		   		if (move.size() > 0)
		   		{
		   			int[] temp = new int[2];
		   			temp = move.get(move.size() - 1);
		   			board[temp[0]][temp[1]].setGraphic(getImage());
		   			board[temp[0]][temp[1]].setOnAction(click);
		   			move.remove(move.size() - 1);
		   			nextTerm();
		   		}
		   	}
		   });
		
		
		
		//help button
		help = new Button();
		window.getChildren().add(help);
		help.setOnAction(new EventHandler<ActionEvent>()
		   {
		   	@Override
		   	public void handle(ActionEvent event)
		   	{
		   		JOptionPane.showMessageDialog(null, rule, "Game rule", JOptionPane.INFORMATION_MESSAGE);
		   	}
		   });
		
		help.setMinSize(200, 60 );
		help.setLayoutX(600);
		help.setLayoutY(100);
		help.setText("Help");
	
		//reset button
		reset = new Button("reset");
		window.getChildren().add(reset);
		reset.setMinSize(200, 60 );
		reset.setLayoutX(600);
		reset.setLayoutY(220);
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
		   		term = true;
		   		move.clear();
		   	}
		   });
		
		
		
		
		//quit button
		quit = new Button();
		window.getChildren().add(quit);
		quit.setMinSize(200, 60 );
		quit.setLayoutX(600);
		quit.setLayoutY(450);
		quit.setText("Quit");
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
				    	System.out.println(((Button) t.getSource()).getStyle());
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
				   					if (term)
				   					{
				   						//place down the black piece
				   						Image piece = new Image ("gomoku_black.png", 90, 90, true, true);
				   						ImageView a = new ImageView(piece);
				   						a.setFitWidth(450/14 + 22);
				   						a.setFitHeight(450 /14 + 22);
				   						board[c][d].setGraphic(a);
				   						int[] List = new int[2];
				   						List[0] = new Integer(c);
				   						List[1] = new Integer(d);
				   						move.add(List.clone());
				   						nextTerm();
				   						//remove the action listener so you cannot place anther piece on the spot
				   						board[c][d].setOnAction(null);
				   					}
				   					else
				   					{
				   						//place down the white piece
				   						Image piece = new Image ("gomoku white.png", 90, 90, true, true);
				   						ImageView a = new ImageView(piece);
				   						a.setFitWidth(450/14 + 22);
				   						a.setFitHeight(450 /14 + 22);
				   						board[c][d].setGraphic(a);
				   						int[] List = new int[2];
				   						List[0] = new Integer(c);
				   						List[1] = new Integer(d);
				   						move.add(List.clone());
				   						nextTerm();
				   						//remove the action listener so you cannot place anther piece on the spot
				   						board[c][d].setOnAction(null);
				   					}
				   					break;
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
		if (term)
			{
				term = false;
			}
			else
			{
				term = true;
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
		
		JavaFX_board2 a = new JavaFX_board2();
		launch();
	}
}
