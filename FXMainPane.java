import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	
	//In the FXMainPane class, declare five buttons, a label, and a textfield.  Declare two HBoxes that will hold the these components and go inside the VBox. 
	
	//  declare five buttons, a label, and a textfield
	
	Button firstButton = new Button();
	Button secondButton = new Button();
	Button thirdButton = new Button();
	Button fourthButton = new Button();
	Button fifthButton = new Button();
	
	Label genericLabel;
	TextField genericT_Field;
	
	//  declare two HBoxes
	
	HBox box1;
	HBox box2;
	
	//student Task #4:
	//  declare an instance of DataManager
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	
	DataManager output;
	
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		
		firstButton.setText("Hello");
		secondButton.setText("Howdy");
		thirdButton.setText("Chinese");
		fourthButton.setText("Clear");
		fifthButton.setText("Exit");
		
		genericLabel  = new Label("Feedback ");
		genericT_Field = new TextField();
		
		box1 = new HBox();
		box2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		
		output = new DataManager();
		firstButton.setOnAction(new ButtonHandler());
		secondButton.setOnAction(new ButtonHandler());
		thirdButton.setOnAction(new ButtonHandler());
		fourthButton.setOnAction(new ButtonHandler());
		fifthButton.setOnAction(new ButtonHandler());
		
		box1.setAlignment(Pos.CENTER);
		box2.setAlignment(Pos.CENTER);
		
		box1.setPadding(new Insets(10));
		box2.setPadding(new Insets(10));
		
		HBox.setMargin(firstButton, new Insets(5));
		HBox.setMargin(secondButton, new Insets(5));
		HBox.setMargin(thirdButton, new Insets(5));
		HBox.setMargin(fourthButton, new Insets(5));
		HBox.setMargin(fifthButton, new Insets(5));
		
		setMargin(genericLabel, new Insets(100));
		setMargin(genericT_Field, new Insets(100));
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		
		box1.getChildren().addAll(firstButton, secondButton, thirdButton, fourthButton, fifthButton);
		box2.getChildren().addAll(genericLabel, genericT_Field);
		this.getChildren().addAll(box1, box2); //I think you can remove this as well?
		
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			
			if(event.getTarget() == firstButton) {
				genericT_Field.setText(output.getHello());
			}
			if(event.getTarget() == secondButton) {
				genericT_Field.setText(output.getHowdy());
			}
			if(event.getTarget() == thirdButton) {
				genericT_Field.setText(output.getChinese());
			}
			if(event.getTarget() == fourthButton) {
				genericT_Field.setText("");
			}
			if(event.getTarget() == fifthButton) {
				Platform.exit();
				System.exit(0);
			}
			
		}
		
	}
}
	
