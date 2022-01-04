package gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import model.Book;
import model.Order;
import model.User;
import repository.BookRepository;
import repository.OrderRepository;
import repository.UserRepository;
import util.ConfigModel;

import java.io.IOException;
import java.util.Date;
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
    @FXML
    private Button giveBackBook;

    @FXML
    private Button borrowBookOperaiton;
   SecondPage() {
       System.out.println(OrderRepository.getInstance().getModels(8).getBook().getId());


       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("/SecondPage.fxml"));
       loader.setRoot(this);
       loader.setController(this);

       try {
           loader.load();
       } catch (IOException e) {
           e.printStackTrace();
       }


       pageNumberCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getPagenumber()));
       bookNameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getBookname()));
       writerNameCol.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getWriter()));
       booktable.setRowFactory(tv -> new TableRow<Book>() {
           @Override
           protected void updateItem(Book item, boolean empty) {
               super.updateItem(item, empty);
               if (item == null)
                   setStyle("");
               else if (item.getStatus()== Book.BookStatus.ONLIBRARY.getType())
                   setStyle("-fx-background-color: #baffba;");
               else if (item.getStatus()== Book.BookStatus.ONUSER.getType())
                   setStyle("-fx-background-color: #ff00d1;");
               else
                   setStyle("");
           }
       });
       List<Book> neWlist = BookRepository.getInstance().getAllModels();
       ObservableList<Book> observableList = FXCollections.observableList(neWlist);
       booktable.setItems(observableList);


       addBook.setOnMouseClicked(event -> {
           AddBookController es = new AddBookController();
           Scene scene = new Scene(es);
           Main.MAIN_STAGE.setScene(scene);
       });
       deleteBook.setOnMouseClicked(event -> {
           Book selecetdbook = booktable.getSelectionModel().getSelectedItem();
           if (selecetdbook == null) {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setContentText("silmek için kitap seçiniz");
               alert.show();
           } else {
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
       borrowBookOperaiton.setOnMouseClicked(event -> {
           User user;

           user = ConfigModel.getInstance().getCurrentUser();
           Book selecetedbook = booktable.getSelectionModel().getSelectedItem();
           if (selecetedbook.getStatus()==Book.BookStatus.ONLIBRARY.getType()){
               if(OrderRepository.getInstance().canBeOrder(user)){
                   Order order = new Order();
                   order.setUser(user);
                   order.setBook(selecetedbook);
                   order.setGiventime(new Date());
                   order.setStatus(Order.OrderStatus.GIVEN.getType());
                   OrderRepository.getInstance().save(order);
                   Alert alert=new Alert(Alert.AlertType.INFORMATION);
                   alert.setContentText(selecetedbook.getBookname()+ " kıtabı "+user.getName()+" ısımlı kışıye verıldı.");
                   alert.show();
               }else{
                   Alert alert=new Alert(Alert.AlertType.INFORMATION);
                   alert.setContentText("Bu kışı zaten Maxımum kıtap sayısına ulaşmış");
                   alert.show();
               }

           }else{
               Alert alert=new Alert(Alert.AlertType.INFORMATION);
               alert.setContentText("Kıtap Kütüphanede değıl!!");
               alert.show();

           }


      /*    for (int i=0;i<OrderRepository.getInstance().getAllModels().size();i++){
          if (OrderRepository.getInstance().getAllModels().listIterator().next().getBook().getId() == selecetedbook.getId()) {
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setHeaderText("BAŞARIZ İŞLEM");//BOOK ALREADY GIVEN
                   alert.setContentText("ALMAYA ÇALIŞTIĞINIZ KİTAP ÖNCEDEN ALINMIŞTIR");
                   alert.show();
               }
               else // NO PROBLEM
                   order.setBook(selecetedbook);
               order.setStatus(0);
               order.setGiventime(new Date());
               order.setUser(user);
               order.setComingtime(null);

           }*/



       });
       giveBackBook.setOnMouseClicked(event -> {





   });
}}