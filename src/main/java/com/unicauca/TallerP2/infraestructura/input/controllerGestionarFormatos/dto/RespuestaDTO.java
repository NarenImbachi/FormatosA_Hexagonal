package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RespuestaDTO<T> {
    private T data;
    private Integer status;
    private String message;

    public ResponseEntity<RespuestaDTO<T>> of() {
        return ResponseEntity.status(status).body(this);
    }
    
}
