package com.sentinel.strategy;
import org.springframework.stereotype.Component;
import com.sentinel.dto.DeviceEventRequest;
import com.sentinel.service.scoring.ReputationService;
import com.sentinel.service.scoring.MachineLearningScoringService;
import com.sentinel.service.scoring.HeuristicScoringService;


@Component
public class AdvancedScoringStrategyImpl implements RiskScoringStrategy {

    private final ReputationService reputationService;
    private final MachineLearningScoringService mlScoringService;
    private final HeuristicScoringService heuristicScoringService;

    public AdvancedScoringStrategyImpl(ReputationService reputationService,
                                       MachineLearningScoringService mlScoringService,
                                       HeuristicScoringService heuristicScoringService) {
        this.reputationService = reputationService;
        this.mlScoringService = mlScoringService;
        this.heuristicScoringService = heuristicScoringService;
    }

    @Override
    public double calculateScore(DeviceEventRequest request) {
        double heuristic = heuristicScoringService.calculate(request);
        double reputation = reputationService.evaluateDevice(request.getDeviceId());
        double aiScore = mlScoringService.predict(request);

        // Ponderação (pode ser configurável futuramente)
        return (heuristic * 0.4) + (reputation * 0.2) + (aiScore * 0.4);
    }
}
