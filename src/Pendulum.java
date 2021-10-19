import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.util.Duration;

public class Pendulum extends Application {
    @Override
    public void start(Stage primaryStage) {
        PendulumPane pane = new PendulumPane();

        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setTitle("Pendulum");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                pane.pause();
            } else if (e.getButton() == MouseButton.SECONDARY) {
                pane.play();
            }
        });

        pane.setOnKeyPressed(e -> {
            System.out.println(e.getCode());

            if (e.getCode() == KeyCode.UP)
                pane.increaseSpeed();

            if (e.getCode() == KeyCode.DOWN)
                pane.decreaseSpeed();
        });

        pane.requestFocus();
    }

    class PendulumPane extends Pane {
        double pendulumRadius = 150.0;
        double angle = 120;
        double x1 = 150;
        double y1 = 10;
        double dAngle = 0.1;

        Circle smCircle = new Circle(x1, y1, 3);

        double x2 = x1 + pendulumRadius * Math.cos(Math.toRadians(angle));
        double y2 = y1 + pendulumRadius * Math.sin(Math.toRadians(angle));
        Circle lrgCircle = new Circle(x2, y2, 10);
        Line line = new Line(x1, y1, x2, y2);

        private Timeline animation;

        PendulumPane() {
            getChildren().addAll(line, smCircle, lrgCircle);

            animation = new Timeline(new KeyFrame(Duration.millis(100), e->next()));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();
        }

        public void play() {
            animation.play();
        }

        public void pause() {
            animation.pause();
        }

        public void increaseSpeed() {
            animation.setRate (animation.getRate() + 10);
        }

        public void decreaseSpeed() {
            animation.setRate(animation.getRate () > 0 ? animation.getRate() - 10 : animation.getRate());
        }

        void next() {

            if(angle <= 45 || angle >= 135 )
                dAngle *= -1;

            angle -= dAngle;

            //Setting the second point for the end of the line and lrgCircle
            x2 = x1 + pendulumRadius * Math.cos(Math.toRadians(angle));
            y2 = y1+ pendulumRadius * Math.sin(Math.toRadians(angle));


            lrgCircle.setCenterX(x2);
            lrgCircle.setCenterY(y2);

            line.setEndX(x2);
            line.setEndY(y2);
        }
    }
}