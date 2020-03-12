package Start;

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
	
	public static Button button(String name, int y) {
	Button button = new Button(name);
	
	button.setLayoutX(50);
	button.setLayoutY(y);
	button.setPrefWidth(200);
	button.setPrefHeight(100);
    button.setStyle(" -fx-background-radius: 20;"
    		+ "-fx-border-radius: 20;"
    		+ "-fx-font-size: 20;"
    		+ " -fx-border-color: #000000;"
    		+ " -fx-border-width: 2;"
    		+ " -fx-background-color: #ffffff;"
    		+ " -fx-text-fill: #000000;"
    		+ "-fx-background-insets: 0, 0, 1, 2;");
	return button;
	}
	
	public Text header() {
		Text text = new Text();
		text.setX(85);
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
		Canvas canvas = new Canvas(300,300);
		primaryStage.setMaxWidth(300);        
		primaryStage.setMaxHeight(800);
		primaryStage.setMinWidth(300);        
		primaryStage.setMinHeight(300);
		//primaryStage.initStyle(StageStyle.UNDECORATED);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Group root = new Group();
		Scene scene = new Scene(root,Color.BURLYWOOD);
		root.getChildren().add(canvas);
		
	
		
		//add in top, middle, bottom buttons
		root.getChildren().add(button("BLACK",50));
		root.getChildren().add(button("WHITE",175));
		//root.getChildren().add(button("CLOSE",225));
		
		//add text "Player 1:" 
		root.getChildren().add(header());

        
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}

}
