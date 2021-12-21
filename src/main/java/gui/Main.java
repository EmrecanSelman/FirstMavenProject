package gui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;


public class Main extends Application {
   User user = new User(12,"null",null);





    public static void main(String[] args) {
        launch(args);

    }

    public static Stage MAIN_STAGE;
    @Override
    public void start(Stage primaryStage) {

        MAIN_STAGE = primaryStage;
        primaryStage.setTitle("KÜTÜPHANE UYGULAMASI");
        Parent root = new MainController();
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
     // DbManager2.getInstance().sessionFactory.openSession();
    }
}
