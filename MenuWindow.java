package Start;

import Start.PlayerWindow;
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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//image link: http://www.clker.com/cliparts/6/f/6/3/11954254221998234535goweichi_jes_s_torrado_c_02.svg.hi.png
//this class shows how the menu window looks like
public class MenuWindow extends Application {
	final int buttonX = 75; //constant button distance away from left edge of window
	final int buttonWidth = 200; //constant button width
	final int buttonHeight = 83; //constant button height
			
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
        		+ " -fx-text-fill: #000000");
        
		return button;
	}

	public static void main(String[] args){
	
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		Canvas canvas = new Canvas(720,500);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Group root = new Group();
		Scene scene = new Scene(root,Color.BURLYWOOD);
		root.getChildren().add(canvas);
		
		//write "gomoku" on the right side
		gc.fillText("GOMOKU", 475, 150);
	
		//add in top, middle, bottom buttons
		root.getChildren().add(button("ONE PLAYER",75));
		root.getChildren().add(button("TWO PLAYER",208));
		root.getChildren().add(button("EXIT",341));
		
		//add image of go board
		Image img = new Image("go board.png");
		gc.drawImage(img,375,180,img.getHeight()*0.8,img.getWidth()*0.8 );
        

        
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}

}
