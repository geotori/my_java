import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class CountDownStopWatch extends Application {

    final String URL = "/Users/luizsa/GitHub/java/intro-to-java-10th-edition/src/audio/us.mp3";

    @Override
    public void start(Stage primaryStage) throws Exception {

        TextField tfCountDown = new TextField("0");
        tfCountDown.setFont(Font.font(50));
        tfCountDown.setPrefColumnCount(3);
        tfCountDown.setAlignment(Pos.CENTER);
        tfCountDown.setFocusTraversable(false);
        Pane pane = new Pane(tfCountDown);
        StackPane stackPane = new StackPane(pane);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(1000), e-> {
                    tfCountDown.setText((Integer.parseInt(tfCountDown.getText()) - 1) + "");
                }));

        tfCountDown.setOnAction(e-> {
            if (timeline.getStatus() == Animation.Status.RUNNING) {
                timeline.stop();
            }
            timeline.setCycleCount(Integer.parseInt(tfCountDown.getText()));
            tfCountDown.setEditable(false);
            timeline.play();
        });

        File file = new File(URL);
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(file.toURI().toString()));

        timeline.setOnFinished(event -> {
            mediaPlayer.play();
        });
        primaryStage.setScene(new Scene(stackPane));
        primaryStage.setTitle("Countdown");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}