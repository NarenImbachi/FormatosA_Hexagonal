package com.unicauca.TallerP2.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.unicauca.TallerP2.aplicacion.output.IDocenteCommandRepositoryPort;
import com.unicauca.TallerP2.aplicacion.output.IDocenteQueryRepositoryPort;
import com.unicauca.TallerP2.aplicacion.output.IEvaluacionCommandRepository;
import com.unicauca.TallerP2.aplicacion.output.IFormatoCommandRepositoryPort;
import com.unicauca.TallerP2.aplicacion.output.IFormatoQueryRepository;
import com.unicauca.TallerP2.aplicacion.output.IFormeadorResultadoOutputPort;
import com.unicauca.TallerP2.aplicacion.output.IObservacionCommandRepositoryPort;
import com.unicauca.TallerP2.dominio.casosDeUso.DocenteCommandAdapter;
import com.unicauca.TallerP2.dominio.casosDeUso.DocenteQueryAdapter;
import com.unicauca.TallerP2.dominio.casosDeUso.EstadoAdapter;
import com.unicauca.TallerP2.dominio.casosDeUso.FormatoCommandAdapter;
import com.unicauca.TallerP2.dominio.casosDeUso.FormatoQueryAdapter;
import com.unicauca.TallerP2.dominio.casosDeUso.ObservacionCommandAdapter;
import com.unicauca.TallerP2.dominio.service.EstadoService;

@Configuration
public class BeanConfiguratios {
    @Bean
    DocenteCommandAdapter gestionarDocenteCommandAdapter(IDocenteCommandRepositoryPort docenteCommandRepositoryPort, 
            IFormeadorResultadoOutputPort formeadorResultadoOutputPort, IDocenteQueryRepositoryPort docenteQueryRepositoryPort) {
        
        return new DocenteCommandAdapter(docenteCommandRepositoryPort, formeadorResultadoOutputPort, docenteQueryRepositoryPort);
    }

    @Bean
    DocenteQueryAdapter gestionarDocenteQueryAdapter(IDocenteQueryRepositoryPort docenteQueryRepositoryPort, 
            IFormeadorResultadoOutputPort formeadorResultadoOutputPort) {
        
        return new DocenteQueryAdapter(docenteQueryRepositoryPort, formeadorResultadoOutputPort);
    }

    @Bean
    FormatoCommandAdapter formatoCommandAdapter(IFormatoCommandRepositoryPort formatoCommandRepositoryPort, 
            IFormatoQueryRepository formatoQueryRepository, IFormeadorResultadoOutputPort formeadorResultadoOutputPort) {
        
        return new FormatoCommandAdapter(formatoCommandRepositoryPort, formatoQueryRepository, formeadorResultadoOutputPort);
    }

    @Bean
    FormatoQueryAdapter formatoQueryAdapter(IFormatoQueryRepository formatoQueryRepository, 
            IFormeadorResultadoOutputPort formeadorResultadoOutputPort) {
        
        return new FormatoQueryAdapter(formatoQueryRepository, formeadorResultadoOutputPort);
    }
    @Bean
    EstadoAdapter estadoAdapter(EstadoService estadoService, IFormatoQueryRepository formatoQueryRepository,
            IFormatoCommandRepositoryPort formatoCommandRepositoryPort) {
        return new EstadoAdapter(estadoService, formatoQueryRepository, formatoCommandRepositoryPort);
    }

    @Bean
    ObservacionCommandAdapter observacionCommandAdapter(IObservacionCommandRepositoryPort observacionCommandRepositoryPort,
            IFormatoQueryRepository formatoQueryRepository, IDocenteQueryRepositoryPort docenteQueryRepositoryPort,
            IEvaluacionCommandRepository evaluacionCommandRepository) {
        return new ObservacionCommandAdapter(observacionCommandRepositoryPort, formatoQueryRepository,
                docenteQueryRepositoryPort, evaluacionCommandRepository);
    }

}
