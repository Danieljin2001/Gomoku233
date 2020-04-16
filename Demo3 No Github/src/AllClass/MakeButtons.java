package AllClass;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

/**
  * @ClassName: MakeButtons
  * @Description: this class determines how the buttons look like and the outputs
  * @author Comsys-zyf
  * @date 
  *
  */
public class MakeButtons extends Button {
	Button button;
	DropShadow shadow = new DropShadow();
	
	
	
	/**
	  * menuButtons This method determines how the menu button looks (ONE PLAYER, TWO PLAYER, EXIT, BLACK. WHITE, GO BACK)
	  *
	  * @Title: menuButtons
	  * @Description: TODO
	  * @param @param name : A string representing the button's name 
	  * @param @param y
	  * @param @return    
	  * @return Button  Returns an instance of the button type.  
	  * @throws
	  */
	
	
	public Button menuButtons(String name, int y ) {
		this.button = new Button(name);
		
		button.setLayoutX(75);
		button.setLayoutY(y);
		button.setPrefWidth(200);
		button.setPrefHeight(83);
        button.setStyle(" -fx-background-radius: 20;" //curved edges for the background
        		+ "-fx-border-radius: 20;" //curved edges for the border
        		+ "-fx-font-size: 20;"
        		+ " -fx-border-color: #000000;"
        		+ " -fx-border-width: 2;"
        		+ " -fx-background-color: #ffffff;"
        		+ " -fx-text-fill: #000000;"
        		+ "-fx-background-insets: 0, 0, 1, 2;");
        makeShadow();
        
		return button;
	}
	
	/**
	  * boardButtons This method determines how the button in the board game window will look (QUIT, UNDO, RESET, HELP)
	  *
	  * @Title: boardButtons
	  * @Description: TODO
	  * @param @param name  A string representing the button's name 
	  * @param @param y
	  * @param @return    
	  * @return Button    Returns an instance of the button type.
	  * @throws
	  */
	
	
	public Button boardButtons(String name, int y ) {
		this.button = new Button(name);
		
		button.setLayoutX(600);
		button.setLayoutY(y);
		button.setPrefWidth(200);
		button.setPrefHeight(60);
        button.setStyle(" -fx-background-radius: 20;" //curved edges for the background
        		+ "-fx-border-radius: 20;" //curved edges for the border
        		+ "-fx-font-size: 20;"
        		+ " -fx-border-color: #000000;"
        		+ " -fx-border-width: 2;"
        		+ " -fx-background-color: #ffffff;"
        		+ " -fx-text-fill: #000000;"
        		+ "-fx-background-insets: 0, 0, 1, 2;");
        makeShadow();
        
		return button;
	}
	/**
	  * makeShadow:  It makes shadows once the mouse enters the button and removes show once it leaves.
	  *
	  * @Title: makeShadow
	  * @Description: TODO
	  * @param     none
	  * @return void    none
	  * @throws
	  */
	
	
	public void makeShadow() {
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
        
	}
	
	public void playerLayout() {
		{}
		
	}
	
	public void levelLayout() {
	}
	{
	}
        
	
}

