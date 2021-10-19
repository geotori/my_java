import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DisplayFiftyFourCards extends Application {

    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();

        int card = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 9; j++) {
                pane.add(new ImageView(new Image("/image/card/"+(card++)+".png")), j, i);
            }
        }
        Scene scene = new Scene(pane, 650, 580);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Card Deck");
        primaryStage.show();
    }
    public static void main(String[] args) {

        Application.launch(args);
    }
}