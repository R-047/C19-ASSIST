package application;

import backend.linkedList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PatientDetailsPopup {
PatientDetailsPopup(int pid){
	Stage enterStage  = new Stage();
	
	Button closeButton = new Button();
    closeButton.setStyle("-fx-background-radius: 5em; -fx-min-width: 40px; -fx-min-height: 40px; -fx-max-width: 40px; -fx-max-height: 40px; -fx-background-color: #ff0000; -fx-background-insets: 10px; -fx-padding: 10px;");
    closeButton.setLayoutX(615);
	closeButton.setLayoutY(70);
	closeButton.setOnAction(e -> {
		enterStage.close();
	});
	
	
	Rectangle rec = new Rectangle(340, 64, 321, 460);
	rec.setStyle("-fx-stroke:#66C1BE; -fx-fill: #0B132B; -fx-stroke-width: 3px");
	rec.setArcHeight(50);
	rec.setArcWidth(50);
	//Color co = Color.web("0x0B132B",1.0);
	//rec.setFill(co);
	
	
	String outpid = Integer.toString(pid), outname = null, outgender = null, outage = null, outdob = null, outcity = null, outzip = null, outphonenumber = null, outresultcheck = null, outrecdate = null, outrectime = null;
	Image patientimage = null;
	linkedList.node pointer = linkedList.patientListHead;
	while(pointer != null) {
		
		if(pid == pointer.PID) {
			outname = pointer.name;
			outgender = pointer.gender;
			outage = Integer.toString(pointer.age);
			outdob = pointer.DOB;
			outcity = pointer.city;
			outzip = Integer.toString(pointer.zip);
			outphonenumber = pointer.ph_no;
			if(pointer.resultDateTime != null){
				outresultcheck = "updated";
			}
			else{
				outresultcheck = "pending";
			}
			outrecdate =  pointer.date.toString() ;
			outrectime = Integer.toString(pointer.time.getHour())+" : "+ Integer.toString(pointer.time.getMinute());
			 

		}
		
		if(pid == pointer.PID && pointer.result) {
			 patientimage = new Image("/resources/icons/face-mask-man.png");
		}else {
			patientimage = new Image("/resources/icons/hospital-patient.png");
		}
		pointer = pointer.link;
	}
	ImageView patientImageView = new ImageView(patientimage);
	patientImageView.setLayoutX(470);
	patientImageView.setLayoutY(31);
	patientImageView.setFitHeight(60);
	patientImageView.setFitWidth(60);
	patientImageView.setPreserveRatio(true);
	 
	
	Circle cir = new Circle(500, 64, 50);
	Color cp = Color.web("0x379683",1.0);
	cir.setFill(cp);
	
	Rectangle photorec = new Rectangle(351, 164, 130, 130);
	photorec.setStyle("-fx-stroke:#66C1BE; -fx-fill: #66C1BE; -fx-stroke-width: 5px;");
	photorec.setArcHeight(30);
	photorec.setArcWidth(30);
	

	Image mainpatientimage = new Image("/resources/icons/hospital-patient.png");
	ImageView mainpatientImageView = new ImageView(mainpatientimage);
	mainpatientImageView.setLayoutX(353);
	mainpatientImageView.setLayoutY(164);
	mainpatientImageView.setFitHeight(125);
	mainpatientImageView.setFitWidth(125);
	mainpatientImageView.setPreserveRatio(true);


	Label pidlabel = new Label("PID: "+outpid);
	pidlabel.setStyle("-fx-text-fill: #edf5e1;");
	pidlabel.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Raleway-Medium.ttf"), 20));
	pidlabel.setLayoutX(450);
	pidlabel.setLayoutY(122);
	Label patientname = new Label("name: "+outname);
	patientname.setStyle("-fx-text-fill: #edf5e1;");
	patientname.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Corbert-Regular.ttf"), 18));
	patientname.setLayoutX(495);
	patientname.setLayoutY(170);
	Label gender = new Label("gender: "+outgender);
	gender.setStyle("-fx-text-fill: #edf5e1;");
	gender.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Corbert-Regular.ttf"), 18));
	gender.setLayoutX(495);
	gender.setLayoutY(205);
	Label age = new Label("age: "+outage);
	age.setStyle("-fx-text-fill: #edf5e1;");
	age.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Corbert-Regular.ttf"), 18));
	age.setLayoutX(495);
	age.setLayoutY(240);
	Label dob = new Label("D.O.B: "+outdob);
	dob.setStyle("-fx-text-fill: #edf5e1;");
	dob.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Corbert-Regular.ttf"), 15));
	dob.setLayoutX(495);
	dob.setLayoutY(275);
	Label city = new Label("city: "+outcity);
	city.setStyle("-fx-text-fill: #edf5e1;");
	city.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Corbert-Regular.ttf"), 18));
	city.setLayoutX(371);
	city.setLayoutY(305);
	Label zip = new Label("zip code: "+outzip);
	zip.setStyle("-fx-text-fill: #edf5e1;");
	zip.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Corbert-Regular.ttf"), 18));
	zip.setLayoutX(371);
	zip.setLayoutY(340);
	Label phonenumber = new Label("phone number: "+outphonenumber);
	phonenumber.setStyle("-fx-text-fill: #edf5e1;");
	phonenumber.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Corbert-Regular.ttf"), 18));
	phonenumber.setLayoutX(371);
	phonenumber.setLayoutY(375);
	Label datetime = new Label("entry time: "+outrecdate+", "+outrectime);
	datetime.setStyle("-fx-text-fill: #edf5e1;");
	datetime.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Corbert-Regular.ttf"), 18));
	datetime.setLayoutX(371);
	datetime.setLayoutY(410);
	Label rechecklabel = new Label("result status: "+outresultcheck);
	rechecklabel.setStyle("-fx-text-fill: #edf5e1;");
	rechecklabel.setFont(Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Corbert-Regular.ttf"), 18));
	rechecklabel.setLayoutX(371);
	rechecklabel.setLayoutY(445);
	
	
	Group root = new Group();
	root.getChildren().addAll(rec, photorec, cir, patientImageView, closeButton, pidlabel, patientname, gender, age, dob, city, zip, phonenumber, datetime, rechecklabel, mainpatientImageView);
	
	Scene scene = new Scene(root, 1000, 600);
	scene.setFill(Color.TRANSPARENT);
	scene.getStylesheets().add("/application/styles.css");
	
	
	enterStage.initStyle(StageStyle.TRANSPARENT);
	enterStage.setScene(scene);
	enterStage.show();
	
}


}
