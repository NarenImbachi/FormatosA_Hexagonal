package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.validaciones;

import com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.dto.DTOPeticion.FormatoPPPeticionDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class Estudiante2Validator implements ConstraintValidator<Estudiante2Valido, FormatoPPPeticionDto> {

    @Override
    public boolean isValid(FormatoPPPeticionDto value, ConstraintValidatorContext context) {
        String nombre2 = value.getNombreEstudiante2();
        String codigo2 = value.getCodigoEstudiante2();

        if (nombre2 == null || nombre2.trim().isEmpty()) {
            return true;
        }

        if (codigo2 == null || !codigo2.matches("^\\d+$")) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Si se proporciona nombreEstudiante2, el código debe ser numérico y obligatorio")
                   .addPropertyNode("codigoEstudiante2")
                   .addConstraintViolation();
            return false;
        }

        return true;
    }
    
}
