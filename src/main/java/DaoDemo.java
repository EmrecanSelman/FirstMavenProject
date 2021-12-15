import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DaoDemo
{
    public static void main(String[] args) {
        BookDAO dao = new BookDAO();
        Books b1 = dao.getBook(5);
        System.out.println(b1.pagenumber);
    }






}
class BookDAO{
    public Books getBook(int id){
        String SQL = "SELECT pagenumber from booklist.booklist WHERE id =" + id;
        Books b1 = new Books();
        b1.id = id;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root","root","7008134258");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            rs.next();
            String name = rs.getString(1);
            b1.pagenumber = name;
            return b1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
class Books{

    int id;
    String pagenumber;

}
