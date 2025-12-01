package TMPS.Solution.job.StrategysClasses.stratigies;


import TMPS.Solution.connection.QueryExecutor;
import TMPS.Solution.connection.Connection;
import TMPS.Solution.job.JobClass.Job;
import TMPS.Solution.job.StrategysClasses.JobStrategy;

public class DataProcessingStrategy implements JobStrategy {


    @Override
    public void execute(Job job, Connection connection, QueryExecutor queryExecutor) {
        System.out.println("[DataProcessingStrategy] Processing data: " + job.getName());
        queryExecutor.executeQuery(connection, "SELECT * FROM source_table WHERE job_id = '" + job.getId() + "'");
        queryExecutor.executeQuery(connection, "INSERT INTO processed_results (job_id) VALUES ('" + job.getId() + "')");
    }

}
