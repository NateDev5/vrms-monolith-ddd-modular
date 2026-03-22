package com.nate.vrms_2430884.modules.cars.infrastructure.persistence;

import com.nate.vrms_2430884.modules.cars.domain.model.VehicleSpecsEmbeddable;
import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class VehicleJpaEntity {
    @Id
    public String id;

    @Column(nullable = false, unique = true)
    public String vin;

    @Embedded
    public VehicleSpecsEmbeddable specs;

    @Column(nullable = false)
    public String status;
}
