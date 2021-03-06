//Uses ClockPane

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SetClockTime extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ClockPane clockPane = new ClockPane();

        // Hour
        TextField tfHour = new TextField(clockPane.getHour() + "");
        tfHour.setPrefColumnCount(2);
        Label lblHour = new Label("Hour:", tfHour);
        lblHour.setContentDisplay(ContentDisplay.RIGHT);
        tfHour.setOnAction(e-> clockPane.setHour(Integer.parseInt(tfHour.getText())));

        // Minutes
        TextField tfMinutes = new TextField(clockPane.getMinute() + "");
        tfMinutes.setPrefColumnCount(2);
        Label lblMinutes = new Label("Minute:", tfMinutes);
        lblMinutes.setContentDisplay(ContentDisplay.RIGHT);
        tfMinutes.setOnAction(e-> clockPane.setMinute(Integer.parseInt(tfMinutes.getText())));

        // Seconds
        TextField tfSeconds = new TextField(clockPane.getSecond() + "");
        tfSeconds.setPrefColumnCount(2);
        Label lblSeconds = new Label("Second:", tfSeconds);
        lblSeconds.setContentDisplay(ContentDisplay.RIGHT);
        tfSeconds.setOnAction(e-> clockPane.setSecond(Integer.parseInt(tfSeconds.getText())));


        BorderPane pane = new BorderPane(clockPane);
        BorderPane.setAlignment(clockPane, Pos.CENTER);

        HBox textFieldPane = new HBox(5);
        textFieldPane.setAlignment(Pos.CENTER);
        textFieldPane.getChildren().addAll(lblHour, lblMinutes, lblSeconds);
        textFieldPane.setPadding(new Insets(5));

        pane.setBottom(textFieldPane);
        primaryStage.setScene(new Scene(pane));
        primaryStage.setTitle("Clock");
        primaryStage.show();
        clockPane.setFocusTraversable(true);
    }
}