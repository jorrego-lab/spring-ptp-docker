/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gvscolombia.placetopay.dtos;

import com.gvscolombia.placetopay.models.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SessionRequest {
    
    
    @NotNull(message = "Información del pagador no debe ser nula")
    PagadorDto payer;

    @NotNull(message = "ipAddress no debe ser nulo")
    @NotEmpty(message = "ipAddress no debe estar vacio")
    String ipAddress;

    @NotNull(message = "userAgent no debe ser nulo")
    @NotEmpty(message = "userAgent no debe estar vacio")
    String userAgent;

    @NotNull(message = "payment no debe ser nulo")    
    Payment payment;

    @NotNull(message = "returnUrl no debe ser nulo")
    @NotEmpty(message = "returnUrl no debe estar vacio")
    String returnUrl;
    
    String paymentMethod;
    Integer minutosExpiracion;
    
}
