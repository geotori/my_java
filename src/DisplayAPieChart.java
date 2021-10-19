import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class DisplayAPieChart extends Application {

    private static double[] percent = new double[]{0.20, 0.10, 0.30, 0.40};
    private static String[] titles = new String[] {
            "project -- " + String.format("%d%s", (int)(100 * percent[0]), "%"),
            "quizzes -- " + String.format("%d%s", (int)(100 * percent[1]), "%"),
            "midterm -- " + String.format("%d%s", (int)(100 * percent[2]), "%"),
            "final -- "+ String.format("%d%s", (int)(100 * percent[3]), "%")
    };
    private static Color[] colors = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};

    private static double RADIUS = 100;
    private static double CENTER_X = 200;
    private static double CENTER_Y = 200;

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        ArrayList<Shape> shapes = new ArrayList<>();

        Circle c = new Circle(CENTER_X, CENTER_Y, RADIUS, Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        shapes.add(c);
        double angle = 0;
        for (int i = 0; i < titles.length; i++) {

            double length = percent[i] * 100 * 3.6;
            Arc arc = new Arc(CENTER_X, CENTER_Y, RADIUS, RADIUS, angle, length);
            arc.setFill(colors[i]);
            arc.setType(ArcType.ROUND);
            shapes.add(arc);

            double x = CENTER_X + RADIUS * Math.cos(Math.toRadians(angle * -1 - (length / 2)));
            double y = CENTER_Y + RADIUS * Math.sin(Math.toRadians(angle * -1 - (length / 2)));
            if (y > CENTER_Y) {
                y -= RADIUS / 2;
                x -= RADIUS / 2;
            }
            Text text = new Text(x, y, titles[i]);
            shapes.add(text);

            angle += length;
        }

        pane.getChildren().addAll(shapes);
        primaryStage.setScene(new Scene(pane, 400, 400));
        primaryStage.setTitle("Pie Chart");
        primaryStage.show();
    }
}