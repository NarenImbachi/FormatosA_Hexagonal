package com.unicauca.TallerP2.aplicacion.output;

public interface IFormeadorResultadoOutputPort {
    public void retornarRespuestaErrorEntidadExiste(String mensaje);

    public void retornarRespuestaErrorEntidadNoExiste(String mensaje);

    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);
}
