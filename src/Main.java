import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.*;
//import javafx.scene.text.Font;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			Font font = new Font(25);
			
			
			//Create Scene
			GridPane grid = new GridPane();
			GridPane  gf = new GridPane();

			grid.setStyle("-fx-background-color:blue");
			gf.setStyle("-fx-background-color:white");
			
			//Edit Scene
			grid.setPadding(new Insets(5,5,5,5));
			grid.setVgap(8);
			grid.setHgap(1);
			ColumnConstraints column1 = new ColumnConstraints();
			ColumnConstraints column2 = new ColumnConstraints();
			column1.setPercentWidth(50);
			column2.setPercentWidth(50);
			RowConstraints row1 = new RowConstraints();
			RowConstraints row2 = new RowConstraints();
			RowConstraints row3 = new RowConstraints();
			row1.setPercentHeight(20);
			row2.setPercentHeight(70);
			row3.setPercentHeight(10);
			grid.getColumnConstraints().addAll(column1,column2);
			grid.getRowConstraints().addAll(row1,row2,row3);
			
			//Create show text
			Text showText = new Text(Hangman.text);
			showText.setFont(font);
			//Create label
			Label showGif = new Label();
			showGif.setGraphic(new ImageView(new Image(Hangman.image,245,255,false,false)));
			showGif.setPrefSize(245, 255);
			Label repeat1 = new Label();
			repeat1.setGraphic(new ImageView(new Image(Hangman.teest,200,200,false,false)));
			repeat1.setPrefSize(200, 200);
			repeat1.setVisible(false);
			//Create input 	textField
			TextField text = new TextField();
			text.setPrefSize(10,10);
			text.setAlignment(Pos.CENTER);
			text.setFont(font);

			
			
			//Create button
			Button button = new Button("Guess!");
			button.setPrefWidth(100);
			button.setOnAction(e -> {
				if (text.getLength() > 0){
					Hangman.replace(text.getText().charAt(0));
					if(Hangman.end)
						repeat1.setVisible(true);
					else
						repeat1.setVisible(false);
				showText.setText(Hangman.text);
				showGif.setGraphic(new ImageView(new Image(Hangman.image, 245, 255, false, false)));
				text.clear();
			}
			});
			
			
			//Add to scene
			grid.add(gf, 0, 0, 2,1);
			grid.add(showText, 0, 0, 2,1);
			grid.setHalignment(showText, HPos.CENTER);
			grid.add(repeat1, 1, 1, 1,1);
			grid.setHalignment(showText, HPos.CENTER);
			grid.add(showGif, 0, 1, 1, 1);
			grid.add(text, 0, 2, 1, 1);
			grid.setHalignment(text, HPos.CENTER);
			grid.add(button, 1, 2,1,1);
			grid.setHalignment(button, HPos.CENTER);
			
			
			
			//Create Scene and add scene to stage
			Scene scene = new Scene(grid,500,385);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Hangman.initialize();
		launch(args);
		
		
	}
}
