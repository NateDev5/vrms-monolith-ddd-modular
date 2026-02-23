package com.nate.vrms_2430884.modules.registration.api.mapper;

import com.nate.vrms_2430884.modules.registration.api.dto.RegistrationResponse;
import com.nate.vrms_2430884.modules.registration.domain.model.Registration;

public class RegistrationApiMapper {
    public static RegistrationResponse toResponse(Registration r) {
        return new RegistrationResponse(
                r.id().value(),
                r.vehicleIdValue(),
                r.ownerIdValue(),
                r.agentIdValue(),
                r.plateValue(),
                r.expiryValue(),
                r.status().name()
        );
    }
}
