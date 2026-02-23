package com.nate.vrms_2430884.modules.agents.application.port.out;

import com.nate.vrms_2430884.modules.agents.domain.model.Agent;
import com.nate.vrms_2430884.modules.agents.domain.model.AgentId;

import java.util.List;
import java.util.Optional;

public interface AgentRepositoryPort {
    Agent save(Agent agent);
    Optional<Agent> findById(AgentId id);
    boolean existsByName(String name);
    List<Agent> findAll();
    void deleteById(AgentId id);
}