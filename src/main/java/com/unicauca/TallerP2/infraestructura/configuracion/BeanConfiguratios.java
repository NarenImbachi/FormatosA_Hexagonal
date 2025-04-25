package com.unicauca.TallerP2.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.unicauca.TallerP2.aplicacion.output.IDocenteCommandRepositoryPort;
import com.unicauca.TallerP2.aplicacion.output.IDocenteQueryRepositoryPort;
import com.unicauca.TallerP2.aplicacion.output.IFormeadorResultadoOutputPort;
import com.unicauca.TallerP2.dominio.casosDeUso.GestionarDocenteCommandAdapter;

@Configuration
public class BeanConfiguratios {
    // @Bean
    // public GestionarDocenteCommandAdapter gestionarDocenteCommandAdapter(IDocenteCommandRepositoryPort docenteCommandRepositoryPort, 
    //         IFormeadorResultadoOutputPort formeadorResultadoOutputPort, IDocenteQueryRepositoryPort docenteQueryRepositoryPort) {
        
    //     return new GestionarDocenteCommandAdapter(docenteCommandRepositoryPort, formeadorResultadoOutputPort, docenteQueryRepositoryPort);
    // }


}
