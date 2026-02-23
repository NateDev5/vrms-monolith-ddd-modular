package com.nate.vrms_2430884.modules.registration.api;

import com.nate.vrms_2430884.modules.registration.application.exception.*;
import com.nate.vrms_2430884.modules.registration.domain.exception.*;
import com.nate.vrms_2430884.modules.registration.application.exception.CrossContextValidationException;
import com.nate.vrms_2430884.modules.registration.application.exception.PlateAlreadyTakenException;
import com.nate.vrms_2430884.modules.registration.application.exception.RegistrationNotFoundException;
import com.nate.vrms_2430884.modules.registration.domain.exception.ExpiryDateMustBeFutureException;
import com.nate.vrms_2430884.modules.registration.domain.exception.InvalidPlateException;
import com.nate.vrms_2430884.shared.web.ApiErrorResponse;
import com.nate.vrms_2430884.modules.agents.application.exception.AgentNotFoundException;
import com.nate.vrms_2430884.modules.cars.application.exception.VehicleNotFoundException;
import com.nate.vrms_2430884.modules.owners.application.exception.OwnerNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestControllerAdvice(assignableTypes = RegistrationController.class)
public class RegistrationExceptionHandler {

    @ExceptionHandler(RegistrationNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> notFound(RegistrationNotFoundException ex, HttpServletRequest req) {
        return build(HttpStatus.NOT_FOUND, ex, req);
    }

    @ExceptionHandler(PlateAlreadyTakenException.class)
    public ResponseEntity<ApiErrorResponse> conflict(PlateAlreadyTakenException ex, HttpServletRequest req) {
        return build(HttpStatus.CONFLICT, ex, req);
    }

    @ExceptionHandler(CrossContextValidationException.class)
    public ResponseEntity<ApiErrorResponse> unprocessable(CrossContextValidationException ex, HttpServletRequest req) {
        return build(HttpStatus.valueOf(422), ex, req);
    }

    @ExceptionHandler({
            InvalidPlateException.class,
            ExpiryDateMustBeFutureException.class,
            IllegalArgumentException.class
    })
    public ResponseEntity<ApiErrorResponse> badRequest(RuntimeException ex, HttpServletRequest req) {
        return build(HttpStatus.BAD_REQUEST, ex, req);
    }

    @ExceptionHandler({
            VehicleNotFoundException.class,
            OwnerNotFoundException.class,
            AgentNotFoundException.class
    })
    public ResponseEntity<ApiErrorResponse> notFound(RuntimeException ex, HttpServletRequest req) {
        return build(HttpStatus.NOT_FOUND, ex, req);
    }

    private ResponseEntity<ApiErrorResponse> build(HttpStatus status, Exception ex, HttpServletRequest req) {
        var body = new ApiErrorResponse(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                ex.getMessage(),
                req.getRequestURI()
        );
        return ResponseEntity.status(status).body(body);
    }
}