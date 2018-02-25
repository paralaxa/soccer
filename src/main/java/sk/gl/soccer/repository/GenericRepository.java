package sk.gl.soccer.repository;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<T, ID extends Serializable> {

    List<T> findAll();

    T create(T data);

    T update(T data);

    void delete(ID id);

    T findById(ID id);

}
