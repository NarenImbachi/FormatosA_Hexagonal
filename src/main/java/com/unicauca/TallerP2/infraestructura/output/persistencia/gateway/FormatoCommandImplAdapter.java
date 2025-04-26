package com.unicauca.TallerP2.infraestructura.output.persistencia.gateway;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.TallerP2.aplicacion.output.IFormatoCommandRepositoryPort;
import com.unicauca.TallerP2.dominio.Modelos.FormatoA;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.DocenteEntity;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.FormatoAEntity;
import com.unicauca.TallerP2.infraestructura.output.persistencia.mappers.IFormatoEntityMapper;
import com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros.IDocenteRepositorio;
import com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros.IFormatoRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FormatoCommandImplAdapter implements IFormatoCommandRepositoryPort {

    private final IFormatoRepositorio formatoRepositorio;
    private final IFormatoEntityMapper formatoEntityMapper;
    private final IDocenteRepositorio docenteRepositorio;

    @Override
    @Transactional
    public FormatoA crearFormato(FormatoA formato) {
        FormatoAEntity formatoEntity = formatoEntityMapper.toEntity(formato);
        
        formatoEntity.getEstado().setObjFormato(formatoEntity);

        DocenteEntity docenteEntity;
        if(docenteRepositorio.existsById(formato.getObjDocente().getId())) {
            docenteEntity = docenteRepositorio.getReferenceById(formato.getObjDocente().getId());
            formatoEntity.setObjDocente(docenteEntity);
        }

        formatoEntity.getObjDocente().setId(null);

        FormatoAEntity formatoCreado = formatoRepositorio.save(formatoEntity);
        return formatoEntityMapper.toDomain(formatoCreado);
    }

    @Override
    public FormatoA modificarFormato(FormatoA formato) {
        FormatoAEntity formatoModificado = formatoRepositorio.save(formatoEntityMapper.toEntity(formato));
        return formatoEntityMapper.toDomain(formatoModificado);
    }

    @Override
    public String cambiarEstado(Integer idFormato, String estado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarEstado'");
    }
    
}
