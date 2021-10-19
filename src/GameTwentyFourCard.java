import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameTwentyFourCard extends Application {

    @Override
    public void start(Stage primaryStage) {

        PointCardGamePane pointPane = new PointCardGamePane(4, 24);

        primaryStage.setScene(new Scene(pointPane));
        primaryStage.setTitle(pointPane.gamePoint + " game! Find solution.");
        primaryStage.show();

    }

    private class PointCardGamePane extends GridPane {

        private int gamePoint;

        private TextField tfOutput;
        private TextField[] tfValues;
        private Button btSolve;

        PointCardGamePane(int size, int gamePoint) {

            this.gamePoint = gamePoint;

            // top pane (holds output textfield and solve button
            tfOutput = new TextField();
            tfOutput.setPrefColumnCount(20);
            btSolve = new Button("Solve");
            btSolve.setOnAction(e-> {

                String expression;
                try {
                    ArrayList<Double> numberArray = new ArrayList<>();
                    for (TextField tf : tfValues) {
                        // Truncate decimal places...
                        Integer integer = Integer.parseInt(tf.getText());
                        numberArray.add(Double.parseDouble(integer.toString()));
                    }

                    // Get postfix expression
                    expression = PostfixNotation.postfixGenerator(gamePoint, 10000, numberArray.toArray(new Double[numberArray.size()]));

                    // convert expression to infix if there's still a solution
                    if (!expression.equals("No Solution")) {
                        expression = PostfixNotation.convertToInfix(expression);
                    }
                    tfOutput.setText(expression);

                } catch (NumberFormatException ex) {
                    tfOutput.setText("Invalid input");
                }
            });

            HBox topPane = new HBox(5, tfOutput, btSolve);
            topPane.setPadding(new Insets(10));
            addRow(0, topPane);

            // Bottom pane (holds textfield values)
            HBox bottomPane = new HBox(10);
            bottomPane.setAlignment(Pos.BASELINE_CENTER);
            bottomPane.setPadding(new Insets(10));
            tfValues = new TextField[size];
            for (int i = 0; i < size; i++) {
                tfValues[i] = new TextField();
                tfValues[i].setPrefColumnCount(2);
                tfValues[i].setAlignment(Pos.CENTER);
                tfValues[i].setFont(Font.font(23));
                tfValues[i].setPadding(new Insets(20));
            }
            bottomPane.getChildren().addAll(tfValues);
            addRow(1, bottomPane);
        }
    }

}