package gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class SecondPage extends Pane {
   SecondPage() {

       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("/SecondPage.fxml"));
       loader.setRoot(this);
       loader.setController(this);

       try {
           loader.load();
       } catch (IOException e) {
           e.printStackTrace();
       }

   }

}
