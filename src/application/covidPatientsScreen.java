package application;

import backend.linkedList;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class covidPatientsScreen {
	static class customCell extends ListCell<String>{
		Pane root = new Pane();
		Button copyButton = new Button();
		final Clipboard clipboard = Clipboard.getSystemClipboard();
		final ClipboardContent content = new ClipboardContent();
		Label in_name = new Label();
		public customCell() {
			super();
			
			Tooltip cbuttonTooltip = new Tooltip("copy patient pid");
			copyButton.setTooltip(cbuttonTooltip);
			copyButton.setStyle("-fx-background-radius: 5em; -fx-min-width: 40px; -fx-min-height: 40px; -fx-max-width: 40px; -fx-max-height: 40px; -fx-background-color: #379683; -fx-background-insets: 10px; -fx-padding: 10px;");
			copyButton.setLayoutX(400);
			copyButton.setLayoutY(15);
			copyButton.setOnAction(e -> {
				
				String value = in_name.getText().substring(0, 6).trim() ;
				content.putString(value);
				clipboard.setContent(content);
				new Toastmessage("Successfully copied", 2, 900, 800);
				
			});

			in_name.setTextFill(Color.WHITE);
			in_name.setLayoutX(10);
			in_name.setLayoutY(25);
			
			
			root.getChildren().addAll(in_name, copyButton);
		}
		
		public void updateItem(String name, boolean empty) {
			super.updateItem(name, empty);
			setText(null);
			setGraphic(null);
			
			if(name != null && !empty) {
				in_name.setText(name);
				setGraphic(root);
			}
			
		}
	}

	
	
	
	
	covidPatientsScreen(){
		
		Stage scrollStage = new Stage();

		
		 Button closeButton = new Button();
	     closeButton.setStyle("-fx-background-radius: 5em; -fx-min-width: 40px; -fx-min-height: 40px; -fx-max-width: 40px; -fx-max-height: 40px; -fx-background-color: #ff0000; -fx-background-insets: 10px; -fx-padding: 10px;");
	     closeButton.setLayoutX(1025);
	     closeButton.setLayoutY(5);
	     
		 closeButton.setOnAction(e -> {
			 scrollStage.close();
			 MainScreen.mainstage.show();
			
		 });
		 
		 
		 Label searchboxinstruction = new Label("enter pid or name to search");
			searchboxinstruction.setStyle("-fx-text-fill: #A5B4B1;");
			searchboxinstruction.setLayoutX(381);
			searchboxinstruction.setLayoutY(164);
			searchboxinstruction.setVisible(true);



			Image searchIconiImage = new Image("/resources/icons/toppng.com-free-icons-png-instagram-search-icon-white-394x393.png");
			ImageView searchIconImageView = new ImageView(searchIconiImage);
			searchIconImageView.setLayoutX(675);
			searchIconImageView.setLayoutY(160);
			searchIconImageView.setFitHeight(25);
			searchIconImageView.setFitWidth(25);
			searchIconImageView.setPreserveRatio(true);
			
			
		    
		
		ObservableList<String> PidNamelist = FXCollections.observableArrayList();
		linkedList.node pointer = linkedList.patientListHead;
		ListView<String> listview = new ListView<String>(PidNamelist);
		while(pointer != null) {
			if(pointer.result && pointer.status.equals("Active")) {
				PidNamelist.add(Integer.toString(pointer.PID) +"                                   "+ pointer.name);
				
			}
			pointer = pointer.link;
		}
		listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		listview.setStyle("-fx-background-color: transparent;");
		listview.setLayoutX(301);
		listview.setLayoutY(200);
		listview.setPrefSize(480, 470);
		listview.setCellFactory(e  -> new customCell());
		listview.setOnMouseClicked(e -> {
			int clickCount = e.getClickCount();
			if(clickCount == 1) {
				System.out.println("clicked once");
			}
			else {
		
				String item = listview.getSelectionModel().getSelectedItem().toString();
				int pid = Integer.parseInt(item.substring(0,6).trim());
				new PatientDetailsPopup(pid);
				System.out.println("clicked twice"+"\n clicked item = "+item);
			}			
		});
		
		
	    
		
		
		
		
		
		

		
		TextField searchBox = new TextField();
		searchBox.setStyle(" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;  -fx-focus-color: #B22222;");
		searchBox.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
			if (newValue) {
		        System.out.println("Focus Gained");
		       searchBox.setStyle("-fx-border-color: rgba(122, 219, 162,2.0); -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");
			}
			
		    else {
		        System.out.println("Focus Lost");
		        searchBox.setStyle(" -fx-border-color: #43515D; -fx-border-radius: 10px; -fx-background-color: transparent; -fx-text-fill: #ffffff; -fx-border-width: 2;");  
		    }
		});
		searchBox.requestFocus();
		searchBox.setPrefColumnCount(25);
		searchBox.setPrefHeight(40);
		searchBox.setLayoutX(371);
		searchBox.setLayoutY(154);
		searchBox.setOnKeyTyped(e -> {
			if(searchBox.getText().isBlank()) {
				searchboxinstruction.setVisible(true);
			}else {
				searchboxinstruction.setVisible(false);
			}
			PidNamelist.clear();
			String entry = searchBox.getText().trim();
			int lengthofentry = entry.length();
			 linkedList.node pointer2 = linkedList.patientListHead;
			 while(pointer2 != null){
				 if(pointer2.result && pointer2.status.equals("Active")) {
					 if(lengthofentry <= Integer.toString(pointer2.PID).length()){
		                    if(entry.equals(Integer.toString(pointer2.PID).substring(0, lengthofentry))){
		                        String itemforlist = Integer.toString(pointer2.PID)+"                                "+pointer2.name;
		                        PidNamelist.add(itemforlist);
		                        
		                    }
		                else if(lengthofentry <= pointer2.name.length()){
		                    if(entry.equals(pointer2.name.substring(0, lengthofentry))){
		                        String itemforlist = Integer.toString(pointer2.PID)+"                                "+pointer2.name;
		                        PidNamelist.add(itemforlist);
		                    }
		                    }
		                    
		                }
				 }
	                pointer2 = pointer2.link;
	            }
			 listview.setItems(PidNamelist);
			 listview.setCellFactory(ei  -> new customCell());
		});
		
		
		
		
		
		Group root = new Group();
		root.getChildren().addAll(listview, closeButton, searchBox, searchboxinstruction, searchIconImageView);
		

		
		
		Scene scene = new Scene(root, 1072, 744);
		Color c = Color.web("0x29363F",1.0);
		scene.setFill(c);
		scene.getStylesheets().add("/application/styles.css");
		searchBox.requestFocus();
		

		
		scrollStage.initStyle(StageStyle.UNDECORATED);
		scrollStage.setScene(scene);
		scrollStage.show();

	}
}
