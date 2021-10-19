//Uses StopWatch

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CountUpStopWatch extends Application {

    StopWatch stopWatch = new StopWatch();
    Label mLabel = new Label("00:00:00");
    @Override
    public void start(Stage primaryStage) {


        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), e-> {
            mLabel.setText(stopWatch.toString());
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);

        // bottom pane
        Button btStartPause = new Button("Start");
        btStartPause.setOnAction(event -> {
            btStartPause.setText((btStartPause.getText().equals("Pause") ? "Start" : "Pause"));
            if (!stopWatch.isOn()) {
                stopWatch.start();
                timeline.play();
            } else
            if (stopWatch.isPaused()) {
                timeline.play();
                stopWatch.resume();
            } else {
                stopWatch.pause();
                timeline.pause();
            }
        });

        Button btClear = new Button("Clear");
        btClear.setOnAction(event -> {
            stopWatch.stop();
            timeline.stop();
            btStartPause.setText("Start");
            mLabel.setText("00:00:00");
        });
        HBox bottomPane = new HBox(btStartPause, btClear);
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setSpacing(10);
        bottomPane.setPadding(new Insets(10));
        mLabel.setFont(Font.font(50));

        StackPane centerPane = new StackPane(mLabel);
        centerPane.setPadding(new Insets(10));

        BorderPane borderPane = new BorderPane(centerPane);
        borderPane.setBottom(bottomPane);
        primaryStage.setScene(new Scene(borderPane));
        primaryStage.setTitle("Stopwatch");
        primaryStage.show();

    }
}