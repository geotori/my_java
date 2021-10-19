// Use MyPoint and PaneCollection

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TwoCirclesAndTheirDistance extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        double width = 400;
        double height = 400;
        double radius = 15;

        ArrayList<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Circle c = new Circle(
                    Math.random() * width,
                    Math.random() * height, radius);
            shapes.add(c);
        }
        Circle c1 = (Circle)shapes.get(0);
        Circle c2 = (Circle)shapes.get(1);

        Line line = new Line(c1.getCenterX(), c1.getCenterY(), c2.getCenterX(), c2.getCenterY());
        shapes.add(line);

        double distance = PaneCollection.distance(line);
        MyPoint center = PaneCollection.getCenterPoint(line);

        shapes.add(new Text(center.x, center.y, Double.toString(distance)));

        pane.getChildren().addAll(shapes);
        primaryStage.setTitle("Draw two Circles");
        primaryStage.setScene(new Scene(pane, width, height));
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);

    }
}