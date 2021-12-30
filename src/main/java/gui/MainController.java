package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.User;
import repository.UserRepository;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainController extends AnchorPane {


    @FXML
    private Button loginButton;

    @FXML
    private Button registryButton;

    @FXML
    private TextField usernameLoginText;

    @FXML
    private TextField passLoginText;
    User user = new User();

    MainController() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/MainController.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        loginButton.setOnMouseClicked(event -> {
         List userlist = UserRepository.getInstance().getModels(usernameLoginText.getText(),passLoginText.getText());

         if(userlist.size() > 0 ){
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setHeaderText("Başarılı");
             alert.setContentText("Hoşgeldin " + usernameLoginText.getText().toUpperCase(Locale.ROOT));
             alert.showAndWait();
             SecondPage es = new SecondPage();
             Scene scene = new Scene(es);
             Main.MAIN_STAGE.setScene(scene);

         }
         else {
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setHeaderText("Başarısız");
             alert.setContentText("Lütfen Tekrar Deneyin");
             alert.showAndWait();
         }


        });
        registryButton.setOnMouseClicked(event -> {
            RegistryController es = new RegistryController();
            Scene scene = new Scene(es);
            Main.MAIN_STAGE.setScene(scene);


        });

    }
}
