// Uses TBaneMachinePane + Triangle2D
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BeanMachineAnimation extends Application {

    @Override
    public void start(Stage primaryStage) {

        TBeanMachinePane pane = new TBeanMachinePane(8, 600, 600);

        Text text = new Text(20, 20, "");

        pane.setOnMouseMoved(e -> {
            text.setText("x = " + e.getX() + "\n" + "y = " + e.getY());
        });

        Scene scene = new Scene(new StackPane(pane));

        primaryStage.setScene(scene);
        pane.getChildren().add(text);
        primaryStage.setTitle("Bean Machine");
        primaryStage.show();

        for (int i = 0; i < 10; i++) {
            pane.dropBall();
        }

    }
}

