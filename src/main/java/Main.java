

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.DbManager;


public class Main extends Application {
    UserDAO userDAO = new UserDAO();

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage MAIN_STAGE;
    @Override
    public void start(Stage primaryStage) {
        MAIN_STAGE = primaryStage;
        DbManager.getInstance();
        DbManager.getInstance().sessionFactory.openSession().
        primaryStage.setTitle("KÜTÜPHANE UYGULAMASI");
        Parent root = new MainController();
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
