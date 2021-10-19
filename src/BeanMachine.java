//Use BeanMachinePane
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BeanMachine extends Application {

    @Override
    public void start(Stage primaryStage) {

        BeanMachinePane pane = new BeanMachinePane();

        System.out.println(pane.getWidth());
        Scene scene = new Scene(pane, pane.getW(), pane.getH());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bean Machine");
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);

    }
}