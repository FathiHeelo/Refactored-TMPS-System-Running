package TMPS.Solution.job.StrategysClasses.stratigies;


import TMPS.Solution.connection.QueryExecutor;
import TMPS.Solution.connection.Connection;
import TMPS.Solution.job.JobClass.Job;
import TMPS.Solution.job.StrategysClasses.JobStrategy;

public class EmailJobStrategy implements JobStrategy {
    @Override
    public void execute(Job job, Connection connection, QueryExecutor queryExecutor) {
        System.out.println("[EmailJobStrategy] Executing email job: " + job.getName());
        queryExecutor.executeQuery(connection, "INSERT INTO email_sent (job, status) VALUES ('" + job.getId() + "', 'SENT')");
    }
}
