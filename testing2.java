package Start;
import AI.AI;
import AI.GGame;
import AllClass.JavaFX_board;
import AllClass.JavaFX_board2;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
	import javafx.scene.Scene;
	import javafx.scene.canvas.Canvas;
	import javafx.scene.canvas.GraphicsContext;
	import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
	import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class testing2  extends Application {
		final int buttonX = 75; //constant button distance away from left edge of window
		final int buttonWidth = 200; //constant button width
		final int buttonHeight = 83; //constant button height
		DropShadow shadow = new DropShadow();	
		
		
		//this is the method that makes buttons 
		public Button button(String name, int y) {
			Button button = new Button(name);
			
			button.setLayoutX(buttonX);
			button.setLayoutY(y);
			button.setPrefWidth(buttonWidth);
			button.setPrefHeight(buttonHeight);
	        button.setStyle(" -fx-background-radius: 20;"
	        		+ "-fx-border-radius: 20;"
	        		+ "-fx-font-size: 20;"
	        		+ " -fx-border-color: #000000;"
	        		+ " -fx-border-width: 2;"
	        		+ " -fx-background-color: #ffffff;"
	        		+ " -fx-text-fill: #000000;"
	        		+ "-fx-background-insets: 0, 0, 1, 2;");
	        
	        button.addEventHandler(MouseEvent.MOUSE_ENTERED,
	        		new EventHandler<MouseEvent>() {
	        	@Override
	        	public void handle(MouseEvent e) {
	        		button.setEffect(shadow);
	        		
	        	}
	        });
	        button.addEventHandler(MouseEvent.MOUSE_EXITED,
	                new EventHandler<MouseEvent>() {
	                  @Override
	                  public void handle(MouseEvent e) {
	                    button.setEffect(null);
	                  }
	                });
	        
	        
			return button;
		}

		public Text gomoku() {
			Text text = new Text();
			text.setX(360);
			text.setY(150);
			text.setText("GOMOKU");
			text.setFill(Color.BLACK);
			text.setFont(Font.font("Verdana", 57));
			
			return text;
		}
		   
		public static void main(String[] args){
		
			launch(args);
		}
		@Override
		public void start(Stage primaryStage) {
			Canvas canvas = new Canvas(720,500);
			primaryStage.setMaxWidth(720);        
			primaryStage.setMaxHeight(500);
			primaryStage.setMinWidth(720);        
			primaryStage.setMinHeight(500);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			Group root = new Group();
			Scene scene = new Scene(root,Color.BURLYWOOD);
			root.getChildren().add(canvas);

			//write "gomoku" on the right side
			root.getChildren().add(gomoku());
			
			
			
			
			
			
			
			
			//add in top, middle, bottom buttons
			//Add the click event
			//If this button is clicked then the scene changes
			Button AI = button("ONE PLAYER",75);
			AI.setOnAction(new EventHandler<ActionEvent>()
			   {
			   	@Override
			   	public void handle(ActionEvent event)
			   	{
					Canvas canvas = new Canvas(300,300);
					primaryStage.setMaxWidth(300);        
					primaryStage.setMaxHeight(800);
					primaryStage.setMinWidth(0);        
					primaryStage.setMinHeight(300);
					//primaryStage.initStyle(StageStyle.UNDECORATED);
					GraphicsContext gc = canvas.getGraphicsContext2D();
					Group root = new Group();
					Scene scene = new Scene(root,Color.BURLYWOOD);
					root.getChildren().add(canvas);
					
				
					
					//add in top, middle, bottom buttons
					
					Button top = PlayerWindow.button("BLACK",50);
					top.setOnAction(new EventHandler<ActionEvent>()
					   {
					   	@Override
					   	public void handle(ActionEvent event)
					   	{
					   		JavaFX_board2 a = new JavaFX_board2();
							primaryStage.setScene(JavaFX_board2.scene);
					   	}
					   });
					
					
					root.getChildren().add(top);
					
					
					Button button = PlayerWindow.button("WHITE",175);
					top.setOnAction(new EventHandler<ActionEvent>()
					   {
					   	@Override
					   	public void handle(ActionEvent event)
					   	{
					   		JavaFX_board2 a = new JavaFX_board2();
					   		primaryStage.setScene(JavaFX_board2.scene);

					   	}
					   });
					
					root.getChildren().add(button);
					primaryStage.setScene(scene);
			   	}
			   });
			//Add the first button to the game
			root.getChildren().add(AI);
			
			
			
			
			
			
			
			
			
			
			//Add the second button
			///Button 
			Button Player = button("TWO PLAYER",208);
			Player.setOnAction(new EventHandler<ActionEvent>()
			   {
			   	@Override
			   	public void handle(ActionEvent event)
			   	{
			   		JavaFX_board2 a = new JavaFX_board2();
			   		primaryStage.setScene(JavaFX_board2.scene);
			   	}
			   });
			root.getChildren().add(Player);
			
			
			
			
			
			
			
			
			
			
			//create the third button
			Button Exit = button("EXIT",341);
			
			Exit.setOnAction(new EventHandler<ActionEvent>()
			   {
			   	@Override
			   	public void handle(ActionEvent event)
			   	{
			   		System.exit(0);
			   	}
			   });
			
			root.getChildren().add(Exit);
			
			//add image of go board
			Image img = new Image("go board.png");
			gc.drawImage(img,375,180,img.getHeight()*0.8,img.getWidth()*0.8 );
 

	        
			primaryStage.setScene(scene);
			primaryStage.show();
		
		}
	
}
