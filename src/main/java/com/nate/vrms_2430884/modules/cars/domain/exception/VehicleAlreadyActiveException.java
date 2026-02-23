package com.nate.vrms_2430884.modules.cars.domain.exception;

public class VehicleAlreadyActiveException extends RuntimeException {
    public VehicleAlreadyActiveException(String message) { super(message); }
}
