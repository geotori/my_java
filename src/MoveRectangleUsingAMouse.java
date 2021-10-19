import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MoveRectangleUsingAMouse extends Application {

    @Override
    public void start(Stage primaryStage) {

        double width = 500;
        double height = 500;

        Rectangle rec = new Rectangle(width / 2.5, height / 2.5, 100, 75);
        rec.setFill(Color.TRANSPARENT);
        rec.setStroke(Color.BLACK);

        Pane pane = new Pane(rec);
        rec.setOnMouseDragged(e-> {
            rec.setX(e.getX() - rec.getWidth() / 2);
            rec.setY(e.getY() - rec.getHeight() / 2);
        });
        primaryStage.setScene(new Scene(pane, width, height));
        primaryStage.setTitle("Move a rectangle using mouse");
        primaryStage.show();
    }
}