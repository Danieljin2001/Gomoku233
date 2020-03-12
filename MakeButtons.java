package Start;
//I modified this class, but I did not use it
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
//this class determines how the buttons look like and the outputs
public class MakeButtons {
	static Button Playerbutton;
	static Button MenuButtons;
	DropShadow shadow = new DropShadow();
	//this method determines how the menu button looks
	public void playerButtons(String name, int x, int y, int width, int height ) {
		this.Playerbutton = new Button(name);
		
		Playerbutton.setLayoutX(x);
		Playerbutton.setLayoutY(y);
		Playerbutton.setPrefWidth(width);
		Playerbutton.setPrefHeight(height);
		Playerbutton.setStyle(" -fx-background-radius: 20;" //curved edges for the background
        		+ "-fx-border-radius: 20;" //curved edges for the border
        		+ "-fx-font-size: 20;"
        		+ " -fx-border-color: #000000;"
        		+ " -fx-border-width: 2;"
        		+ " -fx-background-color: #ffffff;"
        		+ " -fx-text-fill: #000000"
        		+ "-fx-background-insets: 0, 0, 1, 2;");
	}
	
	public void menuButtons(String name, int x, int y, int width, int height ) {
		this.MenuButtons = new Button(name);
		
		MenuButtons.setLayoutX(x);
		MenuButtons.setLayoutY(y);
		MenuButtons.setPrefWidth(width);
		MenuButtons.setPrefHeight(height);
		MenuButtons.setStyle(" -fx-background-radius: 20;" //curved edges for the background
        		+ "-fx-border-radius: 20;" //curved edges for the border
        		+ "-fx-font-size: 20;"
        		+ " -fx-border-color: #000000;"
        		+ " -fx-border-width: 2;"
        		+ " -fx-background-color: #ffffff;"
        		+ " -fx-text-fill: #000000"
        		+ "-fx-background-insets: 0, 0, 1, 2;");
	}
	
	
	public void makeShadow() {
        MenuButtons.addEventHandler(MouseEvent.MOUSE_ENTERED,
        		new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent e) {
        		MenuButtons.setEffect(shadow);
        		
        	}
        });
        MenuButtons.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                  @Override
                  public void handle(MouseEvent e) {
                	  MenuButtons.setEffect(null);
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

