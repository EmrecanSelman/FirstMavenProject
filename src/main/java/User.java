
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column()
    private String username;
    @Column()
    private String password;


//name="username", length=50, nullable=false, unique=false


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
