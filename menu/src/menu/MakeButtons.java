package menu;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
//this class determines how the buttons look like and the outputs
public class MakeButtons {
	Button button;
	DropShadow shadow = new DropShadow();
	//this method determines how the menu button looks
	public Button playerButtons(String name, int y ) {
		this.button = new Button(name);
		
		button.setLayoutX(25);
		button.setLayoutY(y);
		button.setPrefWidth(200);
		button.setPrefHeight(100);
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

