import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DisplayMousePosition extends Application{


    @Override
    public void start(Stage primaryStage) {
        double width = 400;
        double height = 400;

        Text txtPosition = new Text();
        Pane pane = new Pane(txtPosition);

        pane.setOnMousePressed(e -> {
            updateMousePosition(e,txtPosition);
        });
        pane.setOnMouseDragged(e -> {
            updateMousePosition(e,txtPosition);
        });
        pane.setOnMouseReleased(e -> txtPosition.setVisible(false));

        primaryStage.setScene(new Scene(pane, width, height));
        primaryStage.setTitle("Click to see position..");
        primaryStage.show();
    }

    public void updateMousePosition(MouseEvent e, Text txtPosition) {
        txtPosition.setX(e.getX() + 2);
        txtPosition.setY(e.getY() - 2);
        txtPosition.setText("(" + e.getX() + ", " + e.getY() + ")");
        txtPosition.setVisible(true);
    }
}