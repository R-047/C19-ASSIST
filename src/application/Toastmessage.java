package application;

import javafx.animation.PauseTransition;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Toastmessage {

    Toastmessage(String message, double time, double X, double Y) {
            Stage promptPopup = new Stage();
            
            
            Label comment = new Label(message);
            comment.setStyle("-fx-text-fill: white;");
            comment.setFont(new Font("Arial", 10));
           // comment.setLayoutX(5);
           // comment.setLayoutY(10);
            comment.setVisible(true);
        
            
            
            StackPane root = new StackPane();
            root.setStyle("-fx-background-color: #423E3B; -fx-background-radius: 30;-fx-border-radius: 30;-fx-border-width:3;");
            root.getChildren().addAll(comment);
    
            PauseTransition delay = new PauseTransition(Duration.seconds(time));
            delay.setOnFinished( event -> promptPopup.close() );
            delay.play();
            
            
            Scene scene = new Scene(root, 120, 25);
            scene.setFill(Color.TRANSPARENT);
            
            promptPopup.setX(X);
            promptPopup.setY(Y);
            promptPopup.initStyle(StageStyle.TRANSPARENT);

            promptPopup.setOpacity(0.5);
            promptPopup.setScene(scene);
            promptPopup.show();
        }
    	
    
}
