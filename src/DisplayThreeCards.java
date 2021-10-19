import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DisplayThreeCards extends Application {

    @Override
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        boolean[] usedCards = new boolean[52];
        // choose 3 random distinct cards from the deck
        int count = 0;
        while (count < 3) {
            int card = (int) (Math.random() * 52);
            if (!usedCards[card]) {
                usedCards[card] = true;
                // card png files start from 1, so increment card by one
                // for the correct file name.
                pane.add(new ImageView(new Image("/image/card/"+(++card)+".png")), count, 0);
                count++;
            }
        }
        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("3 Random Cards");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}