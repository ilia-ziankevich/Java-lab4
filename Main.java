package application;
	
import application.MainThread;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,900,450);
		TextField real_number = new TextField();
		TextField complex_number = new TextField();
		TextField degree_number = new TextField();
		Label plus = new Label(" + ");
		Label calculating_degree = new Label("Степень корня");
		Label complex_i = new Label(" i");
		Label number_info = new Label("Введите действительную и мнимую часть");
		TextArea info_label = new TextArea();
		Button calculation = new Button("Вычислить");
		HBox hbox1 = new HBox();
		HBox hbox2 = new HBox();
		VBox vbox1 = new VBox();
		MainThread main1 = new MainThread();
		
		hbox2.getChildren().addAll(real_number, plus, complex_number, complex_i);
		vbox1.getChildren().addAll(number_info, hbox2, calculating_degree, degree_number, calculation);
		hbox1.getChildren().addAll(vbox1, info_label);
		root.getChildren().addAll(hbox1);
		
		vbox1.setMinSize(430d, 430d);
		info_label.setMinSize(450d, 450d);
		String style = "-fx-font-size: 20; -fx-font-family:'Times new roman';-fx-font-style:italic";
		plus.setStyle(style);
		calculating_degree.setStyle(style);
		complex_i.setStyle(style);
		number_info.setStyle(style);
		vbox1.setTranslateX(20d);
		vbox1.setTranslateY(20d);
		hbox2.setTranslateY(20d);
		calculating_degree.setTranslateY(90d);
		degree_number.setTranslateY(110d);
		calculation.setTranslateY(180d);
		degree_number.setMaxWidth(75d);
		real_number.setMaxWidth(75d);
		complex_number.setMaxWidth(75d);
		calculation.setStyle(style);
		
		EventHandler<ActionEvent> calculation_event = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent calculation_event) 
	    	{ 
				main1.FindRadical(info_label,Integer.parseInt(real_number.getText()),Integer.parseInt(complex_number.getText()),Integer.parseInt(degree_number.getText()));
	    	} 
	    };
		
	    calculation.setOnAction(calculation_event);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}