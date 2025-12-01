package TMPS.Solution.job.executorClasses;

import TMPS.Solution.connection.Connection;
import TMPS.Solution.connection.ConnectionPool;
import TMPS.Solution.connection.QueryExecutor;
import TMPS.Solution.job.JobClass.Job;
import TMPS.Solution.job.StrategysClasses.JobStrategy;
import TMPS.Solution.job.StrategysClasses.JobStrategyFactory;

public class JobExecutor {

    private final ConnectionPool pool;
    private final JobStrategyFactory factory;
    private final QueryExecutor executor;

    public JobExecutor(ConnectionPool connectionPool, JobStrategyFactory strategyFactory, QueryExecutor queryExecutor) {
        this.pool = connectionPool;
        this.factory = strategyFactory;
        this.executor = queryExecutor;
    }

    public void executeJob(Job job) {

        Connection conn = null;

        try {
            conn = pool.acquire();

            JobStrategy handler = factory.getStrategy(job.getType());

            if (handler == null) {
                System.out.println("[JobExecutor] Unsupported job type: " + job.getType());
                return;
            }

            handler.execute(job, conn, executor);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("[JobExecutor] Interrupted while acquiring connection.");
        } finally {

            if (conn != null) {
                pool.release(conn);
            }
        }
    }
}
