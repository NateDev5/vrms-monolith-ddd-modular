package com.nate.vrms_2430884.modules.registration.api.dto;

import java.time.LocalDate;

public record RegistrationResponse(
        String id,
        String vehicleId,
        String ownerId,
        String agentId,
        String plate,
        LocalDate expiry,
        String status) {}