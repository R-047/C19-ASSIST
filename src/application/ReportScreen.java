package application;

import java.time.LocalDateTime;
import com.sun.javafx.charts.Legend;
import backend.linkedList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ReportScreen {

    static XYChart.Series positiveCasesSeries = new XYChart.Series<>();
    static XYChart.Series deathCasesSeries = new XYChart.Series<>();
    static XYChart.Series recoveredCasesSeries = new XYChart.Series<>();

    ReportScreen() {
        Stage reportStage = new Stage();

        Button closeButton = new Button();
        closeButton.setStyle(
                "-fx-background-radius: 5em; -fx-min-width: 40px; -fx-min-height: 40px; -fx-max-width: 40px; -fx-max-height: 40px; -fx-background-color: #ff0000; -fx-background-insets: 10px; -fx-padding: 10px;");
        closeButton.setLayoutX(1028);
        closeButton.setLayoutY(5);
        closeButton.setOnAction(e -> {
            reportStage.close();
            MainScreen.mainstage.show();
        });

        TableView<data> reportTable = new TableView<>();
        reportTable.setLayoutX(0);
        reportTable.setLayoutY(500);
        reportTable.setPrefSize(1090, 350);
        reportTable.setEditable(false);
        Text tablename = new Text(362, 475, "DISTRICT WISE REPORT");
		tablename.setFill(Color.WHITE);
		Font raleway = Font.loadFont(getClass().getResourceAsStream("/resources/fonts/Raleway-Medium.ttf"), 36);
        tablename.setFont(raleway);
        tablename.setTextAlignment(TextAlignment.CENTER);

        // reportTable.setColumnResizePolicy( TableView.UNCONSTRAINED_RESIZE_POLICY);

        TableColumn<data, String> col1 = new TableColumn<>("City");
        col1.setCellValueFactory(new PropertyValueFactory<data, String>("city"));
        col1.setReorderable(false);
        col1.setPrefWidth(218);
        col1.setResizable(false);

        TableColumn<data, Integer> col2 = new TableColumn<>("Total cases");
        col2.setCellValueFactory(new PropertyValueFactory<data, Integer>("cases"));
        col2.setReorderable(false);
        col2.setPrefWidth(218);
        col2.setResizable(false);

        TableColumn<data, Integer> col3 = new TableColumn<>("Active cases");
        col3.setCellValueFactory(new PropertyValueFactory<data, Integer>("activecases"));
        col3.setReorderable(false);
        col3.setPrefWidth(218);
        col3.setResizable(false);

        TableColumn<data, Integer> col4 = new TableColumn<>("Deaths");
        col4.setCellValueFactory(new PropertyValueFactory<data, Integer>("deaths"));
        col4.setReorderable(false);
        col4.setPrefWidth(218);
        col4.setResizable(false);

        TableColumn<data, Double> col5 = new TableColumn<>("Recovery rate");
        col5.setCellValueFactory(new PropertyValueFactory<data, Double>("recoveryrate"));
        col5.setReorderable(false);
        col5.setPrefWidth(218);
        col5.setResizable(false);

        reportTable.setItems(loadData());
        reportTable.getColumns().addAll(col1, col2, col3, col4, col5);




        positiveCasesSeries.setName("Positive Cases");
        deathCasesSeries.setName("deaths");
        recoveredCasesSeries.setName("Recovered Cases");
        loadDatatoXYchartsPositiveCases();
        loadDatatoXYchartsDeaths();
        loadDatatoXYchartsRecovered();

        NumberAxis xAxis3 = new NumberAxis(0, 24, 1);
        NumberAxis yAxis3 = new NumberAxis(0, 50, 10);
        xAxis3.setLabel("Time");
        yAxis3.setLabel("Count");

        

        ScatterChart<Number, Number> areaChartSmoothed = new ScatterChart<>(xAxis3, yAxis3);
        areaChartSmoothed.setPrefSize(1075, 400);
        areaChartSmoothed.setLayoutX(0);
        areaChartSmoothed.setLayoutY(20);
        areaChartSmoothed.setLegendVisible(true);
        for(Node n : areaChartSmoothed.getChildrenUnmodifiable()) {
            if(n instanceof Legend){
               for(Legend.LegendItem legendItem : ((Legend)n).getItems()){
                 legendItem.getSymbol().setStyle("-fx-background-color: white;");
               }
            }
         }


        areaChartSmoothed.getData().addAll(positiveCasesSeries,deathCasesSeries,recoveredCasesSeries);
        

        Group root = new Group();
        root.getChildren().addAll(reportTable, areaChartSmoothed, closeButton, tablename);

        Scene scene = new Scene(root, 1075, 715);
        Color c = Color.web("0x29363F", 1.0);
        scene.setFill(c);
        scene.getStylesheets().add("/application/styles.css");

        reportStage.initStyle(StageStyle.UNDECORATED);
        reportStage.setScene(scene);
        reportStage.show();

    }

    ObservableList<data> loadData() {
        ObservableList<data> items = FXCollections.observableArrayList();
        linkedList.node pointer = linkedList.reportListHead;
        while (pointer != null) {
            items.add(
                    new data(pointer.city, pointer.numCase, pointer.activeCases, pointer.numDeaths, pointer.recovRate));
            System.out.println(pointer.city + " " + pointer.numCase + " " + pointer.activeCases + " "
                    + pointer.numDeaths + " " + pointer.recovRate);
            pointer = pointer.link;
        }
        return items;
    }

    void loadDatatoXYchartsPositiveCases() {

        positiveCasesSeries.getData().clear();
        linkedList.node pointer1 = linkedList.patientListHead;
        linkedList.node pointer2 = linkedList.patientListHead;
        int casesOnTime = 0;
        LocalDateTime rdateTime = null;
        while (pointer1 != null) {
            rdateTime = pointer1.resultDateTime;
            while (pointer2 != null) {
                if ( pointer2.resultDateTime != null && (pointer2.resultDateTime.equals(rdateTime) && pointer2.result)) {
                    casesOnTime++;
                }
                pointer2 = pointer2.link;
            }
            pointer2 = linkedList.patientListHead;
            if (rdateTime != null) {
                int min_value = rdateTime.getMinute();
                int hour_value = rdateTime.getHour();
                float x = ((float) min_value / 60) + (float) hour_value;
                int y = casesOnTime;
                positiveCasesSeries.getData().add(new XYChart.Data(x, y));
            }
            casesOnTime = 0;
            pointer1 = pointer1.link;
        }
    }

    void loadDatatoXYchartsDeaths() {

        deathCasesSeries.getData().clear();
        linkedList.node pointer1 = linkedList.patientListHead;
        linkedList.node pointer2 = linkedList.patientListHead;
        int deathsOnTime = 0;
        LocalDateTime edateTime = null;
        while (pointer1 != null) {
            edateTime = pointer1.expiryDateTime;
            while (pointer2 != null) {
                if (pointer2.expiryDateTime != null && (pointer2.expiryDateTime.equals(edateTime) && pointer2.status.equals("Expired"))) {

                    deathsOnTime++;
                }
                pointer2 = pointer2.link;
            }
            pointer2 = linkedList.patientListHead;
            if (edateTime != null) {
                int min_value = edateTime.getMinute();
                int hour_value = edateTime.getHour();
                float x = ((float) min_value / 60) + (float) hour_value;
                int y = deathsOnTime;
                System.out.println("x: "+x+ " y: "+y);
                deathCasesSeries.getData().add(new XYChart.Data(x, y));
            }
            deathsOnTime = 0;
            pointer1 = pointer1.link;
        }
    }

    void loadDatatoXYchartsRecovered(){
        recoveredCasesSeries.getData().clear();
        linkedList.node pointer1 = linkedList.patientListHead;
        linkedList.node pointer2 = linkedList.patientListHead;
        int recoveredOnTime = 0;
        LocalDateTime redateTime = null;
        while (pointer1 != null) {
            redateTime = pointer1.recoveryDateTime;
            while (pointer2 != null) {
                if (pointer2.recoveryDateTime != null && (pointer2.recoveryDateTime.equals(redateTime) && pointer2.status.equals("Recovered"))) {

                    recoveredOnTime++;
                }
                pointer2 = pointer2.link;
            }
            pointer2 = linkedList.patientListHead;
            if (redateTime != null) {
                int min_value = redateTime.getMinute();
                int hour_value = redateTime.getHour();
                float x = ((float) min_value / 60) + (float) hour_value;
                int y = recoveredOnTime;
                System.out.println("x: "+x+ "y: "+y);
                recoveredCasesSeries.getData().add(new XYChart.Data(x, y));
            }
            recoveredOnTime = 0;
            pointer1 = pointer1.link;
        }
    }

}



