import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDaoOld {

}
  /*  public Connection getConnection( ) throws SQLException {
        final String username = "root";
        final String password = "7008134258";
        final String dbUrl = "jdbc:mysql://localhost:3306/booklist.user";

        return DriverManager.getConnection(dbUrl,username,password);
    }
    public void ShowErrorMessage(SQLException exception){
        System.out.println("Error :" + exception.getMessage());
        System.out.println("Error code :" + exception.getErrorCode());
    }
    @Override
    public User get(Integer id)  {
        ObservableList<User> gets = FXCollections.observableArrayList();
        String sql = "SELECT * FROM booklist.user WHERE id="+id;
        Statement st;
        ResultSet rs;

        try {
            Connection connection = getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                User user=new User(rs.getString("name"), rs.getString("password"));
                gets.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (User) gets;
    }


    @Override
    public Optional<User> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() throws DAOEcxeption {
        ObservableList<User> userlist = FXCollections.observableArrayList();
        String sql = "SELECT * FROM booklist.user";
        Statement st;
        ResultSet rs;

        try {
            Connection connection = getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                User user=new User(rs.getString("name"), rs.getString("password"));
                userlist.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userlist;
    }

    @Override
    public int save(User user) throws IllegalArgumentException, DAOEcxeption {

        Connection connection;
        PreparedStatement statement;
        try {
            connection = getConnection();
            String sql = "insert into booklist.user (name,password) values (?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    @Override
    public void update(User user, String[] params) {

    }


    @Override
    public boolean delete(User user) throws DAOEcxeption {
        Connection connection;
        PreparedStatement statement;
        try {
            connection = getConnection();
            String SQL = "DELETE FROM booklist.user WHERE id = (?)";
            statement = connection.prepareStatement(SQL);
            statement.setInt(1, user.getId());
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return false;
    }
}*/
