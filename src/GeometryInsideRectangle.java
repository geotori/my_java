import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GeometryInsideRectangle extends Application {

    @Override
    public void start(Stage primaryStage) {

        double width = 400;
        double height = 300;
        Rectangle rec = new Rectangle(100, 60, 100, 40);
        rec.setFill(Color.TRANSPARENT);
        rec.setStroke(Color.BLACK);

        Pane pane = new Pane(rec);
        Scene scene = new Scene(pane, width, height);
        Text text = new Text();
        pane.getChildren().add(text);
        pane.setOnMouseMoved(e-> {
            double x = e.getX();
            double y = e.getY();
            text.setX(x);
            text.setY(y);
            if (rec.contains(x, y)) {
                text.setText("Mouse Point is inside the rectangle");
            } else {
                text.setText("Mouse Point is outside the rectangle");
            }
            if (text.getLayoutBounds().getWidth() + x > width) {
                text.setX(width - text.getLayoutBounds().getWidth());
            }
            if (y - text.getLayoutBounds().getHeight() < 0) {
                text.setY(text.getLayoutBounds().getHeight());
            }

        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Circle position");
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}