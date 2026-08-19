package com.gvscolombia.placetopay.exception;

import com.gvscolombia.placetopay.exception.exceptions.MensajeExcepcionDto;
import com.gvscolombia.placetopay.exception.exceptions.ConsultarSessionException;
import com.gvscolombia.placetopay.exception.exceptions.ObjectValidationException;
import com.gvscolombia.placetopay.exception.exceptions.CrearSessionException;
import com.gvscolombia.placetopay.dtos.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;



import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class AppExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ConsultarSessionException.class)
    public ResponseEntity<ResponseDto> handleException(ConsultarSessionException exception) {
        log.error("Exception ConsultarSessionException, Causa: {}", exception);
        MensajeExcepcionDto exceptionDto = MensajeExcepcionDto.builder().codigo("QUERY01").mensaje(exception.getMessage()).recomendacion("").build();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.failed(exceptionDto));
    }
    
     @ResponseBody
    @ExceptionHandler(value = CrearSessionException.class)
    public ResponseEntity<ResponseDto> handleException(CrearSessionException exception) {
        log.error("Exception CrearSessionException, Causa: {}", exception);
        MensajeExcepcionDto exceptionDto = MensajeExcepcionDto.builder().codigo("PAY01").mensaje(exception.getMessage()).recomendacion("").build();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.failed(exceptionDto));
    }

    
     @ResponseBody
    @ExceptionHandler(value = ObjectValidationException.class)
    public ResponseEntity<ResponseDto> handleException(ObjectValidationException exception) {
        log.error("Exception ObjectValidationException, Causa: {}", exception);
        MensajeExcepcionDto exceptionDto = MensajeExcepcionDto.builder().codigo("97").mensaje(exception.getMessage()).recomendacion("").build();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.failed(exceptionDto));
    }
    
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseDto> handleException(Exception exception) {
        log.error("Exception Desconocida, Causa: {}", exception);
        MensajeExcepcionDto exceptionDto = MensajeExcepcionDto.builder().codigo("99").mensaje(exception.getMessage()).recomendacion("").build();
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.failed(exceptionDto));
    }

}
