package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("fx/Calculator.fxml"));
			AnchorPane pane = (AnchorPane) loader.load();
			
			Scene scene = new Scene(pane);
			
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Calculator fx");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
