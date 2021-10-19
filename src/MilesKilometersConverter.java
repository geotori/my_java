import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MilesKilometersConverter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        MilesAndKiloPane pane = new MilesAndKiloPane();

        primaryStage.setTitle("Kilo and Mile Calculator");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    private class MilesAndKiloPane extends GridPane {

        Label lblMiles = new Label("Mile:");
        Label lblKilometers = new Label("Kilometers:");

        TextField tfMiles = new TextField();
        TextField tfKilometers = new TextField();


        private MilesAndKiloPane() {

            setHgap(10);
            setVgap(10);
            setPadding(new Insets(10, 10, 10, 10));

            add(lblMiles, 0, 0);
            add(tfMiles, 1, 0);
            add(lblKilometers, 0, 1);
            add(tfKilometers, 1, 1);

            tfMiles.setText("0");
            tfMiles.setAlignment(Pos.CENTER_RIGHT);
            tfKilometers.setText("0");
            tfKilometers.setAlignment(Pos.CENTER_RIGHT);

            tfKilometers.setOnAction(e->{
                tfMiles.setText(Double.toString(new Double(tfKilometers.getText()) * 0.621371));
            });

            tfMiles.setOnAction(e->{
                tfKilometers.setText(Double.toString(new Double(tfMiles.getText()) / 0.621371));
            });

        }
    }
}