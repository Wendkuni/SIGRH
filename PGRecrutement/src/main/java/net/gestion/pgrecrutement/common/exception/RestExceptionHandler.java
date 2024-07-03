package net.gestion.pgrecrutement.common.exception;


import net.gestion.pgrecrutement.common.ApiResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;



@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	protected static final String VALIDATION_ERROR="Validation des erreurs"; 


	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		System.out.println("error");
		// TODO Auto-generated method stub
		//Map<String, Object> object = new LinkedHashMap<>();
		List<String> exceptionalErrors = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(x-> x.getDefaultMessage())
				.collect(Collectors.toList());
		ApiResponse<List<String>> apiResponse = new ApiResponse.Builder<List<String>>()
				.status(status.value())
				.message(VALIDATION_ERROR)
				.result(exceptionalErrors)
				.build();
		return new ResponseEntity<Object>(apiResponse, status);			
	}

	@ExceptionHandler(value = AccessDeniedException.class)
	public ResponseEntity<Object> incorrectCredentials(){
        ApiResponse<?> response = new ApiResponse
				.Builder<>()
				.status(HttpStatus.UNAUTHORIZED.value())
				.message("Crédentials incorrects")
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ExceptionHandler(value = EntityNotFoundException.class)

	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleNoHandlerFoundException(ex, headers, status, request);
	}
	
	

}
