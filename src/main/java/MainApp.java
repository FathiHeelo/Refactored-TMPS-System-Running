
import TMPS.Solution.connection.QueryExecutor;
import TMPS.Solution.connection.ConnectionPool;
import TMPS.Solution.connection.DataBaseService;
import TMPS.Solution.job.JobClass.Job;
import TMPS.Solution.job.executorClasses.JobExecutionProxy;
import TMPS.Solution.job.executorClasses.JobExecutor;
import TMPS.Solution.job.StrategysClasses.JobStrategyFactory;
import TMPS.Solution.job.template.JobTemplateRegistry;
import TMPS.Solution.job.template.TemplatesClasses.DataProcessingJobTemplate;
import TMPS.Solution.job.template.TemplatesClasses.EmailJobTemplate;
import TMPS.Solution.job.template.TemplatesClasses.ReportJobTemplate;
import TMPS.Solution.model.User;

import java.util.Arrays;


public class MainApp {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== Refactored TMPS System Running ===\n");

        // initialize core components
        ConnectionPool pool = new ConnectionPool();
        JobStrategyFactory factory = new JobStrategyFactory();
        QueryExecutor dbExecutor = new DataBaseService();
        JobExecutor jobExecutor = new JobExecutor(pool, factory, dbExecutor);

        // template registry initialization
        JobTemplateRegistry registry = new JobTemplateRegistry();
        registry.registerTemplate("EMAIL_WEEKLY",
                new EmailJobTemplate("WeeklyEmail", "format=HTML"));
        registry.registerTemplate("PROCESS_DATA",
                new DataProcessingJobTemplate("DataRun", "batch=1000"));
        registry.registerTemplate("REPORT_MONTHLY",
                new ReportJobTemplate("MonthlyPDF", "format=PDF"));

        // proxy wrapper
        JobExecutionProxy proxy = new JobExecutionProxy(jobExecutor);

        // demo user
        User alice = new User("alice",
                Arrays.asList("EXECUTE_EMAIL", "EXECUTE_REPORT", "EXECUTE_DATA"));

        // ------------------ JOB EXECUTION DEMO ------------------

        runJob("EMAIL_WEEKLY", registry, alice, proxy);
        runJob("PROCESS_DATA", registry, alice, proxy);
        runJob("REPORT_MONTHLY", registry, alice, proxy);
    }

    private static void runJob(String key, JobTemplateRegistry registry, User user, JobExecutionProxy proxy) {
        System.out.println("\n[MAIN] >>> Executing job type: " + key);

        Job job = registry.getTemplate(key).buildJob();
        job.setRequestedBy(user);

        proxy.executeJobWithControls(job);
    }
}
