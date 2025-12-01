package TMPS.Solution.job.StrategysClasses;


import TMPS.Solution.job.StrategysClasses.stratigies.DataProcessingStrategy;
import TMPS.Solution.job.StrategysClasses.stratigies.EmailJobStrategy;
import TMPS.Solution.job.StrategysClasses.stratigies.ReportGenerationStrategy;

import java.util.HashMap;
import java.util.Map;

public class JobStrategyFactory {
    private final Map<String, JobStrategy> strategies = new HashMap<>();

    public JobStrategyFactory() {
        strategies.put("EMAIL", new EmailJobStrategy());
        strategies.put("DATA", new DataProcessingStrategy());
        strategies.put("REPORT", new ReportGenerationStrategy());
    }

    public JobStrategy getStrategy(String jobType) {
        return strategies.get(jobType);
    }
}
