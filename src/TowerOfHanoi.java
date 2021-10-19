import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import static java.lang.Integer.parseInt;
import static java.util.regex.Pattern.matches;

public class TowerOfHanoi extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = getGridPane();

        Scene scene = new Scene(pane, 500, 400);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Tower of Hanoi");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane getGridPane() {
        GridPane pane = new GridPane();
        pane.setHgap(20);
        pane.setVgap(15);
        pane.setPadding(new Insets(5, 15, 5, 15));

        HBox hBox = getHBox();
        output = new TextArea();
        output.setEditable(false);
        output.setWrapText(true);
        output.setMinSize(450, 250);

        GridPane.setFillWidth(hBox, true);
        GridPane.setFillWidth(output, true);

        pane.add(hBox, 0, 0);
        pane.add(output, 0, 1);
        return pane;
    }

    private HBox getHBox() {
        HBox hbox = new HBox();

        hbox.setPadding(new Insets(15, 10, 15, 10));
        hbox.setSpacing(15);

        input = new TextField();
        input.setPrefWidth(400);
        input.setPromptText("Number of disks");
        restrictTextFieldInput(input, POSITIVE_INTEGER_REGEX);

        Button findMovesBtn = getButton("Find moves");
        findMovesBtn.setOnAction(actionEvent -> hanoi());

        hbox.getChildren().addAll(input, findMovesBtn);

        return hbox;
    }

    private Button getButton(String name) {
        Button btn = new Button(name);
        btn.setPrefSize(150, 20);

        return btn;
    }

    // Tatt fra Helper klassen
    public static final String POSITIVE_INTEGER_REGEX = "([+]|[+]?\\d+)";

    public static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static <T> void appendTextToTextAreaWithNewline(TextArea area, T object) {
        area.appendText(object.toString() + "\n");
    }

    public static int getIntegerFromTextField(TextField field) throws NumberFormatException {
        return parseInt(getTextFromTextField(field));
    }

    public static void restrictTextFieldInput(TextField field, String regex) {
        field.textProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue.equals(oldValue) || isNullOrEmpty(newValue))
                        return;

                    field.setText(matches(regex, newValue) ? newValue : oldValue);
                });
    }

    public static String getTextFromTextField(TextField field) {
        String text = field.getText();
        field.clear();
        return text;
    } // Slutt på kopiering fra Helper klassen


    private TextField input;
    private TextArea output;
    private long amountMoves = 0, amountCalls = 0;

    private void hanoi() {
        int numberDisk = getIntegerFromTextField(input);
        appendTextToTextAreaWithNewline(output, "Moves are: ");
        moveDisks(numberDisk, 'A', 'B', 'C');
        appendTextToTextAreaWithNewline(output, String.format("%nAmount of calls to method is: %5", amountCalls));
    }

    private void moveDisks(int numberDisks, char fromTower, char toTower, char auxTower) {
        amountCalls++;
        if (numberDisks == 1) {
            appendTextToTextAreaWithNewline(output, String.format("Move number: %5d move disk %2d from %c to %c",
                    ++amountMoves, numberDisks, fromTower, toTower));
        } else {
            moveDisks(numberDisks - 1, fromTower, auxTower, toTower);
            appendTextToTextAreaWithNewline(output, String.format("Move number: %5d move disk %2d from %c to %c",
                    ++amountMoves, numberDisks, fromTower, toTower));

            moveDisks(numberDisks - 1, auxTower, toTower, fromTower);

        }
    }
}




