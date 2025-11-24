import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.Paths;

public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        /*
        System.out.println(getClass().getResource(Paths.LOAN));
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.LOAN));
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.show();
        */

        FXMLLoader loader = new FXMLLoader(getClass().getResource(Paths.CUSTOMER_FORM));
        AnchorPane pane = loader.load();
        Scene scene = new Scene(pane);

        stage.setScene(scene);
        stage.show();

    }
}
