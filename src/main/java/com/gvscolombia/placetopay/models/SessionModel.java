package com.gvscolombia.placetopay.models;

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
@Builder
public class SessionModel {

    Autenticacion auth;
    Payer buyer;
    String ipAddress;
    String userAgent;
    Payment payment;
    String returnUrl;
    String paymentMethod;
    
    String expiration;

}
