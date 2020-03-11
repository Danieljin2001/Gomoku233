package menu;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PlayerWindow extends Application{
	
	public Text header() {
		Text text = new Text();
		text.setX(63);
		text.setY(35);
		text.setText("PLAYER 1:");
		text.setFill(Color.BLACK);
		text.setFont(Font.font("Verdana", 25));
		
		return text;
	}
	
	
	public static void main(String[] args){
		
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		Canvas canvas = new Canvas(250,300);
		primaryStage.setMaxWidth(250);        
		primaryStage.setMaxHeight(300);
		primaryStage.setMinWidth(250);        
		primaryStage.setMinHeight(300);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Group root = new Group();
		Scene scene = new Scene(root,Color.BURLYWOOD);
		root.getChildren().add(canvas);
		
		
		
		//add in top, middle, bottom buttons
		MakeButtons black = new MakeButtons();
		MakeButtons white = new MakeButtons();
				
		root.getChildren().add(black.playerButtons("BLACK",50));
		root.getChildren().add(white.playerButtons("WHITE",175));
		//root.getChildren().add(button("CLOSE",175));
		
		//add text "Player 1:" 
		root.getChildren().add(header());

        
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}

}
