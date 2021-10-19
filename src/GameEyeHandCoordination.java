//Uses StopWatch

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameEyeHandCoordination extends Application {

    static int circleCount = 0;

    @Override
    public void start(Stage primaryStage) {

        double width = 500;
        double height = 500;

        Circle c = new Circle(0, 0, 10);
        updateCircle(c);
        Pane pane = new Pane(c);
        Text count = new Text(50,50,circleCount + "");
        pane.getChildren().add(count);
        StopWatch timer = new StopWatch();
        c.setOnMouseClicked(e-> {

            if (!timer.isOn()) {
                timer.start();
            }
            if (circleCount < 19) {
                circleCount++;
                count.setText(circleCount + "");

                updateCircle(c);
            } else {
                timer.stop();
                pane.getChildren().remove(c);
                pane.getChildren().add(new Text(width / 2, height / 2, "Time spent is " +
                        timer.getElapsedTime() + " milliseconds"));
            }
        });
        primaryStage.setScene(new Scene(pane, width, height));
        primaryStage.setTitle("Game: eye-hand coordination");
        primaryStage.show();
    }

    private void updateCircle(Circle c) {

        double min = c.getRadius() + 5;
        double max = 500 - c.getRadius() - 5;

        c.setCenterX((Math.random() * (max - min) + min));
        max = 500
                - c.getRadius() - 5;
        c.setCenterY((Math.random() * (max - min) + min));

        c.setFill(new Color(Math.random(), Math.random(), Math.random(), 1));
    }


}