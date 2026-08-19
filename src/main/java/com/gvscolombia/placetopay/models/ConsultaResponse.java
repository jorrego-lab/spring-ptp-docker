package com.gvscolombia.placetopay.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;
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
public class ConsultaResponse {

    StatusModel status;
    Long requestId;
    RequestResponseModel request;
    @JsonAlias(value = {"payment"})
    List<Pago> pagos;

}
