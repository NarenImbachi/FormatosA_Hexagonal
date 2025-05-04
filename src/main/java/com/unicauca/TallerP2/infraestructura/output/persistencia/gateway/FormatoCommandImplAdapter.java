package com.unicauca.TallerP2.infraestructura.output.persistencia.gateway;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.TallerP2.aplicacion.output.IFormatoCommandRepositoryPort;
import com.unicauca.TallerP2.dominio.Modelos.FormatoA;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.DocenteEntity;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.FormatoAEntity;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.RolEntity;
import com.unicauca.TallerP2.infraestructura.output.persistencia.mappers.IDocenteEntityMapper;
import com.unicauca.TallerP2.infraestructura.output.persistencia.mappers.IFormatoEntityMapper;
import com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros.IDocenteRepositorio;
import com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros.IFormatoRepositorio;
import com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros.IHistoricoRepositorio;
import com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros.IRolRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FormatoCommandImplAdapter implements IFormatoCommandRepositoryPort {

    private final IFormatoRepositorio formatoRepositorio;
    private final IFormatoEntityMapper formatoEntityMapper;
    private final IDocenteRepositorio docenteRepositorio;
    private final IDocenteEntityMapper docenteEntityMapper;
    private final IHistoricoRepositorio historicoRepositorio;
    private final IRolRepositorio rolRepositorio;

    @Override
    @Transactional
    public FormatoA crearFormato(FormatoA formato) {
        FormatoAEntity formatoEntity = formatoEntityMapper.toEntity(formato);
        
        formatoEntity.getEstado().setObjFormato(formatoEntity);

        DocenteEntity docenteEntity;
        if(docenteRepositorio.existsByCorreo(formato.getObjDocente().getCorreo())) {
            docenteEntity = docenteRepositorio.getReferenceByCorreo(formato.getObjDocente().getCorreo());
            formatoEntity.setObjDocente(docenteEntity);
        }else{
            formatoEntity.getObjDocente().setId(null);
            DocenteEntity docenteCreado = docenteRepositorio.save(docenteEntityMapper.toEntity(formato.getObjDocente()));

            for( int i = 0; i < docenteCreado.getObjHistorico().size(); i++){
                RolEntity rolEntity = rolRepositorio.findByNombre(formato.getObjDocente().getObjHistorico().get(i).getObjRol().getNombre());
                docenteCreado.getObjHistorico().get(i).setObjDocente(docenteCreado);
                docenteCreado.getObjHistorico().get(i).setObjRol(rolEntity);
                historicoRepositorio.save(docenteCreado.getObjHistorico().get(i));
            }
            formatoEntity.setObjDocente(docenteRepositorio.getReferenceById(docenteCreado.getId()));
        }

        
        FormatoAEntity formatoCreado = formatoRepositorio.save(formatoEntity);
        return formatoEntityMapper.toDomain(formatoCreado);
    }

    @Override
    @Transactional
    public FormatoA modificarFormato(FormatoA formato) {
        FormatoAEntity formatoModificado = formatoRepositorio.save(formatoEntityMapper.toEntity(formato));
        return formatoEntityMapper.toDomain(formatoModificado);
    }

    @Override
    @Transactional
    public String cambiarEstado(Integer idFormato, String estado) {
        FormatoAEntity formato = formatoRepositorio.findById(idFormato).orElse(null);
        if (formato == null) {
            return "Formato no encontrado";
        }

        formato.getEstado().setEstadoActual(estado);

        formatoRepositorio.save(formato);

        return "Estado cambiado a " + estado;
    }
    
}
