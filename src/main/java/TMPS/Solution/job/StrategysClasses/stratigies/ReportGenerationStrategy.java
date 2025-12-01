package TMPS.Solution.job.StrategysClasses.stratigies;

import TMPS.Solution.connection.QueryExecutor;
import TMPS.Solution.connection.Connection;
import TMPS.Solution.job.JobClass.Job;
import TMPS.Solution.job.StrategysClasses.JobStrategy;

public class ReportGenerationStrategy implements JobStrategy {
    @Override
    public void execute(Job job, Connection connection, QueryExecutor queryExecutor) {
        System.out.println("[ReportGenerationStrategy] Generating report: " + job.getName());
        queryExecutor.executeQuery(connection, "SELECT * FROM report_source WHERE report = '" + job.getName() + "'");
        queryExecutor.executeQuery(connection, "INSERT INTO generated_reports (job_id, path) VALUES ('" + job.getId() + "', '/reports/" + job.getId() + ".pdf')");
    }
}
