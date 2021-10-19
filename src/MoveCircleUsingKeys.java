import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class MoveCircleUsingKeys extends Application {

    double width = 400;
    double height = 400;
    double cX = width / 2;
    double cY = height / 2;
    Circle c = new Circle(cX, cY, Math.min(width, height) / 10);

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane(c);

        pane.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP: moveUp(); break;
                case DOWN: moveDown(); break;
                case LEFT: moveLeft(); break;
                case RIGHT: moveRight(); break;
            }
        });

        primaryStage.setScene(new Scene(pane, width, height));
        primaryStage.setTitle("Click to see position..");
        primaryStage.show();
        pane.requestFocus();
    }

    private void moveUp() {
        c.setCenterY(cY -= 10);
    }

    private void moveDown() {
        c.setCenterY(cY += 10);

    }
    private void moveLeft() {
        c.setCenterX(cX -= 10);
    }
    private void moveRight() {
        c.setCenterX(cX += 10);
    }
}