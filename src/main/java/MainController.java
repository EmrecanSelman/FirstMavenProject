import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainController extends Pane {

    MainController() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainController.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
