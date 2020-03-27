package AllClass;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class MenuWindow  extends Application {

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
			
			
			//add image of go board
			Image img = new Image("go board.png");
			gc.drawImage(img,375,180,img.getHeight()*0.8,img.getWidth()*0.8 );
			
			
			//add in top, middle, bottom buttons
			//Add the click event
			//If this button is clicked then the scene changes
			MakeButtons top = new MakeButtons();
			MakeButtons mid = new MakeButtons();
			MakeButtons bot = new MakeButtons();
			
			Button onePlayer = top.menuButtons("ONE PLAYER",75);
			onePlayer.setOnAction(new EventHandler<ActionEvent>()
			   {
			   	@Override
			   	public void handle(ActionEvent event)
			   	{
			   		Stage secondaryStage = new Stage();
			   		Canvas canvas = new Canvas(720,500);
					secondaryStage.setMaxWidth(720);        
					secondaryStage.setMaxHeight(500);
					secondaryStage.setMinWidth(720);        
					secondaryStage.setMinHeight(500);
					Group root = new Group();
					secondaryStage.initStyle(StageStyle.UNDECORATED);
					GraphicsContext gc = canvas.getGraphicsContext2D();
					Scene scene = new Scene(root,Color.BURLYWOOD);
					root.getChildren().add(canvas);

					//write "gomoku" on the right side
					root.getChildren().add(gomoku());
					
					//add image of go board
					Image img = new Image("go board.png");
					gc.drawImage(img,375,180,img.getHeight()*0.8,img.getWidth()*0.8 );
					
					//add in top, middle, bottom buttons
					MakeButtons black1 = new MakeButtons();
					Button black = black1.menuButtons("BLACK",75);
					black.setOnAction(new EventHandler<ActionEvent>()
					   {
					   	@Override
					   	public void handle(ActionEvent event)
					   	{
					   		JavaFX_board2 a = new JavaFX_board2();
							primaryStage.setScene(JavaFX_board2.scene);
					   		primaryStage.show();
					   		secondaryStage.hide();

					   	}
					   });
					
					
					root.getChildren().add(black);
					
					MakeButtons white1 = new MakeButtons();
					Button white = white1.menuButtons("WHITE",208);
					white.setOnAction(new EventHandler<ActionEvent>()
					   {
					   	@Override
					   	public void handle(ActionEvent event)
					   	{
					   		JavaFX_board2 a = new JavaFX_board2();
					   		primaryStage.setScene(JavaFX_board2.scene);
					   		primaryStage.show();
					   		secondaryStage.hide();

					   	}
					   });
					
					root.getChildren().add(white);
					
					MakeButtons back1 = new MakeButtons();
					Button back = back1.menuButtons("GO BACK",341);
					back.setOnAction(new EventHandler<ActionEvent>()
					   {
					   	@Override
					   	public void handle(ActionEvent event)
					   	{
					   		primaryStage.show();
					   		secondaryStage.hide();

					   	}
					   });
					root.getChildren().add(back);
					secondaryStage.setScene(scene);
					secondaryStage.show();
					primaryStage.hide();
		
			   	}
			   });
			//Add the first button to the game
			root.getChildren().add(onePlayer);
			
			
			
			
			
			
			
			
			
			
			//Add the second button
			///Button 
		
			Button twoPlayer = mid.menuButtons("TWO PLAYER",208);
			twoPlayer.setOnAction(new EventHandler<ActionEvent>()
			   {
			   	@Override
			   	public void handle(ActionEvent event)
			   	{
			   		JavaFX_board2 a = new JavaFX_board2();
			   		primaryStage.setScene(JavaFX_board2.scene);
			   	}
			   });
			root.getChildren().add(twoPlayer);
			
			
			
			
			
			
			
			
			
			
			//create the third button
	
			Button Exit = bot.menuButtons("EXIT",341);
			
			Exit.setOnAction(new EventHandler<ActionEvent>()
			   {
			   	@Override
			   	public void handle(ActionEvent event)
			   	{
			   		System.exit(0);
			   	}
			   });
			
			root.getChildren().add(Exit);

			primaryStage.setScene(scene);
			primaryStage.show();
		
		}
	
}

