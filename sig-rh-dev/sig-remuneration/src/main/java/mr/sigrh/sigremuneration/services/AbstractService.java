package mr.sigrh.sigremuneration.services;

import java.util.List;

public interface AbstractService <T>{
    Long save(T dto);
    List<T> findAll();
    T findById(Long id);
    void deleteById(Long id);
}
