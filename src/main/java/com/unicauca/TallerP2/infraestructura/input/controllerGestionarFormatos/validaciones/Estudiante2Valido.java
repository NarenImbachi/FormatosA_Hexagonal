package com.unicauca.TallerP2.infraestructura.input.controllerGestionarFormatos.validaciones;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = Estudiante2Validator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Estudiante2Valido {
    String message() default "Si se proporciona nombreEstudiante2, el código debe ser numérico y obligatorio";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
