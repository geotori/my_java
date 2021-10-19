import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import java.util.Random;

public class TegneSirkelOgFirkant extends Application {
    private Circle circle = new Circle();
    private Rectangle rectangle = new Rectangle();
    private Pane paneCenter = new Pane();
    private double angle = 0;
    private Rotate rotate = new Rotate(0);
    private Label label = new Label();
    private Node figur = rectangle;

    @Override
    public void start(Stage primaryStage) {

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(label);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        Button btFirkant = new Button("Firkant");
        Button btSirkel = new Button("Sirkel");
        hBox.getChildren().addAll(btFirkant, btSirkel);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER_LEFT);
        Button btRed = new Button("Rød");
        Button btBlue = new Button("Blå");
        vBox.getChildren().addAll(btRed, btBlue);

        VBox vBox2 = new VBox();
        vBox2.setAlignment(Pos.CENTER_RIGHT);
        Button btRoter = new Button("Roter");
        vBox2.getChildren().add(btRoter);

        paneCenter.setStyle("-fx-border-color: black");

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(paneCenter);
        borderPane.setTop(stackPane);
        borderPane.setBottom(hBox);
        borderPane.setLeft(vBox);
        borderPane.setRight(vBox2);

        btFirkant.setOnAction(e -> createRectangle());
        btSirkel.setOnAction(e -> createCircle());
        btBlue.setOnAction(e -> figur.setStyle("-fx-fill: blue"));
        btRed.setOnAction(e -> figur.setStyle("-fx-fill: red"));
        btRoter.setOnAction(e -> {
            angle += 45;
            figur.setRotate(angle);
        });

        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setTitle("Tegn sirkel og firkant");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createCircle() {
        circle = new Circle(getX(30), getY(30), 30);
        circle.setStyle("-fx-stroke: black;-fx-fill: white");
        paneCenter.getChildren().clear();
        paneCenter.getChildren().add(rectangle);
        paneCenter.getChildren().add(circle);
        circle.setOnMouseClicked(e -> figur = circle);
        figur = circle;
        putText();
    }

    private void createRectangle() {
        rectangle = new Rectangle(getX(30), getY(30), 40, 30);
        rectangle.setStyle("-fx-stroke: black;-fx-fill: white");
        paneCenter.getChildren().clear();
        paneCenter.getChildren().add(rectangle);
        paneCenter.getChildren().add(circle);
        rectangle.setOnMouseClicked(e -> figur = rectangle);
        figur = rectangle;
        putText();
    }

    private void putText() {
        label.setText("Rektangel i " + ( int ) rectangle.getX() + ", " + ( int ) rectangle.getY() +
            ", sirkel i " + ( int ) circle.getCenterX() + ", " + ( int ) circle.getCenterY());
}

    private int getX(int size) {
        Random random = new Random();
        int pnBredde = (int) paneCenter.getWidth();
        int x = random.nextInt(pnBredde);

        if (x + size > pnBredde)
            x -= size;
        if (x - size < 0)
            x += size;

        return x;
    }

    private int getY(int size) {
        Random random = new Random();
        int pnHoyde = (int) paneCenter.getHeight();
        int y = random.nextInt(pnHoyde);

        if (y + size > pnHoyde)
            y -= size;
        if (y - size < 0)
            y += size;

        return y;
    }
}
