/**import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class TwoRectangles extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        double width = 400;
        double height = 400;

        ArrayList<Rectangle> rectangles = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 2; i++) {
            System.out.print("Enter center coordinates / height / width of rectangle " + i + ": ");
            Rectangle temp = new Rectangle(
                    input.nextDouble(),
                    input.nextDouble(),
                    input.nextDouble(),
                    input.nextDouble());
            temp.setFill(Color.TRANSPARENT);
            temp.setStroke(Color.BLACK);

            rectangles.add(temp);
        }
        MyRectangle2D rec1 = new MyRectangle2D(rectangles.get(0));
        MyRectangle2D rec2 = new MyRectangle2D(rectangles.get(1));
        String s = "";
        if (rec1.contains(rec2) || rec2.contains(rec1)) {
            s = "One rectangle is contained in another.";
        } else if (rec1.overlaps(rec2) || rec2.overlaps(rec1)) {
            s = "One rectangle overlaps another";
        } else {
            s = "The rectangles do not overlap.";
        }
        Text text = new Text(width * 0.1, height * 0.9, s);
        pane.getChildren().add(text);
        pane.getChildren().addAll(rectangles);
        primaryStage.setTitle("rectangles..");
        primaryStage.setScene(new Scene(pane, width, height));
        primaryStage.show();
    }
}*/