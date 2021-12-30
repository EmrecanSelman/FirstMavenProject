package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.User;
import repository.UserRepository;

import java.io.IOException;

public class RegistryController extends Pane {

    @FXML
    private TextField usertextRegistryPage;

    @FXML
    private TextField passtextRegistryPage;

    @FXML
    private Button registryButtonRegistryPage;

    User user = new User();
    RegistryController() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/RegistryController.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        registryButtonRegistryPage.setOnMouseClicked(event ->{

           user.setPassword(passtextRegistryPage.getText());
            user.setName(usertextRegistryPage.getText());
          /*   Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(model.User.class);
            SessionFactory sf = cfg.buildSessionFactory();

            Session session = sf.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
*/
           // repository.UserRepository userRepository = new repository.UserRepository();
            // userRepository.save(user);
            UserRepository.getInstance().save(user);
            MainController es = new MainController();
            Scene scene = new Scene(es);
            Main.MAIN_STAGE.setScene(scene);


        });
    }
}