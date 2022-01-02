package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.Book;
import repository.BookRepository;

import java.io.IOException;

public class AddBookController extends Pane {
    @FXML
    private TextField bookname;

    @FXML
    private TextField pagenumber;

    @FXML
    private TextField writername;

    @FXML
    private Button addBookButton;

    @FXML
    private Button backtoSecondPage;
    AddBookController() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/addBookController.fxml"));
        loader.setRoot(this);
        loader.setController(this);

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        addBookButton.setOnMouseClicked(event -> {
            Book book = new Book();
            book.setBookname(bookname.getText());
            book.setPagenumber(pagenumber.getText());
            book.setWriter(writername.getText());


           BookRepository.getInstance().save(book);
            bookname.setText("");
            pagenumber.setText("");
            writername.setText("");
        });
        backtoSecondPage.setOnMouseClicked(event -> {
            SecondPage es = new SecondPage();
            Scene scene = new Scene(es);
            Main.MAIN_STAGE.setScene(scene);
        });

    }

}
