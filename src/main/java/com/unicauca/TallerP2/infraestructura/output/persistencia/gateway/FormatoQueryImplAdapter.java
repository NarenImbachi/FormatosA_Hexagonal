package com.unicauca.TallerP2.infraestructura.output.persistencia.gateway;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.TallerP2.aplicacion.output.IFormatoQueryRepository;
import com.unicauca.TallerP2.dominio.Modelos.FormatoA;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.FormatoAEntity;
import com.unicauca.TallerP2.infraestructura.output.persistencia.mappers.IFormatoEntityMapper;
import com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros.IFormatoRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FormatoQueryImplAdapter implements IFormatoQueryRepository {

    private final IFormatoRepositorio formatoRepositorio;

    private final IFormatoEntityMapper formatoEntityMapper;

    @Override
    @Transactional(readOnly = true)
    public FormatoA buscarFormatoPorId(Integer idFormato) {
        Optional<FormatoAEntity> formatoEntity = formatoRepositorio.findById(idFormato);
        return formatoEntity.map(formatoEntityMapper::toDomain).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeFormatoPorTitulo(String titulo) {
        return formatoRepositorio.existsByTitulo(titulo);
    }

    @Override
    public List<FormatoA> buscarFormatoPorCorreoFechaInicioFin(String correo, Date fechaInicio, Date fechaFin) {
        List<FormatoAEntity> formatoEntity = formatoRepositorio.findByTituloAndFechaInicioAndFechaFin(correo, fechaInicio, fechaFin);
        if (formatoEntity == null) {
            return null;
        }
        return formatoEntityMapper.toDomainList(formatoEntity);
    }


    
}
