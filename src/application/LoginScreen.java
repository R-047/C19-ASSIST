package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import backend.CSVreader;
import backend.CreateFolFil;
import backend.report;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class LoginScreen extends Application {
	static Group root = new Group();

	@Override
	public void start(Stage primaryStage) throws Exception {



		CreateFolFil.createFolder();
		CreateFolFil.createFile();
		CSVreader csv = new CSVreader();
		csv.readPatientsfile("/home/rohith/C19-ASSIST/PatientDetails.csv");

		report re = new report();
		re.Summary();

		LocalDateTime datetime = java.time.LocalDateTime.now();
		LocalDate date = LocalDate.parse("2021-12-10");
		System.out.println(date);
		int day = date.getDayOfMonth();
		int month = date.getMonthValue();
		int year = date.getYear();
		System.out.println("day " + day + "\nmonth " + month + "\nyear " + year);
		LocalTime time = LocalTime.parse("21:05");
		System.out.println(time);

		Text appName = new Text(85, 300, "C-19 Assist");
		appName.setFill(Color.WHITE);
		Font raleway = Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Raleway-Light.ttf"), 90);
		appName.setFont(raleway);

		Label name = new Label("user name");
		name.setStyle("-fx-text-fill: #A5B4B1;");
		name.setLayoutX(690);
		name.setLayoutY(285);
		Label password = new Label("password");
		password.setStyle("-fx-text-fill: #A5B4B1;");
		password.setLayoutX(690);
		password.setLayoutY(365);

		TextField nameTextbox = new TextField();
		nameTextbox.setStyle(
				" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
		nameTextbox.setPrefColumnCount(25);
		nameTextbox.setPrefHeight(50);
		nameTextbox.setLayoutX(675);
		nameTextbox.setLayoutY(270);
		nameTextbox.focusedProperty()
				.addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
					if (newValue) {
						System.out.println("Focus Gained");
						nameTextbox.setStyle(
								"-fx-border-color: rgba(122, 219, 162,2.0); -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
					}

				else {
						System.out.println("Focus Lost");
						nameTextbox.setStyle(
								" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
					}
				});
		nameTextbox.setOnKeyTyped(e -> {
			if (!nameTextbox.getText().isEmpty()) {
				name.setVisible(false);
			} else {
				name.setVisible(true);
			}
		});

		PasswordField passwordTextbox = new PasswordField();
		passwordTextbox.setStyle(
				" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
		passwordTextbox.setPrefColumnCount(25);
		passwordTextbox.setPrefHeight(50);
		passwordTextbox.setLayoutX(675);
		passwordTextbox.setLayoutY(350);
		passwordTextbox.focusedProperty()
				.addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
					if (newValue) {
						System.out.println("Focus Gained");
						passwordTextbox.setStyle(
								"-fx-border-color: rgba(122, 219, 162,2.0); -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
					} else {
						System.out.println("Focus Lost");
						passwordTextbox.setStyle(
								" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
					}
				});
		passwordTextbox.setOnKeyTyped(e -> {
			if (!passwordTextbox.getText().isEmpty()) {
				password.setVisible(false);
			} else {
				password.setVisible(true);
			}
		});

		Line line = new Line();
		line.setStyle("-fx-stroke: #43515D; -fx-stroke-width: 2;");
		line.setStartX(-100);
		line.setStartY(-60);
		line.setEndX(-100);
		line.setEndY(321);
		line.setLayoutX(697);
		line.setLayoutY(227);
		line.requestFocus();

		Button loginButton = new Button("Login");
		loginButton.setStyle(
				"-fx-background-color: #7ADBA2; -fx-background-radius: 15px; -fx-text-fill: #ffffff; -fx-font-size: 16pt;");
		loginButton.setPrefHeight(50);
		loginButton.setPrefWidth(350);
		loginButton.setLayoutX(672);
		loginButton.setLayoutY(430);
		loginButton.setOnAction(e -> {
			String username = nameTextbox.getText().trim();
			String passwordtext = passwordTextbox.getText().trim();
			boolean check = CSVreader.readIDfile("/home/rohith/C19-ASSIST/userIDs.txt", username, passwordtext);
			if (check) {
				primaryStage.close();
				new MainScreen();
			} else {
				BoxBlur blur = new BoxBlur();
				root.setEffect(blur);
				new alertMessage();
			}

		});

		Button closeButton = new Button();
		closeButton.setStyle(
				"-fx-background-radius: 5em; -fx-min-width: 40px; -fx-min-height: 40px; -fx-max-width: 40px; -fx-max-height: 40px; -fx-background-color: #ff0000; -fx-background-insets: 10px; -fx-padding: 10px;");
		closeButton.setLayoutX(1025);
		closeButton.setLayoutY(5);
		closeButton.setOnAction(e -> System.exit(0));

		Button minButton = new Button();
		minButton.setStyle(
				"-fx-background-radius: 5em; -fx-min-width: 40px; -fx-min-height: 40px; -fx-max-width: 40px; -fx-max-height: 40px; -fx-background-color: #EE9C15; -fx-background-insets: 10px; -fx-padding: 10px;");
		minButton.setLayoutX(990);
		minButton.setLayoutY(5);
		minButton.setOnAction(e -> {
			Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
			stage.setIconified(true);
		});


		Circle icover = new Circle(454, 300, 7);
		Color cp1 = Color.web("0x29363F",1.0);
		icover.setFill(cp1);
		TranslateTransition translatec = new TranslateTransition();
		FadeTransition fadec = new FadeTransition();
		translatec.setByY(28);
		translatec.setDuration(Duration.millis(1500));
		translatec.setAutoReverse(false);
		translatec.setNode(icover);
		translatec.play();
		fadec.setDuration(Duration.millis(1500));
		fadec.setFromValue(0);
		fadec.setToValue(10);
		fadec.setAutoReverse(false);
		fadec.setNode(icover);
		fadec.play();




		TranslateTransition translate = new TranslateTransition();
		translate.setByY(90);
		translate.setDuration(Duration.millis(1500));
		translate.setAutoReverse(false);
		translate.setNode(appName);
		translate.play();

		FadeTransition fade = new FadeTransition();
		fade.setDuration(Duration.millis(1500));
		fade.setFromValue(2);
		fade.setToValue(10);
		fade.setAutoReverse(false);
		fade.setNode(appName);
		fade.play();

		Circle idot = new Circle(454, 328, 7);
		Color cp = Color.web("0x7ADBA2",1.0);
		idot.setFill(cp);


		

		Glow glow = new Glow();   
		glow.setLevel(10);  
		idot.setEffect(glow);
		FadeTransition fade2 = new FadeTransition();
		fade2.setDuration(Duration.millis(3000));
		fade2.setFromValue(0);
		fade2.setToValue(10);
		fade2.setAutoReverse(true);
		fade2.setCycleCount(Animation.INDEFINITE);
		fade2.setNode(idot);
		fade2.play();


 

	
			
			
			
			root.getChildren().addAll(appName, line, name, password, nameTextbox, passwordTextbox, loginButton, closeButton, minButton, icover, idot);
			
		

			
			
			Scene scene = new Scene(root, 1072, 625);
			Color c = Color.web("0x29363F",1.0);
			scene.setFill(c);
			
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	
	
	
}

class alertMessage{
	alertMessage(){
		Stage promptPopup = new Stage();
		
		
		Label comment = new Label("wrong user name or password entered.\nplease try again");
		comment.setStyle("-fx-text-fill: #36454D;");
		comment.setFont(new Font("Arial", 18));
		comment.setLayoutX(25);
		comment.setLayoutY(10);
		comment.setVisible(true);
		
		
		Button goButton = new Button("OK");
		goButton.setStyle("-fx-background-color: transparent; -fx-border-radius: 15px; -fx-text-fill:  #C95B51; -fx-font-size: 10pt; -fx-border-color: #C95B51; -fx-border-width: 2");
		goButton.setPrefSize(75, 30);
		goButton.setMinSize(75, 30);
	    goButton.setLayoutX(355);
		goButton.setLayoutY(50);
		goButton.setOnAction(e -> {
			LoginScreen.root.setEffect(null);
			promptPopup.close();
		});
		
		
		
		Pane root = new Pane();
		root.setStyle("-fx-background-color: white; -fx-background-radius: 30;-fx-border-radius: 30;-fx-border-width:3; -fx-border-color: #C95B51");
		root.getChildren().addAll(goButton, comment);

		/*PauseTransition delay = new PauseTransition(Duration.seconds(5));
		delay.setOnFinished( event -> promptPopup.close() );
		delay.play();*/
		
		
		Scene scene = new Scene(root, 450, 100);
		scene.setFill(Color.TRANSPARENT);
		
	    
		promptPopup.initStyle(StageStyle.TRANSPARENT);
		promptPopup.setScene(scene);
		promptPopup.show();
	}
}	


