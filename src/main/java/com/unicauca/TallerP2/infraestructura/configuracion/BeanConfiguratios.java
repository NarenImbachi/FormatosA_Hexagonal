package com.unicauca.TallerP2.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.unicauca.TallerP2.aplicacion.output.IDocenteCommandRepositoryPort;
import com.unicauca.TallerP2.aplicacion.output.IDocenteQueryRepositoryPort;
import com.unicauca.TallerP2.aplicacion.output.IFormeadorResultadoOutputPort;
import com.unicauca.TallerP2.dominio.casosDeUso.DocenteCommandAdapter;
import com.unicauca.TallerP2.dominio.casosDeUso.DocenteQueryAdapter;

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

}
