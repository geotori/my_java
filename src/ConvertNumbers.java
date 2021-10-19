import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ConvertNumbers extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        DecHexBinaryPane pane = new DecHexBinaryPane();

        primaryStage.setTitle("Decimal - Hex - Binary Calculator");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }

    private class DecHexBinaryPane extends GridPane {

        Label lblDecimal = new Label("Decimal:");
        Label lblHex = new Label("Hex:");
        Label lblBinary = new Label("Binary:");

        TextField tfDecimal = new TextField();
        TextField tfHex = new TextField();
        TextField tfBinary = new TextField();

        Integer integer = 0;

        private DecHexBinaryPane() {

            setHgap(10);
            setVgap(10);
            setPadding(new Insets(10, 10, 10, 10));

            TextField[] textFields = new TextField[3];
            // row 0
            add(lblDecimal, 0, 0);
            add(tfDecimal, 1, 0);
            textFields[0] = tfDecimal;
            // row 1
            add(lblHex, 0, 1);
            add(tfHex, 1, 1);
            textFields[1] = tfHex;

            // row 2
            add(lblBinary, 0, 2);
            add(tfBinary, 1, 2);
            textFields[2] = tfBinary;

            for (int i = 0; i < textFields.length; i++) {
                textFields[i].setText("0");
                textFields[i].setAlignment(Pos.CENTER_RIGHT);

            }

            tfDecimal.setOnAction(e -> {
                integer = new Integer(tfDecimal.getText());
                update();
            });
            tfHex.setOnAction(e -> {
                integer = Integer.parseInt(tfHex.getText(), 16);
                update();
            });

            tfBinary.setOnAction(e-> {
                integer = Integer.parseInt(tfBinary.getText(), 2);
                update();
            });


        }

        private void update() {
            tfDecimal.setText(integer.toString());
            tfHex.setText(Integer.toHexString(integer));
            tfBinary.setText(Integer.toBinaryString(integer));
        }
    }
}