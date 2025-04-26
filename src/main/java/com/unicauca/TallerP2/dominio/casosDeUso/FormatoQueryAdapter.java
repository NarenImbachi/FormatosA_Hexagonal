package com.unicauca.TallerP2.dominio.casosDeUso;

import java.util.List;

import com.unicauca.TallerP2.aplicacion.input.IFormatoQueryInputPort;
import com.unicauca.TallerP2.aplicacion.output.IFormatoQueryRepository;
import com.unicauca.TallerP2.aplicacion.output.IFormeadorResultadoOutputPort;
import com.unicauca.TallerP2.dominio.Modelos.FormatoA;

public class FormatoQueryAdapter implements IFormatoQueryInputPort {

    private final IFormatoQueryRepository formatoQueryRepository;

    private final IFormeadorResultadoOutputPort formeadorResultadoOutputPort;

    public FormatoQueryAdapter(IFormatoQueryRepository formatoQueryRepository, IFormeadorResultadoOutputPort formeadorResultadoOutputPort) {
        this.formatoQueryRepository = formatoQueryRepository;
        this.formeadorResultadoOutputPort = formeadorResultadoOutputPort;
    }

    @Override
    public List<FormatoA> listarFormatosPorDocente(Integer idDocente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarFormatosPorDocente'");
    }

    @Override
    public FormatoA buscarFormatoPorId(Integer idFormato) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarFormatoPorId'");
    }
    
}
