package model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book",schema="booklist")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column()
    private String writer;
    @Column()
    private String bookname;
    @Column()
    private String pagenumber;
    @Column()
    private int status;
    @AllArgsConstructor
    @Getter
    public enum BookStatus{
        ONLIBRARY(0),
        ONUSER(1),
        ONARCHIVE(2);


        private final int type;
    }



   /*
    @AllArgsConstructor
    public model.User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @NoArgsConstructor
    public model.User() {

    }

      // System.out.println(OrderRepository.getInstance().getModels(8).getBook().getId() ==selecetedbook.getId());//true

          OrderRepository.getInstance().getAllModels().forEach(System.out::println);

           System.out.println(OrderRepository.getInstance().getAllModels().stream().iterator().next().getBook().getId());
           for (int i=0;i<OrderRepository.getInstance().getAllModels().size();i++){
               if (OrderRepository.getInstance().getAllModels().listIterator().next().getBook().getId() == selecetedbook.getId()) {
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setContentText("silmek için kitap seçiniz");
                   alert.show();
               }
               else
                order.setBook(selecetedbook);
                order.setStatus(0);
                order.setGiventime(new Date());
                order.setUser(user);
                order.setComingtime(null);

           }
           System.out.println(OrderRepository.getInstance().getAllModels().listIterator().next().getBook().getId()==selecetedbook.getId());


    */
//name="username", length=50, nullable=false, unique=false

}
