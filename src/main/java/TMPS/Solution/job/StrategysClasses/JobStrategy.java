package TMPS.Solution.job.StrategysClasses;

import TMPS.Solution.connection.QueryExecutor;
import TMPS.Solution.connection.Connection;
import TMPS.Solution.job.JobClass.Job;

public interface JobStrategy {
    void execute(Job job, Connection connection, QueryExecutor queryExecutor);
}
