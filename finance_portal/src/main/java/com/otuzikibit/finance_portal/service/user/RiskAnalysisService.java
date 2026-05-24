package com.otuzikibit.finance_portal.service.user;

import com.otuzikibit.finance_portal.model.enums.RiskProfile;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RiskAnalysisService {

    public RiskProfile calculateProfile(Map<String, Integer> answers) {
        int totalScore = answers.values().stream().mapToInt(Integer::intValue).sum();

        if (totalScore <= 4) return RiskProfile.CONSERVATIVE;
        if (totalScore <= 7) return RiskProfile.BALANCED;
        return RiskProfile.AGGRESSIVE;
    }
}
