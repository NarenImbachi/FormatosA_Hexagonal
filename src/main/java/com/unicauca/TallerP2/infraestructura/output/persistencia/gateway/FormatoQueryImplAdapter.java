package com.unicauca.TallerP2.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.springframework.stereotype.Component;

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
    public List<FormatoA> listarFormatosPorDocente(Integer idDocente) {
       
        throw new UnsupportedOperationException("Unimplemented method 'buscarFormatoPorId'");
        
    }

    @Override
    public FormatoA buscarFormatoPorId(Integer idFormato) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarFormatoPorId'");
    }

    @Override
    public boolean existeFormatoPorTitulo(String titulo) {
        return formatoRepositorio.existsByTitulo(titulo);
    }
    
}
