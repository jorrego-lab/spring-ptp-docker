package com.gvscolombia.placetopay.models;

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
public class Autenticacion {

    @NotNull(message = "login no debe ser nulo")
    @NotEmpty(message = "login no debe estar vacio")
    String login;
    @NotNull(message = "tranKey no debe ser nulo")
    @NotEmpty(message = "tranKey no debe estar vacio")
    String tranKey;
    String nonce;
    String seed;

}
