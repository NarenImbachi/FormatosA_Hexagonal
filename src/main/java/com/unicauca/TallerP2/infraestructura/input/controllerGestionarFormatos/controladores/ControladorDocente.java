package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.controladores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.TallerP2.aplicacion.input.IDocenteCommandInputPort;
import com.unicauca.TallerP2.aplicacion.input.IDocenteQueryInputPort;
import com.unicauca.TallerP2.dominio.Modelos.Docente;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.RespuestaDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion.DocentePeticionDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.DocenteComiteRespuestaDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.DocenteRespuestaDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTORespuesta.FormatosDocenteResponseDTO;
import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.mappers.IDocenteRestMapper;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/docente")
@RequiredArgsConstructor
@Validated
public class ControladorDocente {
    
    private final IDocenteCommandInputPort docenteCommandInputPort;
    private final IDocenteQueryInputPort docenteQueryInputPort;

    private final IDocenteRestMapper docenteRestMapper;

    @PostMapping("/crear")
    public ResponseEntity<RespuestaDTO<DocenteComiteRespuestaDTO>> crearDocente(@Valid @RequestBody DocentePeticionDTO docentePeticionDTO) {
        Docente docente = docenteRestMapper.toModel(docentePeticionDTO);
        DocenteComiteRespuestaDTO docenteRespuestaDTO = docenteRestMapper.toDTOComite(docenteCommandInputPort.crearDocente(docente));
        var respuesta = RespuestaDTO.<DocenteComiteRespuestaDTO>builder()
                .data(docenteRespuestaDTO)
                .status(201)
                .message("Docente creado exitosamente")
                .build();
        return respuesta.of();
    }

    @GetMapping("/consultar")
    public ResponseEntity<RespuestaDTO<List<DocenteRespuestaDTO>>> consultarDocentes(
        @RequestParam @Size(min = 1, max = 50, message = "{docente.nombreGrupo.size}") String nombreGrupo,
        @RequestParam @Size(min = 1, max = 50, message = "{docente.apellido.size}") String patronApellido) {

        List<Docente> listaDocentes = docenteQueryInputPort.listarDocentes(nombreGrupo, patronApellido);
        List<DocenteRespuestaDTO> listaDocentesDTO = docenteRestMapper.toDTOList(listaDocentes);
        var respuesta = RespuestaDTO.<List<DocenteRespuestaDTO>>builder()
                .data(listaDocentesDTO)
                .status(200)
                .message("Lista de docentes")
                .build();
        return respuesta.of();
    }

    @GetMapping("/consultarMiembrosComite")
    public ResponseEntity<RespuestaDTO<List<DocenteComiteRespuestaDTO> >> consultarMiembrosComite() {
        List<Docente> listaMiembrosComite = docenteQueryInputPort.listarMiembrosComite();
        List<DocenteComiteRespuestaDTO> listaMiembrosComiteDTO = docenteRestMapper.toDTOListComite(listaMiembrosComite);
        var respuesta = RespuestaDTO.<List<DocenteComiteRespuestaDTO>>builder()
                .data(listaMiembrosComiteDTO)
                .status(200)
                .message("Lista de miembros del comite")
                .build();
        return respuesta.of();
    }

    @GetMapping("/consultarFormatoPorDocente/{idDocente}")
    public ResponseEntity<RespuestaDTO<FormatosDocenteResponseDTO>> consultarFormatoPorDocente(@PathVariable 
            @Min(value = 1, message = "{docente.url.id}") Integer idDocente) {
                
        Docente docente = docenteQueryInputPort.formatosPorDocente(idDocente);
        FormatosDocenteResponseDTO formatosDocenteResponseDTO = docenteRestMapper.toFormatosDocenteResponseDTO(docente);
        var respuesta = RespuestaDTO.<FormatosDocenteResponseDTO>builder()
                .data(formatosDocenteResponseDTO)
                .status(200)
                .message("Formato del docente")
                .build();
        return respuesta.of();
    }
}
