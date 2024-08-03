package mr.sigrh.sigsanctionsrecompenses.service;

import java.util.List;

public interface AbstractService<T>{
    Long save(T dto);
    List<T> findAll();
    T findById(Long id);
    void deleteById(T dto);
}
