import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControlAMovingText extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        double width = 400;
        double height = 400;
        Scene scene = new Scene(pane, width, height);
        double radius = Math.min(width, height) * 0.25;
        Circle c = new Circle(width / 2, height / 2, radius, Color.TRANSPARENT);
        c.setRotate(180);
        c.setStroke(Color.BLACK);
        Text text = new Text("Programming is fun");

        PathTransition pathTrans = new PathTransition(Duration.millis(10000), c, text);
        pathTrans.setCycleCount(Timeline.INDEFINITE);
        pathTrans.play();

        FadeTransition fadeTrans = new FadeTransition(Duration.millis(5000), text);
        fadeTrans.setFromValue(1.0);
        fadeTrans.setToValue(0);
        fadeTrans.setAutoReverse(false);
        fadeTrans.setCycleCount(Timeline.INDEFINITE);
        fadeTrans.play();

        pane.setOnMousePressed(e-> {
            pathTrans.pause();
            fadeTrans.pause();
        });
        pane.setOnMouseReleased(e-> {
            pathTrans.play();
            fadeTrans.play();
        });

        pane.getChildren().addAll(text);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Control a moving text");
        primaryStage.show();
    }
}