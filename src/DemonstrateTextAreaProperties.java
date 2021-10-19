import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DemonstrateTextAreaProperties extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane pane = new BorderPane();
        pane.setMinWidth(400);
        pane.setMinHeight(200);
        TextArea textArea = new TextArea();
        pane.setCenter(new ScrollPane(textArea));

        CheckBox chkEditable = new CheckBox("Editable");
        chkEditable.setSelected(true);
        CheckBox chkWrap = new CheckBox("Wrap");
        HBox optionPane = new HBox(chkEditable, chkWrap);

        optionPane.setSpacing(10);
        optionPane.setAlignment(Pos.CENTER);
        pane.setBottom(optionPane);
        BorderPane.setMargin(optionPane, new Insets(10));

        chkEditable.setOnAction(e-> {
            System.out.println("clicked");
            textArea.setEditable(chkEditable.isSelected());
        });

        chkWrap.setOnAction(e->{
            textArea.setWrapText(chkWrap.isSelected());
        });

        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
}