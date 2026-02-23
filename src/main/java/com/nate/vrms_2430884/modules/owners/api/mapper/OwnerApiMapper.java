package com.nate.vrms_2430884.modules.owners.api.mapper;

import com.nate.vrms_2430884.modules.owners.api.dto.OwnerResponse;
import com.nate.vrms_2430884.modules.owners.domain.model.Owner;

public class OwnerApiMapper {
    public static OwnerResponse toResponse(Owner o) {
        return new OwnerResponse(
                o.id().value(),
                o.fullName().value(),
                o.address().value(),
                o.status().name()
        );
    }
}
