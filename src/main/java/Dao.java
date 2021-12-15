import java.util.List;

public interface Dao <T>{
    T get(Integer id) throws DAOEcxeption;
    List<T> getAll() throws DAOEcxeption;

    // return newly created object number, or a -1 on error
    int save(T t) throws IllegalArgumentException, DAOEcxeption;

    // return true on success, false on failure


    // return true on success, false on failure
    boolean delete(T t) throws DAOEcxeption;

}
