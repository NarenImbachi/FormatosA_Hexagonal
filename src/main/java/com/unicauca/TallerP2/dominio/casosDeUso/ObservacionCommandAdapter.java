package com.unicauca.TallerP2.dominio.casosDeUso;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.unicauca.TallerP2.aplicacion.input.IObservacionCommandInputPort;
import com.unicauca.TallerP2.aplicacion.output.IDocenteQueryRepositoryPort;
import com.unicauca.TallerP2.aplicacion.output.IEvaluacionCommandRepository;
import com.unicauca.TallerP2.aplicacion.output.IFormatoQueryRepository;
import com.unicauca.TallerP2.aplicacion.output.IObservacionCommandRepositoryPort;
import com.unicauca.TallerP2.dominio.Modelos.Docente;
import com.unicauca.TallerP2.dominio.Modelos.Evaluacion;
import com.unicauca.TallerP2.dominio.Modelos.FormatoA;
import com.unicauca.TallerP2.dominio.Modelos.Observacion;

@Service
public class ObservacionCommandAdapter implements IObservacionCommandInputPort {

    private final IObservacionCommandRepositoryPort observacionCommandRepositoryPort;
    private final IFormatoQueryRepository formatoQueryRepository;
    private final IDocenteQueryRepositoryPort docenteQueryRepositoryPort;
    private final IEvaluacionCommandRepository evaluacionCommandRepository;

    public ObservacionCommandAdapter(IObservacionCommandRepositoryPort observacionCommandRepositoryPort,
            IFormatoQueryRepository formatoQueryRepository, IDocenteQueryRepositoryPort docenteQueryRepositoryPort,
            IEvaluacionCommandRepository evaluacionCommandRepository) {
        this.observacionCommandRepositoryPort = observacionCommandRepositoryPort;
        this.formatoQueryRepository = formatoQueryRepository;
        this.docenteQueryRepositoryPort = docenteQueryRepositoryPort;
        this.evaluacionCommandRepository = evaluacionCommandRepository;
    }

    @Override
    public Observacion crearObservacion(String observacionTexto, Integer idFormatoA, List<Integer> docentesId) {
        Evaluacion ultimaEvaluacion = formatoQueryRepository.obtenerUltimaEvaluacion(idFormatoA);

        if (ultimaEvaluacion == null) {
            FormatoA formatoA = new FormatoA();
            formatoA.setId(idFormatoA);

            ultimaEvaluacion = new Evaluacion();
            ultimaEvaluacion.setConcepto("Sin concepto");
            ultimaEvaluacion.setFechaRegistroConcepto(new Date());
            ultimaEvaluacion.setNombreCoordinador("Sin coordinador");
            ultimaEvaluacion.setObjFormato(formatoA);
            ultimaEvaluacion.setObservacion(null);

            ultimaEvaluacion = evaluacionCommandRepository.crearEvaluacion(ultimaEvaluacion);
            System.out.println("ID de la evaluacion guardada:    "+ultimaEvaluacion.getId());
        }

        List<Docente> docentes = docenteQueryRepositoryPort.listarDocentesPorIds(docentesId);
        if (docentes.isEmpty()) {
            throw new IllegalArgumentException("No se encontraron docentes con los IDs proporcionados.");
        }

        Observacion nuevaObservacion = new Observacion();
        nuevaObservacion.setObservacion(observacionTexto);
        nuevaObservacion.setObjEvaluacion(ultimaEvaluacion);
        nuevaObservacion.setObjDocente(docentes);
        nuevaObservacion.setFechaRegistro(new Date());

        return observacionCommandRepositoryPort.crearObservacion(nuevaObservacion);
    }
    
}
