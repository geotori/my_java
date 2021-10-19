// Use ClockPane
import javafx.application.Application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RandomTime extends Application {

    @Override
    public void start(Stage primaryStage) {

        double height = 400;
        double width = 400;
        int hour = (int) (Math.random() * 12);
        int min = (int) (Math.random() * 31);
        ClockPane clock1 = new ClockPane(hour, min, 0, width, height);
        clock1.setSecondHandVisible(true);
        HBox hBox = new HBox(clock1);


        Scene scene = new Scene(hBox, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Random time");
        primaryStage.show();
    }
}