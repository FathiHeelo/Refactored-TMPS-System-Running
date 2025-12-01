package TMPS.Solution.job.template.TemplatesClasses;

import TMPS.Solution.job.JobPrototype;
import TMPS.Solution.job.JobClass.Job;

import java.util.concurrent.ThreadLocalRandom;

public class ReportJobTemplate extends JobPrototype {

    public ReportJobTemplate(String name, String config) {
      super("REPORT",name, config);
    }



    @Override
    public JobPrototype clonePrototype() {
        return new ReportJobTemplate(this.name, this.config);
    }

    @Override
    public Job buildJob() {
        String id = this.type + "-" + System.currentTimeMillis() + '-' + ThreadLocalRandom.current().nextInt(1000, 10000);
        return new Job(id, this.type, this.name, this.config);
    }
}