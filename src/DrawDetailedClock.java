import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DrawDetailedClock extends Application {

    @Override
    public void start(Stage primaryStage) {

        double height = 400;
        double width = 400;
        ClockPane clock1 = new ClockPane(4, 20, 45, width, height);
        HBox hBox = new HBox(clock1);


        Scene scene = new Scene(hBox, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Draw a detailed clock");
        primaryStage.show();
    }
}