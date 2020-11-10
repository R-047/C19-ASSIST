package application;

import application.PatientsListScreen.customCell;
import backend.linkedList;
import backend.report;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ModifyScreen {
	
	
ModifyScreen(int pid){
Stage enterStage  = new Stage();
	
	Button closeButton = new Button();
    closeButton.setStyle("-fx-background-radius: 5em; -fx-min-width: 40px; -fx-min-height: 40px; -fx-max-width: 40px; -fx-max-height: 40px; -fx-background-color: #ff0000; -fx-background-insets: 10px; -fx-padding: 10px;");
    closeButton.setLayoutX(340);
	closeButton.setLayoutY(121);
	closeButton.setOnAction(e -> {
		enterStage.close();
	});
	
	
	Rectangle rec = new Rectangle(330, 111, 392, 522);
	Color co = Color.web("0x0B132B",1.0);
	rec.setFill(co);
	
	Image patientimage = new Image("/resources/icons/editicon.png");
	ImageView patientImageView = new ImageView(patientimage);
	patientImageView.setLayoutX(505);
	patientImageView.setLayoutY(82);
	patientImageView.setFitHeight(50);
	patientImageView.setFitWidth(50);
	patientImageView.setPreserveRatio(true);
	 
	Circle cir = new Circle(527, 111, 47);
	Color cp = Color.web("0x379683",1.0);
	cir.setFill(cp);
	
	Label patientname = new Label("patient name");
	patientname.setStyle("-fx-text-fill: #A5B4B1;");
	patientname.setLayoutX(368);
	patientname.setLayoutY(207);
	Label gender = new Label("gender");
	gender.setStyle("-fx-text-fill: #A5B4B1;");
	gender.setLayoutX(368);
	gender.setLayoutY(257);
	
	
	RadioButton rmale = new RadioButton("Male");
	rmale.setLayoutX(448);
	rmale.setLayoutY(257);

	RadioButton rfemale = new RadioButton("Female");
	rfemale.setLayoutX(523);
	rfemale.setLayoutY(257);
	
	RadioButton rothers = new RadioButton("Others");
	rothers.setLayoutX(615);
	rothers.setLayoutY(257);
	
	final ToggleGroup group = new ToggleGroup();
	rmale.setToggleGroup(group);
	rfemale.setToggleGroup(group);
	rothers.setToggleGroup(group);
	//rmale.setSelected(true);
	
	
	Label age = new Label("age");
	age.setStyle("-fx-text-fill: #A5B4B1;");
	age.setLayoutX(368);
	age.setLayoutY(307);
	Label dob = new Label("D.O.B");
	dob.setStyle("-fx-text-fill: #A5B4B1;");
	dob.setLayoutX(368);
	dob.setLayoutY(367);
	Label city = new Label("city");
	city.setStyle("-fx-text-fill: #A5B4B1;");
	city.setLayoutX(368);
	city.setLayoutY(427);
	Label zip = new Label("zip code");
	zip.setStyle("-fx-text-fill: #A5B4B1;");
	zip.setLayoutX(368);
	zip.setLayoutY(487);
	Label phonenumber = new Label("phone number");
	phonenumber.setStyle("-fx-text-fill: #A5B4B1;");
	phonenumber.setLayoutX(368);
	phonenumber.setLayoutY(547);
	
	
	patientname.setVisible(false);
	//gender.setVisible(false);
	age.setVisible(false);
	dob.setVisible(false);
	city.setVisible(false);
	zip.setVisible(false);
	phonenumber.setVisible(false);
	
	
	TextField patientnametextbox = new TextField();
	patientnametextbox.setStyle(" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
	patientnametextbox.setPrefColumnCount(25);
	patientnametextbox.setPrefHeight(40);
	patientnametextbox.setLayoutX(358);
	patientnametextbox.setLayoutY(197);
	patientnametextbox.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
		if (newValue) {
	        System.out.println("Focus Gained");
	       patientnametextbox.setStyle("-fx-border-color: rgba(122, 219, 162,2.0); -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
		}
		
	    else {
	        System.out.println("Focus Lost");
	        patientnametextbox.setStyle(" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");  
	    }
	});
	patientnametextbox.setOnKeyTyped(e -> {
		 if(!patientnametextbox.getText().isEmpty()) {
			 patientname.setVisible(false); 
		 }else {
			 patientname.setVisible(true);
		 }
	 	});
	
	
	TextField agetextbox = new TextField();
	agetextbox.setStyle(" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
	agetextbox.setPrefColumnCount(25);
	agetextbox.setPrefHeight(40);
	agetextbox.setLayoutX(358);
	agetextbox.setLayoutY(297);
	agetextbox.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
		if (newValue) {
	        System.out.println("Focus Gained");
	       agetextbox.setStyle("-fx-border-color: rgba(122, 219, 162,2.0); -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
		}
		
	    else {
	        System.out.println("Focus Lost");
	        agetextbox.setStyle(" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");  
	    }
	});
	agetextbox.setOnKeyTyped(e -> {
		 if(!agetextbox.getText().isEmpty()) {
			 age.setVisible(false); 
		 }else {
			 age.setVisible(true);
		 }
	 	});
	
	
	TextField dobtextbox = new TextField();
	dobtextbox.setStyle(" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
	dobtextbox.setPrefColumnCount(25);
	dobtextbox.setPrefHeight(40);
	dobtextbox.setLayoutX(358);
	dobtextbox.setLayoutY(357);
	dobtextbox.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
		if (newValue) {
	        System.out.println("Focus Gained");
	       dobtextbox.setStyle("-fx-border-color: rgba(122, 219, 162,2.0); -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
		}
		
	    else {
	        System.out.println("Focus Lost");
	        dobtextbox.setStyle(" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");  
	    }
	});
	dobtextbox.setOnKeyTyped(e -> {
		 if(!dobtextbox.getText().isEmpty()) {
			 dob.setVisible(false); 
		 }else {
			 dob.setVisible(true);
		 }
	 	});
	
	
	TextField citytextbox = new TextField();
	citytextbox.setStyle(" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
	citytextbox.setPrefColumnCount(25);
	citytextbox.setPrefHeight(40);
	citytextbox.setLayoutX(358);
	citytextbox.setLayoutY(417);
	citytextbox.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
		if (newValue) {
	        System.out.println("Focus Gained");
	       citytextbox.setStyle("-fx-border-color: rgba(122, 219, 162,2.0); -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
		}
		
	    else {
	        System.out.println("Focus Lost");
	        citytextbox.setStyle(" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");  
	    }
	});
	citytextbox.setOnKeyTyped(e -> {
		 if(!citytextbox.getText().isEmpty()) {
			 city.setVisible(false); 
		 }else {
			 city.setVisible(true);
		 }
	 	});
	
	TextField ziptextbox = new TextField();
	ziptextbox.setStyle(" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
	ziptextbox.setPrefColumnCount(25);
	ziptextbox.setPrefHeight(40);
	ziptextbox.setLayoutX(358);
	ziptextbox.setLayoutY(477);
	ziptextbox.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
		if (newValue) {
	        System.out.println("Focus Gained");
	       ziptextbox.setStyle("-fx-border-color: rgba(122, 219, 162,2.0); -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
		}
		
	    else {
	        System.out.println("Focus Lost");
	        ziptextbox.setStyle(" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");  
	    }
	});
	ziptextbox.setOnKeyTyped(e -> {
		 if(!ziptextbox.getText().isEmpty()) {
			 zip.setVisible(false); 
		 }else {
			 zip.setVisible(true);
		 }
	 	});
	
	
	TextField phonenumbertextbox = new TextField();
	phonenumbertextbox.setStyle(" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
	phonenumbertextbox.setPrefColumnCount(25);
	phonenumbertextbox.setPrefHeight(40);
	phonenumbertextbox.setLayoutX(358);
	phonenumbertextbox.setLayoutY(537);
	phonenumbertextbox.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
		if (newValue) {
	        System.out.println("Focus Gained");
	       phonenumbertextbox.setStyle("-fx-border-color: rgba(122, 219, 162,2.0); -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
		}
		
	    else {
	        System.out.println("Focus Lost");
	        phonenumbertextbox.setStyle(" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");  
	    }
	});
	phonenumbertextbox.setOnKeyTyped(e -> {
		 if(!phonenumbertextbox.getText().isEmpty()) {
			 phonenumber.setVisible(false); 
		 }else {
			 phonenumber.setVisible(true);
		 }
	 	});
	
	
	
	linkedList.node pointer = linkedList.patientListHead;
	
	while(pointer != null) {
		if(pid == pointer.PID) {
			patientnametextbox.setText(pointer.name);
			if(pointer.gender.equals("Male")) {
				rmale.setSelected(true);
			}
			if(pointer.gender.equals("Female")) {
				rfemale.setSelected(true);
			}
			if(pointer.gender.equals("Others")) {
				rothers.setSelected(true);
			}
			agetextbox.setText(Integer.toString(pointer.age));
			dobtextbox.setText(pointer.DOB);
			citytextbox.setText(pointer.city);
			ziptextbox.setText(Integer.toString(pointer.zip));
			phonenumbertextbox.setText(pointer.ph_no);
		}
		pointer = pointer.link;
	}
	
	
	Text save = new Text(489, 610, "update");
	save.setFill(Color.web("0x7ADBA2"));
	Font raleway = Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Raleway-Light.ttf"), 18);
	save.setFont(raleway);
	
	Button saveButton = new Button("update");
	saveButton.setStyle("-fx-background-color: transparent; -fx-border-radius: 15px; -fx-text-fill:  #7ADBA2; -fx-font-size: 10pt; -fx-border-color: #7ADBA2; -fx-border-width: 2");
	saveButton.setPrefSize(75, 30);
	saveButton.setMinSize(75, 30);
	saveButton.setLayoutX(480);
	saveButton.setLayoutY(590);
    saveButton.setOnAction(e -> {
        
        linkedList.node pointer2 = linkedList.patientListHead;
        while(pointer2 != null) {
        	if(pid == pointer2.PID) {
        		pointer2.name = patientnametextbox.getText();
            	RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            	pointer2.gender = selectedRadioButton.getText();
            	pointer2.DOB =  dobtextbox.getText();
            	pointer2.age = Integer.parseInt(agetextbox.getText());
				pointer2.city = citytextbox.getText();
				report.autoFormulatedLocationDB(citytextbox.getText());
            	pointer2.zip = Integer.parseInt(ziptextbox.getText());
            	pointer2.ph_no = phonenumbertextbox.getText();
        	}
        	pointer2 = pointer2.link;
        	
        }
        
        PatientsListScreen.PidNamelist.clear();
    	linkedList.node pointer3 = linkedList.patientListHead;
    	while(pointer3 != null) {
			PatientsListScreen.PidNamelist.add(Integer.toString(pointer3.PID) +"                                 "+ pointer3.name);
			pointer3 = pointer3.link;
		}
    	PatientsListScreen.listview.setItems(PatientsListScreen.PidNamelist);
    	PatientsListScreen.listview.setCellFactory(ei  -> new customCell());
        
    	enterStage.close();
    	
    	
    });
	
	Group root = new Group();
	root.getChildren().addAll(rec, cir, patientImageView, closeButton, patientname, gender, rmale, rfemale, rothers, age, dob, city, zip, phonenumber, patientnametextbox, agetextbox, dobtextbox, citytextbox, ziptextbox, phonenumbertextbox, saveButton, save);
	
	Scene scene = new Scene(root, 1072, 715);
	scene.setFill(Color.TRANSPARENT);
	scene.getStylesheets().add("/application/styles.css");
	
	
	enterStage.initStyle(StageStyle.TRANSPARENT);
	enterStage.setScene(scene);
	enterStage.show();
}
	
}

