package repository;

import java.util.List;

public interface IRepository<T> {
    void save(T model);
    void delete(int id);
    void update(T model);
    T getModels(long id);
    List<T> getModels(String... params);
    List<T> getAllModels();

}
