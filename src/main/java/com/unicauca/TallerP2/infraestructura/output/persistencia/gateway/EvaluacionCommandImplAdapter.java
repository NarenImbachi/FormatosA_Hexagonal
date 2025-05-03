package com.unicauca.TallerP2.infraestructura.output.persistencia.gateway;

import org.springframework.stereotype.Component;

import com.unicauca.TallerP2.aplicacion.output.IEvaluacionCommandRepository;
import com.unicauca.TallerP2.dominio.Modelos.Evaluacion;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.EvaluacionEntity;
import com.unicauca.TallerP2.infraestructura.output.persistencia.mappers.IEvaluacionObservacionEntityMapper;
import com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros.IEvaluacionRepositorio;
import com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros.IFormatoRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EvaluacionCommandImplAdapter implements IEvaluacionCommandRepository {

    private final IEvaluacionRepositorio evaluacionRepositorio;
    private final IFormatoRepositorio formatoRepositorio;
    private final IEvaluacionObservacionEntityMapper evaluacionObservacionEntityMapper;
    
    @Override
    public Evaluacion crearEvaluacion(Evaluacion evaluacion) {
        EvaluacionEntity evaluacionEntity = evaluacionObservacionEntityMapper.toEntity(evaluacion);
        evaluacionEntity.setObjFormato(formatoRepositorio.getReferenceById(evaluacion.getObjFormato().getId()));
        evaluacionEntity = evaluacionRepositorio.save(evaluacionEntity);
        return evaluacionObservacionEntityMapper.toDomain(evaluacionEntity);
    }
    
}
