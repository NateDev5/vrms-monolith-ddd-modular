package com.nate.vrms_2430884.modules.owners.application.service;

import com.nate.vrms_2430884.modules.owners.application.exception.OwnerNotFoundException;
import com.nate.vrms_2430884.modules.owners.application.port.out.OwnerRepositoryPort;
import com.nate.vrms_2430884.modules.owners.domain.model.OwnerId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OwnerEligibilityService {

    private final OwnerRepositoryPort repo;
    public OwnerEligibilityService(OwnerRepositoryPort repo) { this.repo = repo; }

    @Transactional(readOnly = true)
    public boolean isEligible(String ownerId) {
        return repo.findById(OwnerId.of(ownerId))
                .map(o -> o.isEligibleForRegistration())
                .orElseThrow(() -> new OwnerNotFoundException("Owner not found: " + ownerId));
    }
}
