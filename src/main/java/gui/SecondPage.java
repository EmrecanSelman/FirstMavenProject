package gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import model.Book;
import repository.BookRepository;
import util.ConfigModel;

import java.io.IOException;
import java.util.List;


public class SecondPage extends Pane {
    @FXML
    private Button exitButtonSecondPage;
    @FXML
    private Button viewBooks;

    @FXML
    private Button deleteBook;

    @FXML
    private Button addBook;

    @FXML
    private TableView<Book> booktable;

    @FXML
    private TableColumn<Book, String> bookNameCol;

    @FXML
    private TableColumn<Book, String> writerNameCol;

    @FXML
    private TableColumn<Book, String> pageNumberCol;
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


       pageNumberCol.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getPagenumber()));
       bookNameCol.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getBookname()));
       writerNameCol.setCellValueFactory(cell-> new SimpleStringProperty(cell.getValue().getWriter()));
    List<Book> neWlist = BookRepository.getInstance().getAllModels();
    ObservableList<Book> observableList = FXCollections.observableList(neWlist);
       booktable.setItems(observableList);


       addBook.setOnMouseClicked(event -> {
           AddBookController es = new AddBookController();
           Scene scene = new Scene(es);
           Main.MAIN_STAGE.setScene(scene);
       });
       deleteBook.setOnMouseClicked(event -> {
         Book selecetdbook =  booktable.getSelectionModel().getSelectedItem();
           if(selecetdbook==null){
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("silmek için kitap seçiniz");
               alert.show();
           }else {
               BookRepository.getInstance().delete(selecetdbook.getId());
               booktable.getItems().remove(selecetdbook);
           }

       });
       exitButtonSecondPage.setOnMouseClicked(event -> {
           ConfigModel.getInstance().setCurrentUser(null);
           ConfigModel.sync();
           MainController es = new MainController();
           Scene scene = new Scene(es);
           Main.MAIN_STAGE.setScene(scene);

       });

   }

}
