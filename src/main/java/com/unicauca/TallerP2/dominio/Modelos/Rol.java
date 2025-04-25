package com.unicauca.TallerP2.dominio.Modelos;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    private Integer id;
    
    private String rol_asignado;

    private List<Historico> objHistorico;
}
