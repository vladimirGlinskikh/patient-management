package kz.zhelezyaka.patientservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(
            MethodArgumentNotValidException e) {

        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(
                error -> errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyExistsException(EmailAlreadyExistsException e) {

        log.warn("Email address already exist {}", e.getMessage());

        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Email address already exists");
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePatientNotFoundException(PatientNotFoundException e) {

        log.warn("Patient not found {}", e.getMessage());

        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Patient not found");
        return ResponseEntity.badRequest().body(errors);
    }
}
