package com.gvscolombia.placetopay.models;

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
public class Pago {

    StatusModel status;
    Long internalReference;
    String reference;
    String paymentMethod;
    String paymentMethodName;
    String issuerName;
    String receipt;
    String authorization;

}
