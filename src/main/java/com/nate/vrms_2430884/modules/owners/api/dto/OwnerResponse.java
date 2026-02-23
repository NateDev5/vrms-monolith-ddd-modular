package com.nate.vrms_2430884.modules.owners.api.dto;

public record OwnerResponse(
        String id,
        String fullName,
        String address,
        String status) {}