package crud;

public interface Crud<T> {
    void persist(T entity);

    T getById(Object id);

    void merge(T entity);

    void remove(T entity);
}
