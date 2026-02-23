package com.nate.vrms_2430884.modules.cars.api.dto;

public record VehicleResponse(
        String id,
        String vin,
        String make,
        String model,
        int year,
        String status) {}