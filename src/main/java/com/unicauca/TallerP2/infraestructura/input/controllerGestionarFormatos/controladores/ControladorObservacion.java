package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.TallerP2.aplicacion.input.IObservacionCommandInputPort;
import com.unicauca.TallerP2.dominio.Modelos.Observacion;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.RespuestaDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion.ObservacionPeticionDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.ObservacionCommandRespuestaDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.mappers.IObservacionRestMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/observaciones")
@RequiredArgsConstructor
public class ControladorObservacion {
    private final IObservacionCommandInputPort observacionCommandInputPort;
    private final IObservacionRestMapper observacionMapper;

    @PostMapping
    public ResponseEntity<RespuestaDTO<ObservacionCommandRespuestaDTO>> crearObservacion(@Valid @RequestBody ObservacionPeticionDTO observacionPeticionDTO) {
        Observacion observacionCreada = observacionCommandInputPort.crearObservacion(
            observacionPeticionDTO.getObservacion(),
            observacionPeticionDTO.getIdFormatoA(),
            observacionPeticionDTO.getDocentesId()
        );

        observacionCreada.getObjEvaluacion().getId();

        ObservacionCommandRespuestaDTO respuestaDTO = observacionMapper.toDTO(observacionCreada);

        RespuestaDTO<ObservacionCommandRespuestaDTO> respuesta = RespuestaDTO.<ObservacionCommandRespuestaDTO>builder()
            .data(respuestaDTO)
            .status(201)
            .message("Observación creada exitosamente")
            .build();

        return respuesta.of();
    }

}
