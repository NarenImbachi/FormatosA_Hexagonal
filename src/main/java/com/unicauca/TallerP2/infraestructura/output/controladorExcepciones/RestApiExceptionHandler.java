package com.unicauca.TallerP2.infraestructura.output.controladorExcepciones;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.unicauca.TallerP2.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import com.unicauca.TallerP2.infraestructura.output.controladorExcepciones.estructuraExcepciones.ErrorUtils;
import com.unicauca.TallerP2.infraestructura.output.controladorExcepciones.estructuraExcepciones.Error;
import com.unicauca.TallerP2.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import com.unicauca.TallerP2.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import com.unicauca.TallerP2.infraestructura.output.controladorExcepciones.excepcionesPropias.EstadoInvalidoException;
import com.unicauca.TallerP2.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;


@ControllerAdvice
public class RestApiExceptionHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final Exception ex, final Locale locale) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.ERROR_GENERICO.getCodigo(),
                                                CodigoError.ERROR_GENERICO.getLlaveMensaje(),
                                                HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        @ExceptionHandler(EntidadYaExisteException.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final EntidadYaExisteException ex) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.ENTIDAD_YA_EXISTE.getCodigo(),
                                                String.format("%s, %s", CodigoError.ENTIDAD_YA_EXISTE.getLlaveMensaje(),
                                                                ex.getMessage()),
                                                HttpStatus.NOT_ACCEPTABLE.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
        }

        @ExceptionHandler(ReglaNegocioExcepcion.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final ReglaNegocioExcepcion ex, final Locale locale) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.VIOLACION_REGLA_DE_NEGOCIO.getCodigo(),
                                                String.format("%s, %s",
                                                                CodigoError.VIOLACION_REGLA_DE_NEGOCIO.getLlaveMensaje(),
                                                                ex.getMessage()),
                                                HttpStatus.BAD_REQUEST.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }


        @ExceptionHandler(EstadoInvalidoException.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final EstadoInvalidoException ex, final Locale locale) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.VIOLACION_REGLA_DE_NEGOCIO.getCodigo(),
                                                String.format("%s, %s",
                                                                CodigoError.VIOLACION_REGLA_DE_NEGOCIO.getLlaveMensaje(),
                                                                ex.getMessage()),
                                                HttpStatus.BAD_REQUEST.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(EntidadNoExisteException.class)
        public ResponseEntity<Error> handleGenericException(final HttpServletRequest req,
                        final EntidadNoExisteException ex, final Locale locale) {
                final Error error = ErrorUtils
                                .crearError(CodigoError.ENTIDAD_NO_ENCONTRADA.getCodigo(),
                                                String.format("%s, %s",
                                                                CodigoError.ENTIDAD_NO_ENCONTRADA.getLlaveMensaje(),
                                                                ex.getMessage()),
                                                HttpStatus.NOT_FOUND.value())
                                .setUrl(req.getRequestURL().toString()).setMetodo(req.getMethod());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
                System.out.println("Retornando respuesta con los errores identificados");
                Map<String, String> errores = new HashMap<>();
                ex.getBindingResult().getAllErrors().forEach((error) -> {
                        String campo = ((FieldError) error).getField();
                        String mensajeDeError = error.getDefaultMessage();
                        errores.put(campo, mensajeDeError);
                });

                return new ResponseEntity<Map<String, String>>(errores, HttpStatus.BAD_REQUEST);
        }

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(ConstraintViolationException.class)
        ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException e) {
                System.out.println("Retornando respuesta con los errores identificados");
                Map<String, String> errores = new HashMap<>();
                e.getConstraintViolations().forEach(violation -> {
                        String campo = violation.getPropertyPath().toString();
                        String mensajeDeError = violation.getMessage();
                        errores.put(campo, mensajeDeError);
                });
                return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(InvalidTypeIdException.class)
        public ResponseEntity<String> handleInvalidTypeIdException(InvalidTypeIdException ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("El campo 'tipoFormato' es obligatorio y debe tener un valor válido (por ejemplo, 'TI' o 'PP').");
        }
    

        @ExceptionHandler(HttpMessageNotReadableException.class)
        public ResponseEntity<Map<String, String>> handleHttpMessageNotReadableException(
                        HttpMessageNotReadableException ex) {
                String fullMessage = ex.getMessage();
                String knownTypesInfo = "";
                int start = fullMessage.indexOf("known type ids =");
                if (start != -1) {
                    knownTypesInfo = fullMessage.substring(start);
                }

                String customMessage = "El cuerpo de la solicitud no es legible: " + knownTypesInfo;

                Map<String, String> errores = new HashMap<>();
                errores.put("tipoFormato", customMessage);
                return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
        }
}
