package com.nate.vrms_2430884.modules.registration.api;

import com.nate.vrms_2430884.modules.registration.api.dto.*;
import com.nate.vrms_2430884.modules.registration.api.dto.RegisterVehicleRequest;
import com.nate.vrms_2430884.modules.registration.api.dto.RenewRegistrationRequest;
import com.nate.vrms_2430884.modules.registration.api.mapper.RegistrationApiMapper;
import com.nate.vrms_2430884.modules.registration.application.service.*;

import com.nate.vrms_2430884.modules.registration.application.service.RegistrationCrudService;
import com.nate.vrms_2430884.modules.registration.application.service.RegistrationOrchestrator;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    private final RegistrationOrchestrator orchestrator;
    private final RegistrationCrudService crud;

    public RegistrationController(RegistrationOrchestrator orchestrator, RegistrationCrudService crud) {
        this.orchestrator = orchestrator;
        this.crud = crud;
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid RegisterVehicleRequest req) {
        var reg = orchestrator.register(req.vehicleId(), req.ownerId(), req.agentId(), req.plate(), req.expiry());
        return ResponseEntity.ok(RegistrationApiMapper.toResponse(reg));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        return ResponseEntity.ok(RegistrationApiMapper.toResponse(crud.get(id)));
    }

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(crud.list().stream().map(RegistrationApiMapper::toResponse).toList());
    }

    @PostMapping("/{id}/renew")
    public ResponseEntity<?> renew(@PathVariable String id, @RequestBody @Valid RenewRegistrationRequest req) {
        var reg = crud.renew(id, req.newExpiry());
        return ResponseEntity.ok(RegistrationApiMapper.toResponse(reg));
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<?> cancel(@PathVariable String id) {
        var reg = crud.cancel(id);
        return ResponseEntity.ok(RegistrationApiMapper.toResponse(reg));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        crud.delete(id);
        return ResponseEntity.noContent().build();
    }
}
