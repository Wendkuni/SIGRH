package net.gestion.pgcongeabsence.web;


import net.gestion.pgcongeabsence.common.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface RestControllerTemplate <T> {

    ResponseEntity<ApiResponse<Boolean>> create(T obj);

    ResponseEntity<ApiResponse<Void>> delete(int id);

    ResponseEntity<ApiResponse<Void>> delete(String obj);

    ResponseEntity<ApiResponse<Boolean>> update(T obj);

    ResponseEntity<ApiResponse<T>> find(int id);

    ResponseEntity<ApiResponse<List<T>>> findAll();
}
