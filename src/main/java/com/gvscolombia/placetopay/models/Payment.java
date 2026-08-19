package com.gvscolombia.placetopay.models;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {
    
    @NotNull(message = "reference no debe ser nulo")
    @NotEmpty(message = "reference no debe estar vacio")
    String reference;
    
    @NotNull(message = "description no debe ser nulo")
    @NotEmpty(message = "description no debe estar vacio")
    String description;
    
    @NotNull(message = "amount no debe ser nulo")
    Amount amount;
    
    Payer shipping;
    Items[] items;
}
