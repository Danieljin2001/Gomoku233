package menu;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

//image link: http://www.clker.com/cliparts/6/f/6/3/11954254221998234535goweichi_jes_s_torrado_c_02.svg.hi.png
//this class shows how the menu window looks like
public class MenuWindow extends Application {
	
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
		MakeButtons top = new MakeButtons();
		MakeButtons mid = new MakeButtons();
		MakeButtons bot = new MakeButtons();
		
		
		root.getChildren().add(top.menuButtons("ONE PLAYER",75));
		root.getChildren().add(mid.menuButtons("TWO PLAYER",208));
		root.getChildren().add(bot.menuButtons("EXIT",341));
		
		//add image of go board
		Image img = new Image("go board.png");
		gc.drawImage(img,375,180,img.getHeight()*0.8,img.getWidth()*0.8 );
        


        
		primaryStage.setScene(scene);
		primaryStage.show();
	
	}

}
