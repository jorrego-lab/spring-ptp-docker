/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gvscolombia.placetopay.dtos;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResponseDto {
    
    int status;
    Object payload;

    public static ResponseDto sucess(Object data) {
        ResponseDto genericDto = new ResponseDto();
        genericDto.setStatus(HttpStatus.OK.value());
        genericDto.setPayload(data);

        return genericDto;
    }

    public static ResponseDto failed(Object data) {
        ResponseDto genericDto = new ResponseDto();
        genericDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        genericDto.setPayload(data);

        return genericDto;
    }
    
  
    
}
