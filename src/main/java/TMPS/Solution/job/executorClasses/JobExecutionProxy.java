package TMPS.Solution.job.executorClasses;


import TMPS.Solution.job.JobClass.Job;
import TMPS.Solution.model.User;

public class JobExecutionProxy {

    private final JobExecutor RealExecutor;

    public JobExecutionProxy(JobExecutor RealExecutor) {
        this.RealExecutor = RealExecutor;
    }

    public void executeJobWithControls(Job job) {

        if (!validatePermissions(job)) {
            System.out.println("[Proxy] Access blocked: " + job.getName());
            return;
        }

        User owner = job.getRequestedBy();
        String ownerLabel = (owner != null) ? owner.getName() : "N/A";

        System.out.println("[Proxy] >>> Job start: " + job.getName() + " | User: " + ownerLabel);

        long begin = System.currentTimeMillis();

        try {
            RealExecutor.executeJob(job);
        } finally {
            long finish = System.currentTimeMillis();
            long total = finish - begin;

            System.out.println("[Proxy] >>> Job done: " + job.getName() + " | Time: " + total + "ms");
        }
    }

    private boolean validatePermissions(Job job) {
        User initiator = job.getRequestedBy();

        if (initiator == null) {
            return false;
        }

        String permissionTag = "EXECUTE_" + job.getType();

        return initiator.hasPermission(permissionTag);
    }
}
