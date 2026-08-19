package com.gvscolombia.placetopay.services.impl;

import com.gvscolombia.placetopay.dtos.PagadorDto;
import com.gvscolombia.placetopay.dtos.SessionRequest;
import com.gvscolombia.placetopay.exception.exceptions.ObjectValidationException;
import com.gvscolombia.placetopay.exception.exceptions.CrearSessionException;
import com.gvscolombia.placetopay.models.Address;
import com.gvscolombia.placetopay.models.ConsultaModel;
import com.gvscolombia.placetopay.models.ConsultaResponse;
import com.gvscolombia.placetopay.models.Payer;
import com.gvscolombia.placetopay.models.SessionModel;
import com.gvscolombia.placetopay.models.SessionResponse;
import com.gvscolombia.placetopay.utils.AuthUtils;
import com.gvscolombia.placetopay.utils.Utilidades;
import javax.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.gvscolombia.placetopay.services.SessionService;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
@Service
public class SessionServiceImpl implements SessionService {

    @Value("${propiedades.placetopay.url}")
    private String urlBase;

    @Value("${propiedades.placetopay.session}")
    private String urlSession;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AuthUtils authUtils;

    @Autowired
    private Validator validator;

    @Override
    public SessionResponse crearSession(SessionRequest request) {

        Utilidades.validate(request, validator);

        try {

            log.info("request: {}", request);
            StringBuilder urlApi = new StringBuilder();
            urlApi.append(this.urlBase);
            urlApi.append(this.urlSession);

            Utilidades.validate(request.getPayer(), validator);
            Utilidades.validate(request.getPayment(), validator);
            PagadorDto pagador = request.getPayer();
            
            Payer payer = Payer.builder()
                    .address(Address.builder().street(pagador.getAddress()).build())
                    .document(pagador.getDocument())
                    .documentType(pagador.getDocumentType())
                    .email(pagador.getEmail())
                    .mobile(pagador.getMobile())
                    .name(pagador.getName())
                    .surname(pagador.getSurname())
                    .build();
            
            SessionModel requestModel = SessionModel.builder()
                    .auth(authUtils.generarAutenticacion())
                    .buyer(payer)
                    .ipAddress(request.getIpAddress())
                    .returnUrl(request.getReturnUrl())
                    .userAgent(request.getUserAgent())
                    .payment(request.getPayment())
                    .expiration(getFechaExpiracion(request.getMinutosExpiracion()))
                    .build();

            log.info("Request - requestModel: {}", Utilidades.toJsonString(requestModel));

            ResponseEntity<SessionResponse> postForEntity = this.restTemplate.postForEntity(urlApi.toString(), requestModel, SessionResponse.class);

            log.info("respuesta: {}", Utilidades.toJsonString(postForEntity));
                return postForEntity.getBody();

        } catch (ObjectValidationException ex) {
            log.error("ObjectValidationException: {}", ex);
            throw ex;
        } catch (CrearSessionException ex) {
            log.error("CrearSessionException: {}", ex);
            throw ex;
        } catch (Exception ex) {
            log.error("Exception: {}", ex);
        }
        throw new CrearSessionException("No se logró crear session de pago");

    }

    @Override
    public ConsultaResponse consultarSession(Long requestId) {
        
        

        try {

            log.info("requestId: {}", requestId);
            StringBuilder urlApi = new StringBuilder();
            urlApi.append(this.urlBase);
            urlApi.append(this.urlSession);
            urlApi.append("/".concat(requestId+""));

            
            ConsultaModel requestModel = ConsultaModel.builder()
                    .auth(authUtils.generarAutenticacion())
                    .build();

            log.info("Request - requestModel: {}", Utilidades.toJsonString(requestModel));

            ResponseEntity<ConsultaResponse> postForEntity = this.restTemplate.postForEntity(urlApi.toString(), requestModel, ConsultaResponse.class);

            log.info("respuesta: {}", Utilidades.toJsonString(postForEntity));
                return postForEntity.getBody();

        } catch (ObjectValidationException ex) {
            log.error("ObjectValidationException: {}", ex);
            throw ex;
        } catch (CrearSessionException ex) {
            log.error("CrearSessionException: {}", ex);
            throw ex;
        } catch (Exception ex) {
            log.error("Exception: {}", ex);
        }
        throw new CrearSessionException("No se logró consultar session de pago");
        
    }
    
    
    private String getFechaExpiracion(Integer minutosExpiracion){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime dateExp = LocalDateTime.now().plusMinutes(minutosExpiracion!=null ? minutosExpiracion : 10);
        Date  data = Date.from(dateExp.atZone(ZoneId.systemDefault()).toInstant());
        String formatDate = dateFormat.format(data);
        
        log.info("formatDate:  {}", data);
        return formatDate.concat("-05:00");
        
    }

    

}
