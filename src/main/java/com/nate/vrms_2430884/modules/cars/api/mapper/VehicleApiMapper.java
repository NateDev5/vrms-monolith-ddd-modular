package com.nate.vrms_2430884.modules.cars.api.mapper;

import com.nate.vrms_2430884.modules.cars.api.dto.VehicleResponse;
import com.nate.vrms_2430884.modules.cars.domain.model.Vehicle;

public class VehicleApiMapper {
    public static VehicleResponse toResponse(Vehicle v) {
        return new VehicleResponse(
                v.id().value(),
                v.vin().value(),
                v.specs().make(),
                v.specs().model(),
                v.specs().year(),
                v.status().name()
        );
    }
}
