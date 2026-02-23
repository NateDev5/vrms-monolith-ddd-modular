package com.nate.vrms_2430884.modules.owners.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateOwnerRequest(
        @NotBlank String fullName,
        String address) {}