package gui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;
import util.ConfigModel;


public class Main extends Application {
   User user = new User(12,"null",null);





    public static void main(String[] args) {
        launch(args);

    }

    public static Stage MAIN_STAGE;
    @Override
    public void start(Stage primaryStage) {

        MAIN_STAGE = primaryStage;
        ConfigModel.sync();
        Parent root ;
        if (ConfigModel.getInstance().getCurrentUser()!=null){
            root = new MainController();
        }
        else {
            root =  new SecondPage();
        }
        primaryStage.setTitle("KÜTÜPHANE UYGULAMASI");

        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
     // DbManager2.getInstance().sessionFactory.openSession();
    }
}
