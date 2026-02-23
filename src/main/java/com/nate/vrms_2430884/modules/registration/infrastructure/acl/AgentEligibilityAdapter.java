package com.nate.vrms_2430884.modules.registration.infrastructure.acl;

import com.nate.vrms_2430884.modules.agents.application.service.AgentEligibilityService;
import com.nate.vrms_2430884.modules.registration.application.port.out.AgentEligibilityPort;
import org.springframework.stereotype.Component;

@Component
public class AgentEligibilityAdapter implements AgentEligibilityPort {

    private final AgentEligibilityService agentsEligibility;

    public AgentEligibilityAdapter(AgentEligibilityService agentsEligibility) {
        this.agentsEligibility = agentsEligibility;
    }

    @Override
    public boolean isEligible(String agentId) {
        return agentsEligibility.isEligible(agentId);
    }
}
