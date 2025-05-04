package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.ObservacionesFormatoRespuestaDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.mappers.IFormatoRestMapper;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/formato")
@RequiredArgsConstructor
@Validated
public class ControladorFormato {

    private final IFormatoCommandInputPort formatoCommandInputPort;
    private final IFormatoQueryInputPort formatoQueryInputPort;
    private final IEstadoInputPort estadoInputPort;
    private final IFormatoRestMapper formatoRestMapper;

    @PostMapping("/crear")
    public ResponseEntity<RespuestaDTO<FormatoRespuestaDTO>> crearFormato(
            @Valid @RequestBody FormatoPeticionDTO formatoPeticionDTO) {
        FormatoA formato = formatoRestMapper.toModel(formatoPeticionDTO);
        FormatoRespuestaDTO formatoRespuestaDTO = formatoRestMapper
                .toDTO(formatoCommandInputPort.crearFormato(formato));
        var respuesta = RespuestaDTO.<FormatoRespuestaDTO>builder()
                .data(formatoRespuestaDTO)
                .status(201)
                .message("Formato creado exitosamente")
                .build();
        return respuesta.of();
    }

    @PutMapping("/cambiarEstado/{estado}/{idFormato}")
    public ResponseEntity<RespuestaDTO<String>> cambiarEstado(
            @PathVariable @Min(value = 1, message = "{formato.idFormato.min}") Integer idFormato,
            @PathVariable String estado) {
        String mensaje = estadoInputPort.cambiarEstado(idFormato, estado);
        var respuesta = RespuestaDTO.<String>builder()
                .data(mensaje)
                .status(200)
                .message("Estado cambiado exitosamente")
                .build();
        return respuesta.of();
    }

    @GetMapping("/consultarFormato")
    public ResponseEntity<RespuestaDTO<List<FormatoRespuestaDTO>>> consultarFormato(
            @RequestParam @Pattern(regexp = "^[A-Za-z0-9]+@unicauca\\.edu\\.co$", message = "{docente.correo.pattern}") String correo,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) {
        List<FormatoA> formato = formatoQueryInputPort.buscarFormatoPorCorreoFechaInicioFin(correo, fechaInicio,
                fechaFin);
        List<FormatoRespuestaDTO> formatoRespuestaDTO = formatoRestMapper.toDTOList(formato);
        var respuesta = RespuestaDTO.<List<FormatoRespuestaDTO>>builder()
                .data(formatoRespuestaDTO)
                .status(200)
                .message("Formato encontrado exitosamente")
                .build();
        return respuesta.of();
    }

    @GetMapping("/observaciones/{idFormato}")
    public ResponseEntity<RespuestaDTO<ObservacionesFormatoRespuestaDTO>> listarObservacionesPorFormato(
            @PathVariable Integer idFormato) {
        FormatoA formato = formatoQueryInputPort.buscarFormatoPorId(idFormato);
        ObservacionesFormatoRespuestaDTO dto = formatoRestMapper.toObservacionesFormatoDTO(formato);
        var respuesta = RespuestaDTO.<ObservacionesFormatoRespuestaDTO>builder()
                .data(dto)
                .status(200)
                .message("Observaciones del formato consultadas exitosamente")
                .build();
        return respuesta.of();
    }

}
