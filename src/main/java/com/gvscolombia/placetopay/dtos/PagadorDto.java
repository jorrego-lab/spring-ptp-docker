package com.gvscolombia.placetopay.dtos;

import com.gvscolombia.placetopay.models.*;
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
public class PagadorDto {

    
    @NotNull(message = "documentType no puede ser nulo")
    @NotEmpty(message = "documentType no puede estar vacio")
    String documentType;
    
    @NotNull(message = "document no puede ser nulo")
    @NotEmpty(message = "document no puede estar vacio")
    String document;
    
    @NotNull(message = "name no puede ser nulo")
    @NotEmpty(message = "name no puede estar vacio")
    String name;
    
    @NotNull(message = "surname no puede ser nulo")
    @NotEmpty(message = "surname no puede estar vacio")
    String surname;
    
    @NotNull(message = "email no puede ser nulo")
    @NotEmpty(message = "email no puede estar vacio")
    String email;
    
    @NotNull(message = "mobile no puede ser nulo")
    @NotEmpty(message = "mobile no puede estar vacio")
    String mobile;
    
    @NotNull
    String address;

}
