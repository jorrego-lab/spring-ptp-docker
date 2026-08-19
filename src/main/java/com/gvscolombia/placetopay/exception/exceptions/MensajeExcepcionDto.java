package com.gvscolombia.placetopay.exception.exceptions;


import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@Builder
public class MensajeExcepcionDto {

    String codigo;
    String mensaje;
    String recomendacion;

}
