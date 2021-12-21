package model;

import lombok.*;


import javax.persistence.*;

@Entity
@Table(name = "user",schema="booklist")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column()

    private String name;
    @Column()
    private String password;

   /*
    @AllArgsConstructor
    public model.User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @NoArgsConstructor
    public model.User() {

    }*/
//name="username", length=50, nullable=false, unique=false

}
