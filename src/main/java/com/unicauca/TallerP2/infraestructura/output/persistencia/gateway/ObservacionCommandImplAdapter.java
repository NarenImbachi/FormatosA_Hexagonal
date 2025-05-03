package com.unicauca.TallerP2.infraestructura.output.persistencia.gateway;

import org.springframework.stereotype.Component;

import com.unicauca.TallerP2.aplicacion.output.IObservacionCommandRepositoryPort;
import com.unicauca.TallerP2.dominio.Modelos.Observacion;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.EvaluacionEntity;
import com.unicauca.TallerP2.infraestructura.output.persistencia.entities.ObservacionEntity;
import com.unicauca.TallerP2.infraestructura.output.persistencia.mappers.IObservacionCommandEntityMapper;
import com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros.IEvaluacionRepositorio;
import com.unicauca.TallerP2.infraestructura.output.persistencia.repositoros.IObservacionRepositorio;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ObservacionCommandImplAdapter  implements IObservacionCommandRepositoryPort{

    private final IObservacionRepositorio observacionRepositorio;
    private final IObservacionCommandEntityMapper observacionCommandEntityMapper;
    private final IEvaluacionRepositorio evaluacionRepositorio;

    @Override
    public Observacion crearObservacion(Observacion observacion) {
        ObservacionEntity observacionEntity = observacionCommandEntityMapper.toEntity(observacion);
        EvaluacionEntity evaluacion = evaluacionRepositorio.getReferenceById(observacion.getObjEvaluacion().getId());
        observacionEntity.setObjEvaluacion(evaluacion);

        if (evaluacion.getObservacion() == null) {
            evaluacion.setObservacion(new java.util.ArrayList<>());
        }
        evaluacion.getObservacion().add(observacionEntity);

        Observacion observacionGuardada = observacionCommandEntityMapper.toDomain(observacionRepositorio.save(observacionEntity));
        return observacionGuardada;
    }
    
}
