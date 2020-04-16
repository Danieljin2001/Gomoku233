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
import AllClass.OnePlayer;
public class MenuWindow  extends Application {

		/**
		  * @Fields go : TODO（go indicates whether the piece is black(1) or white(2)）
		  */
		private static int go = 1;
	
		   
		public static void main(String[] args){
		
			launch(args);
		}
		/**
		  * <p>Title: start</p>
		  * <p>Description: Rewrite the start method of the Aplication class.</p>
		  * @param primaryStage
		  * @see javafx.application.Application#start(javafx.stage.Stage)
		  */
		
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
			MakeButtons top = new MakeButtons();
			MakeButtons mid = new MakeButtons();
			MakeButtons bot = new MakeButtons();
			
			
			
			
			//create top button
			Button onePlayer = top.menuButtons("ONE PLAYER",75);
			onePlayer.setOnAction(new EventHandler<ActionEvent>()
			   {
			   	@Override
			   	public void handle(ActionEvent event)
			   	{
			   		OnePlayer a = new OnePlayer();
			   		primaryStage.setScene(a.getScene());
			   	}
			   });
			
			//Add top button
			root.getChildren().add(onePlayer);
			

			
			//create middle button
			//this button will open up another window showing options for either black or white or go back
			Button twoPlayer = mid.menuButtons("TWO PLAYER",208);
			twoPlayer.setOnAction(
			new EventHandler<ActionEvent>()
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
					
					//create in the black button
					MakeButtons black1 = new MakeButtons();
					Button black = black1.menuButtons("BLACK",75);
					black.setOnAction(new EventHandler<ActionEvent>()
					   {
					   	@Override
					   	public void handle(ActionEvent event)
					   	{
					   		setGo(1);
					   		TwoPlayer a = new TwoPlayer();
							primaryStage.setScene(a.getScene());
					   		primaryStage.show();
					   		secondaryStage.hide();

					   	}
					   });
					
					//add black button
					root.getChildren().add(black);
					
					//create white button
					MakeButtons white1 = new MakeButtons();
					Button white = white1.menuButtons("WHITE",208);
					white.setOnAction(new EventHandler<ActionEvent>()
					   {
					   	@Override
					   	public void handle(ActionEvent event)
					   	{
					   		setGo(2);
					   		TwoPlayer a = new TwoPlayer();
					   		primaryStage.setScene(a.getScene());
					   		primaryStage.show();
					   		secondaryStage.hide();

					   	}
					   });
					//add white button
					root.getChildren().add(white);
					
					//create go back button 
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
					//add go back button
					root.getChildren().add(back);
					secondaryStage.setScene(scene);
					secondaryStage.show();
					primaryStage.hide();
		
			   	}
			   });
			//Add the middle button 
			root.getChildren().add(twoPlayer);

		
			
			//create the bottom button
	
			Button Exit = bot.menuButtons("EXIT",341);
			
			Exit.setOnAction(new EventHandler<ActionEvent>()
			   {
			   	@Override
			   	public void handle(ActionEvent event)
			   	{
			   		System.exit(0);
			   	}
			   });
			
			//add bottom button
			root.getChildren().add(Exit);

			primaryStage.setScene(scene);
			primaryStage.show();
		
		}
		
		
		
		/**
		  * gomoku：  Generate a text box with content “gomoku”。
		  *
		  * @Title: gomoku
		  * @Description: TODO
		  * @param @return    
		  * @return Text    
		  * @throws
		  */
		
		
		public Text gomoku() {
			Text text = new Text();
			text.setX(360);
			text.setY(150);
			text.setText("GOMOKU");
			text.setFill(Color.BLACK);
			text.setFont(Font.font("Verdana", 57));
			
			return text;
		}
		
		
		/**
		  * setGo：  Set the color of the first move piece
		  *
		  * @Title: setGo
		  * @Description: TODO
		  * @param @param piece    
		  * @return 
		  * @throws
		  */
		
		
		public static void setGo(int piece) {
			go = piece;
		}
		/**
		  * getGo :Returns the number representing the color of the first move piece
		  * TODO(1 for black chess 2 for white chess)
		  *
		  * @Title: getGo
		  * @Description: TODO
		  * @param  none
		  * @return int  return an integer value
		  * @throws
		  */
		public static int getGo() {
			return go;
		}

	
}

