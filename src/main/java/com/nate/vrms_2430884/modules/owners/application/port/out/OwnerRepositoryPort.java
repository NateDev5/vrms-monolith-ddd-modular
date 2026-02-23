package com.nate.vrms_2430884.modules.owners.application.port.out;

import com.nate.vrms_2430884.modules.owners.domain.model.Owner;
import com.nate.vrms_2430884.modules.owners.domain.model.OwnerId;

import java.util.List;
import java.util.Optional;

public interface OwnerRepositoryPort {
    Owner save(Owner owner);
    Optional<Owner> findById(OwnerId id);
    boolean existsByFullName(String fullName);
    List<Owner> findAll();
    void deleteById(OwnerId id);
}
