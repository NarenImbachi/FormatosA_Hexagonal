package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.unicauca.TallerP2.aplicacion.input.IEstadoInputPort;
import com.unicauca.TallerP2.aplicacion.input.IFormatoCommandInputPort;
import com.unicauca.TallerP2.aplicacion.input.IFormatoQueryInputPort;
import com.unicauca.TallerP2.dominio.Modelos.FormatoA;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.RespuestaDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion.FormatoPeticionDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.FormatoRespuestaDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.mappers.IFormatoRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/formato")
@RequiredArgsConstructor
public class ControladorFormato {

    private final IFormatoCommandInputPort formatoCommandInputPort;
    private final IFormatoQueryInputPort formatoQueryInputPort;
    private final IEstadoInputPort estadoInputPort;
    private final IFormatoRestMapper formatoRestMapper;

    @PostMapping("/crear")
    public ResponseEntity<RespuestaDTO<FormatoRespuestaDTO>> crearFormato(@RequestBody FormatoPeticionDTO formatoPeticionDTO) {
        FormatoA formato = formatoRestMapper.toModel(formatoPeticionDTO);
        FormatoRespuestaDTO formatoRespuestaDTO = formatoRestMapper.toDTO(formatoCommandInputPort.crearFormato(formato));
        var respuesta = RespuestaDTO.<FormatoRespuestaDTO>builder()
                .data(formatoRespuestaDTO)
                .status(201)
                .message("Formato creado exitosamente")
                .build();
        return respuesta.of();
    }

    @PutMapping("/cambiarEstado/{estado}/{idFormato}")
    public ResponseEntity<RespuestaDTO<String>> cambiarEstado(@PathVariable Integer idFormato, @PathVariable String estado) {
        String mensaje = estadoInputPort.cambiarEstado(idFormato, estado);
        var respuesta = RespuestaDTO.<String>builder()
                .data(mensaje)
                .status(200)
                .message("Estado cambiado exitosamente")
                .build();
        return respuesta.of();
    }
}
