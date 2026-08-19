/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gvscolombia.placetopay.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.gvscolombia.placetopay.exception.exceptions.ObjectValidationException;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Billy
 */
@Slf4j
public class Utilidades {
    
    public static String toJsonString(Object objeto) {
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.enable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        try {
            return mapper.writeValueAsString(objeto);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            return objeto.getClass().getName() + "@" + Integer.toHexString(objeto.hashCode());
        }
    }
    
    public static String toJsonStringNotNull(Object objeto) {
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.enable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            return mapper.writeValueAsString(objeto);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            return objeto.getClass().getName() + "@" + Integer.toHexString(objeto.hashCode());
        }
    }
    
    public static void validate(Object object, Validator validator) {
		Set<ConstraintViolation<Object>> constraintViolations=validator.validate(object);
		if (!constraintViolations.isEmpty()) {
			StringBuilder strMessage = new StringBuilder();
			for (ConstraintViolation<?> constraintViolation : constraintViolations) {
				strMessage.append(constraintViolation.getPropertyPath().toString());
				strMessage.append(" : ");
				strMessage.append(constraintViolation.getMessage());
				strMessage.append(". \n");
			}
			throw new ObjectValidationException(strMessage.toString());
		}
	}
}
