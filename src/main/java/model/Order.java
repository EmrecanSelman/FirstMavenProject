package model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_book",schema="booklist")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idorder;

    @ManyToOne
    @JoinColumn(name = "bookid")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;
    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Date giventime;
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date comingtime;
    @Column()
    private Integer status;
    @AllArgsConstructor
    @Getter
    public enum OrderStatus{
        GIVEN(0),
        CAME(1);

        private final int type;

    }

}
