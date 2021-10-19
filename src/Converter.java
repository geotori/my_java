import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import static java.util.regex.Pattern.matches;

public class Converter extends Application {
    private TextField input, output;
    // Tatt fra Helper klassen
    public static final String HEXADECIMAL_REGEX = "[0-9A-F]+";
    public static final String INTEGER_REGEX = "([-+]|[-+]?\\d+)";
    public static final String BINARY_REGEX = "[01]+";

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setHgap(15);
        pane.setVgap(15);
        pane.setPadding(new Insets(0, 10, 0, 10));

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(20, 10, 10, 10));
        hbox.setSpacing(10);

        input = new TextField();
        input.setPromptText("Skriv inn streng");
        output = new TextField();
        output.setEditable(false);

        pane.add(hbox, 0, 0);
        pane.add(input, 0, 1);
        pane.add(output, 0, 2);

        Button btDec2Bin = new Button("Decimal to Binary");
        Button btDec2Hex = new Button("Decimal to Hex");
        Button btBin2Dec = new Button("Binary to Decimal");
        Button btHex2Dec = new Button("Hex to Decimal");
        hbox.getChildren().addAll(btDec2Bin, btDec2Hex, btBin2Dec, btHex2Dec);

        btDec2Bin.setOnAction(actionEvent -> konverterDesimal2Binaer());
        btDec2Hex.setOnAction(actionEvent -> konverterDesimal2Hex());
        btBin2Dec.setOnAction(actionEvent -> konverterBinaer2Desimal());
        btHex2Dec.setOnAction(actionEvent -> konverterHex2Desimal());

        Scene scene = new Scene(pane, 580, 165);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String dec2Bin(int value) {
        return value == 0 ? "" : dec2Bin(value / 2) + value % 2;
    }

    private String dec2Hex(int value) {
        return value == 0 ? "" : dec2Hex(value / 16) + dec2HexChar(value % 16);
    }

    private char dec2HexChar(int value) {
        return "0123456789ABCDEF".charAt(value);
    }

    private int bin2Dec(String string) {
        return bin2Dec(string, 0, string.length() - 1);
    }

    private int bin2Dec(String string, int low, int high) {
        return high < low ? 0 : bin2Dec(string, low, high - 1) * 2 + (string.charAt(high) - '0');
    }

    private long hex2Dec(String string) {
        return hex2Dec(string, 0, string.length() - 1);
    }

    private long hex2Dec(String string, int low, int high) {
        return high < low ? 0 : hex2Dec(string, low, high - 1) * 16 + hexChar2Desimal(string.charAt(high));
    }

    private long hexChar2Desimal(char ch) {
        return "0123456789ABCDEF".indexOf(ch);
    }

    private void konverterDesimal2Binaer() {
        String a = getTextFromTextField(input);
        if (!isIntegerString(a))
            return;
        setTextToTextField(output, dec2Bin(Integer.parseInt(a)));
    }

    private void konverterDesimal2Hex() {
        String a = getTextFromTextField(input);
        if (!isIntegerString(a))
            return;
        setTextToTextField(output, dec2Hex(Integer.parseInt(a)));
    }

    private void konverterBinaer2Desimal() {
        String a = getTextFromTextField(input);
        if (!isBinaryString(a))
            return;
        setTextToTextField(output, bin2Dec(a) + "");
    }

    private void konverterHex2Desimal() {
        String a = getTextFromTextField(input).toUpperCase();
        if (!isHexadecimalString(a))
            return;
        setTextToTextField(output, hex2Dec(a) + "");
    }

    // Resten ble tatt fra Helper klassen
    public static String getTextFromTextField(TextField field) {
        String text = field.getText();
        field.clear();
        return text;
    }

    public static <T> void setTextToTextField(TextField field, T object) {
        field.clear();
        field.setText(object.toString());
    }

    public static boolean isHexadecimalString(String text) {
        return matches(HEXADECIMAL_REGEX, text);
    }

    public static boolean isBinaryString(String text) {
        return matches(BINARY_REGEX, text);
    }

    public static boolean isIntegerString(String text) {
        return matches(INTEGER_REGEX, text);
    }
}




