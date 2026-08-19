package com.gvscolombia.placetopay.services;

import com.gvscolombia.placetopay.dtos.SessionRequest;
import com.gvscolombia.placetopay.models.ConsultaResponse;
import com.gvscolombia.placetopay.models.SessionResponse;


public interface SessionService {
    
    public SessionResponse crearSession(SessionRequest request);
    public ConsultaResponse consultarSession(Long requestId);
    
}
