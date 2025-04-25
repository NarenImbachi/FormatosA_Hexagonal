package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.TallerP2.aplicacion.input.IDocenteCommandInputPort;
import com.unicauca.TallerP2.aplicacion.input.IDocenteQueryInputPort;
import com.unicauca.TallerP2.dominio.Modelos.Docente;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.RespuestaDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion.DocentePeticionDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.DocenteRespuestaDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.mappers.IDocenteRestMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/docente")
@RequiredArgsConstructor
public class ControladorDocente {
    
    private final IDocenteCommandInputPort docenteCommandInputPort;
    private final IDocenteQueryInputPort docenteQueryInputPort;

    private final IDocenteRestMapper docenteRestMapper;

    @PostMapping("/crear")
    public ResponseEntity<RespuestaDTO<DocenteRespuestaDTO>> crearDocente(@RequestBody DocentePeticionDTO docentePeticionDTO) {
        Docente docente = docenteRestMapper.toModel(docentePeticionDTO);
        DocenteRespuestaDTO docenteRespuestaDTO = docenteRestMapper.toDTO(docenteCommandInputPort.crearDocente(docente));
        var respuesta = RespuestaDTO.<DocenteRespuestaDTO>builder()
                .data(docenteRespuestaDTO)
                .status(201)
                .message("Docente creado exitosamente")
                .build();
        return respuesta.of();
    }

    @GetMapping("/consultar")
    public ResponseEntity<RespuestaDTO<List<DocenteRespuestaDTO> >> consultarDocentes() {
        List<Docente> listaDocentes = docenteQueryInputPort.listarDocentes();
        List<DocenteRespuestaDTO> listaDocentesDTO = listaDocentes.stream()
                .map(docenteRestMapper::toDTO)
                .toList();
        var respuesta = RespuestaDTO.<List<DocenteRespuestaDTO>>builder()
                .data(listaDocentesDTO)
                .status(200)
                .message("Lista de docentes")
                .build();
        return respuesta.of();
    }
}
