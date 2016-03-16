package intern;

import intern.Counter;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.util.Duration;

/**
 * Displays a windows containing the counter, with buttons to adjust time.
 * <br>
 * Uses JavaFX to create a GUI window. Allows the counter to be initialized to 
 * any time. The created window can be manipulated like other windows once created.
 * The counter time can be changed using the provided increment/decrement buttons.
 * Time format can be changed using provided button.
 * 
 * @author Calvin Li
 * @version 1.0
 */
public class CounterDisplay extends Application {
	
	/** Displays a window containing the counter time.
	 * <br>
	 * Creates a JavaFX window displaying the counter time
	 * with buttons for incrementing and decrementing each field. 
	 * Also contains buttons for switching between Standard 12-hour 
	 * format and 24-hour Military format.
	 * 
	 * @param	mainStage	
	 */
	public void start (Stage mainStage)	{
		
		/* Create the pane for placing the buttons and place it in a scene */
		GridPane mainGrid = new GridPane();
		mainGrid.setAlignment(Pos.CENTER);
		mainGrid.setVgap(5);
		mainGrid.setHgap(5);
		Scene mainScene = new Scene(mainGrid, 500, 200);
		
		/* Create an instance of Counter to display */
		Counter display = new Counter();
		Text time = new Text();
		time.setTextAlignment(TextAlignment.CENTER);
		time.setFont(new Font(30));
		time.setText(display.displayStandard());
		
		/* Create a transition to update the text when buttons are clicked */
//		FadeTransition output = new FadeTransition(Duration.millis(1), time);
//		output.setCycleCount(Timeline.INDEFINITE);
//		output.setFromValue(1.0);
//		output.setToValue(0);
		AnimationTimer updater = new AnimationTimer(){
			@Override
			public void handle(long h)	{
				time.setText(display.displayStandard());
			}	
		};
		
		/* Buttons for changing the counter time */
		Button incSec = new Button(); 
		Button decSec = new Button();
		Button incMin = new Button();
		Button decMin = new Button();
		Button incHr = new Button();
		Button decHr = new Button();
		Button changeFormat = new Button();
		
		/* Button labels */
		incSec.setText("Increment Seconds");
		decSec.setText("Decrement Seconds");
		incMin.setText("Increment Minutes");
		decMin.setText("Decrement Minutes");
		incHr.setText("Increment Hour");
		decHr.setText("Decrement Hour");
		changeFormat.setText("Change Format");
		
		/* Add the buttons to the window */
		mainGrid.add(incSec,2,1);
		mainGrid.add(decSec,2,2);
		mainGrid.add(incMin,1,1);
		mainGrid.add(decMin,1,2);
		mainGrid.add(incHr,0,1);
		mainGrid.add(decHr,0,2);
		mainGrid.add(changeFormat,1,3);
		mainGrid.add(time,1,0);	
		
		
		/* Methods to handle button clicks. There are seven possible button clicks, 
		 * six for each time field change and one to switch between time formats. */
		incSec.setOnAction(new EventHandler<ActionEvent>()	{
			public void handle(ActionEvent click)	{
				display.incrementSecond();
			}
		});
		decSec.setOnAction(new EventHandler<ActionEvent>()	{
			public void handle(ActionEvent click)	{
				display.decrementSecond();
			}
		});
		incMin.setOnAction(new EventHandler<ActionEvent>()	{
			public void handle(ActionEvent click)	{
				display.incrementMinute();
			}
		});
		decMin.setOnAction(new EventHandler<ActionEvent>()	{
			public void handle(ActionEvent click)	{
				display.decrementMinute();
			}
		});
		incHr.setOnAction(new EventHandler<ActionEvent>()	{
			public void handle(ActionEvent click)	{
				display.incrementHour();
			}
		});
		decHr.setOnAction(new EventHandler<ActionEvent>()	{
			public void handle(ActionEvent click)	{
				display.decrementHour();
			}
		});	
		changeFormat.setOnAction(new EventHandler<ActionEvent>()	{
			public void handle(ActionEvent click)	{
			}
		});
		
		/* Set the title for the window and display it */
		mainStage.setTitle("Counter");
		mainStage.setScene(mainScene);
		updater.start();
		//output.play();
		mainStage.show();	
		
	}
}
