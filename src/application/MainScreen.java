package application;

import java.text.DecimalFormat;

import backend.CSVwriter;
import backend.linkedList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class MainScreen {

	static Group root = new Group();
	static double growthRate= 0, deathRate = 0, recoveryRate = 0, psuedodeathRate = 0, psuedorecoveryRate = 0;
	static ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
	static PieChart pieChart = new PieChart();
	static Text cityName = new Text();
	static Stage mainstage = null;
	linkedList.node pointer = linkedList.reportListHead;
		static Text totalposcase = new Text();
		static Text totaldeaths = new Text();
		static Text meanrecovrate = new Text();


	MainScreen() {

		mainstage = new Stage();

		Button closeButton = new Button();
		closeButton.setStyle(
				"-fx-background-radius: 5em; -fx-min-width: 40px; -fx-min-height: 40px; -fx-max-width: 40px; -fx-max-height: 40px; -fx-background-color: #ff0000; -fx-background-insets: 10px; -fx-padding: 10px;");
		closeButton.setLayoutX(1025);
		closeButton.setLayoutY(5);
		closeButton.setOnAction(e -> {
			new CSVwriter("/home/rohith/Desktop/C19-ASSIST/PatientDetails.csv").writeToPatientsFile();
			System.exit(0);
		});

		Button minButton = new Button();
		minButton.setStyle(
				"-fx-background-radius: 5em; -fx-min-width: 40px; -fx-min-height: 40px; -fx-max-width: 40px; -fx-max-height: 40px; -fx-background-color: #EE9C15; -fx-background-insets: 10px; -fx-padding: 10px;");
		minButton.setLayoutX(990);
		minButton.setLayoutY(5);
		minButton.setOnAction(e -> {
			Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
			stage.setIconified(true);
		});

		Rectangle rec = new Rectangle(0, 0, 448, 259);
		Color co = Color.web("0x0C396B", 1.0);
		rec.setFill(co);

		Text appName = new Text(134, 138, "C-19 Assist");
		appName.setFill(Color.WHITE);
		Font raleway = Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Raleway-Light.ttf"), 36);
		appName.setFont(raleway);

		Image patientimage = new Image("/resources/icons/hospital-patient.png");
		ImageView patientImageView = new ImageView(patientimage);
		patientImageView.setFitHeight(40);
		patientImageView.setFitWidth(40);
		patientImageView.setPreserveRatio(true);
		Button button1 = new Button("Patients");
		button1.setAlignment(Pos.CENTER_LEFT);
		button1.setGraphic(patientImageView);
		button1.setPrefHeight(93);
		button1.setPrefWidth(448);
		button1.setLayoutX(0);
		button1.setLayoutY(260);
		button1.setOnAction(e -> {
			// mainstage.close();
			root.setEffect(new BoxBlur());
			new popupStage();
			// new EnterScreen();
		});

		Image covidpatientimage = new Image("/resources/icons/face-mask-man.png");
		ImageView covidpatientImageView = new ImageView(covidpatientimage);
		covidpatientImageView.setFitHeight(40);
		covidpatientImageView.setFitWidth(40);
		covidpatientImageView.setPreserveRatio(true);
		Button button2 = new Button("Covid-19 Patients");
		button2.setAlignment(Pos.CENTER_LEFT);
		button2.setGraphic(covidpatientImageView);
		button2.setPrefHeight(93);
		button2.setPrefWidth(448);
		button2.setLayoutX(0);
		button2.setLayoutY(350);
		button2.getStyleClass().add("button");
		button2.setOnAction(e -> {
			mainstage.hide();
			new covidPatientsScreen();
		});

		Image updateimage = new Image("/resources/icons/Untitled-1.png");
		ImageView updateImageView = new ImageView(updateimage);
		updateImageView.setFitHeight(40);
		updateImageView.setFitWidth(40);
		updateImageView.setPreserveRatio(true);
		Button button3 = new Button("Update Patient Data");
		button3.setAlignment(Pos.CENTER_LEFT);
		button3.setGraphic(updateImageView);
		button3.setPrefHeight(93);
		button3.setPrefWidth(448);
		button3.setLayoutX(0);
		button3.setLayoutY(440);
		button3.setOnAction(e -> {
			MainScreen.root.setEffect(new BoxBlur());
			new PromptBox();
		});

		Image reportimage = new Image(
				"/resources/icons/kisspng-computer-icons-report-computer-software-report-vector-5ae07d5712c189.0463092515246615910768.png");
		ImageView reportImageView = new ImageView(reportimage);
		reportImageView.setFitHeight(40);
		reportImageView.setFitWidth(40);
		reportImageView.setPreserveRatio(true);
		Button button4 = new Button("Report");
		button4.setAlignment(Pos.CENTER_LEFT);
		button4.setGraphic(reportImageView);
		button4.setPrefHeight(93);
		button4.setPrefWidth(448);
		button4.setLayoutX(0);
		button4.setLayoutY(530);
		button4.setOnAction(e -> {
			mainstage.hide();
			new ReportScreen();
		});

		/*
		 * Image csvimage = new Image("/resources/icons/csv.png"); ImageView
		 * csvImageView = new ImageView(csvimage); csvImageView.setFitHeight(40);
		 * csvImageView.setFitWidth(40); csvImageView.setPreserveRatio(true); Button
		 * button5 = new Button("Export To CSV"); button5.setAlignment(Pos.CENTER_LEFT);
		 * button5.setGraphic(csvImageView); button5.setPrefHeight(93);
		 * button5.setPrefWidth(448); button5.setLayoutX(0); button5.setLayoutY(620);
		 */

		Circle cir = new Circle();
		cir.setRadius(125);
		Color co1 = Color.web("0x29363F", 1.0);
		cir.setFill(co1);
		cir.setFill(co1);
		cir.setLayoutX(765);
		cir.setLayoutY(333);
		cir.setVisible(false);

		cityName.setLayoutX(685);
		cityName.setLayoutY(75);
		cityName.setTextAlignment(TextAlignment.CENTER);
		cityName.setFill(Color.WHITE);
		Font ralewayforcity = Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Raleway-Light.ttf"), 36);
		cityName.setFont(ralewayforcity);

		pieChart.setPrefSize(625, 625);
		pieChart.setLayoutX(450);
		pieChart.setLayoutY(20);
		pieChart.setLegendVisible(false);
		pieChart.setClockwise(true);
		pieChart.setLabelLineLength(10);
		pieChart.setLabelsVisible(true);
		pieChart.setStartAngle(180);

		Color col = Color.web("0x7ADBA2", 1.0);
		Circle cir1 = new Circle();
		cir1.setRadius(7);
		cir1.setLayoutX(750);
		cir1.setLayoutY(333);
		cir1.setFill(col);
		cir1.setFill(col);

		Circle cir2 = new Circle();
		cir2.setRadius(7);
		cir2.setLayoutX(780);
		cir2.setLayoutY(333);
		cir2.setFill(col);
		cir2.setFill(col);

		Circle cir3 = new Circle();
		cir3.setRadius(7);
		cir3.setLayoutX(810);
		cir3.setLayoutY(333);
		cir3.setFill(col);
		cir3.setFill(col);

		TranslateTransition translate1 = new TranslateTransition();
		translate1.setByY(-20);
		translate1.setDuration(Duration.millis(500));
		translate1.setAutoReverse(true);
		translate1.setCycleCount(2);
		translate1.setNode(cir1);
		translate1.play();

		TranslateTransition translate2 = new TranslateTransition();
		translate2.setDelay(Duration.millis(500));
		translate2.setByY(-20);
		translate2.setDuration(Duration.millis(500));
		translate2.setAutoReverse(true);
		translate2.setCycleCount(2);
		translate2.setNode(cir2);
		translate2.play();

		TranslateTransition translate3 = new TranslateTransition();
		translate3.setDelay(Duration.millis(1000));
		translate3.setByY(-20);
		translate3.setDuration(Duration.millis(500));
		translate3.setAutoReverse(true);
		translate3.setCycleCount(2);
		translate3.setNode(cir3);
		translate3.play();

		Timeline t0 = new Timeline();
		t0.getKeyFrames().add(new KeyFrame(Duration.millis(2000), (ActionEvent actionEvent) -> {
			translate1.setByY(-20);
			translate1.setDuration(Duration.millis(500));
			translate1.setAutoReverse(true);
			translate1.setCycleCount(2);
			translate1.setNode(cir1);
			translate1.play();

			translate2.setDelay(Duration.millis(500));
			translate2.setByY(-20);
			translate2.setDuration(Duration.millis(500));
			translate2.setAutoReverse(true);
			translate2.setCycleCount(2);
			translate2.setNode(cir2);
			translate2.play();

			translate3.setDelay(Duration.millis(1000));
			translate3.setByY(-20);
			translate3.setDuration(Duration.millis(500));
			translate3.setAutoReverse(true);
			translate3.setCycleCount(2);
			translate3.setNode(cir3);
			translate3.play();

		}));
		t0.setCycleCount(Animation.INDEFINITE);
		t0.setAutoReverse(true);
		t0.play();

		int totalPatients = linkedList.getTotalPatients();



		Font ralewayfordetails = Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Raleway-Light.ttf"), 18);

		

		totalposcase.setLayoutX(460);
		totalposcase.setLayoutY(560);
		totalposcase.setTextAlignment(TextAlignment.CENTER);
		totalposcase.setFill(Color.WHITE);
		totalposcase.setFont(ralewayfordetails);

		totaldeaths.setLayoutX(460);
		totaldeaths.setLayoutY(580);
		totaldeaths.setTextAlignment(TextAlignment.CENTER);
		totaldeaths.setFill(Color.WHITE);
		totaldeaths.setFont(ralewayfordetails);

		meanrecovrate.setLayoutX(460);
		meanrecovrate.setLayoutY(600);
		meanrecovrate.setTextAlignment(TextAlignment.CENTER);
		meanrecovrate.setFill(Color.WHITE);
		meanrecovrate.setFont(ralewayfordetails);

		

		Timeline t1 = new Timeline();
		t1.getKeyFrames().add(new KeyFrame(Duration.millis(5000), (ActionEvent actionEvent) -> {

			if (pointer != null) {
				pieChartData.clear();

				totalposcase.setText("Total Positive Cases: "+Integer.toString(getTotalCases()));
				totaldeaths.setText("Total Deaths: "+Integer.toString(totalDeaths()));
				meanrecovrate.setText("Mean Recovery Rate: "+getMeanRecovRate()+"%");


				growthRate = (((float) pointer.numCase) / totalPatients) * 100;
				deathRate = (((float) pointer.numDeaths) / pointer.numCase) * 100;
				psuedodeathRate = deathRate;
				recoveryRate = pointer.recovRate;
				psuedorecoveryRate = recoveryRate;

				cityName.setText(pointer.city);

				System.out.println(pointer.city + " growth rate: " + growthRate + " death rate " + deathRate
						+ " recovery rate: " + recoveryRate);

				if (recoveryRate == 0) {
					psuedorecoveryRate = 3;
				}
				if (deathRate == 0) {
					psuedodeathRate = 3;
				}

				cir.setVisible(true);
				pieChartData.add(new PieChart.Data("growth rate\n", growthRate));
				pieChartData.add(new PieChart.Data("death rate\n", psuedodeathRate));
				pieChartData.add(new PieChart.Data("recovery rate\n", psuedorecoveryRate));
				pieChart.setData(pieChartData);

				pointer = pointer.link;
				if (pointer == null) {
					pointer = linkedList.reportListHead;
				}
			}

		}));
		t1.setCycleCount(Animation.INDEFINITE);
		t1.setAutoReverse(true);
		t1.play();

		
		root.getChildren().addAll(rec, button1, button2, button3, button4, appName, pieChart, closeButton, minButton, cir1, cir2, cir3, cir, cityName, totalposcase, totaldeaths, meanrecovrate);

		Scene scene = new Scene(root, 1072, 625);
		Color c = Color.web("0x29363F", 1.0);
		scene.setFill(c);
		scene.getStylesheets().add("/application/styles.css");

		mainstage.initStyle(StageStyle.UNDECORATED);
		mainstage.setScene(scene);
		mainstage.show();
	}

	static int getTotalCases() {
		int totalCases = 0;
		linkedList.node pointer = linkedList.patientListHead;
		while (pointer != null){
			if(pointer.status != null && pointer.status.equals("Active")){
				totalCases++;
			}
			pointer = pointer.link;
		}
		return totalCases;
	}

	static int totalDeaths(){
		int totalDeaths = 0;
		linkedList.node pointer = linkedList.patientListHead;
		while (pointer != null){
			if(pointer.status != null && pointer.status.equals("Expired")){
				totalDeaths++;
			}
			pointer = pointer.link;
		}
		return totalDeaths;
	}

	static String getMeanRecovRate(){
		double mean = 0;
		double sum = 0;
		int count = 0;
		DecimalFormat df = new DecimalFormat("#.##");   
		linkedList.node pointer = linkedList.reportListHead;
		while (pointer != null){
		
			sum+= pointer.recovRate;
			count++;
			pointer = pointer.link;

		}
		mean = sum/count;
		String formatted = df.format(mean);
		return formatted;
	}

	
}

	
