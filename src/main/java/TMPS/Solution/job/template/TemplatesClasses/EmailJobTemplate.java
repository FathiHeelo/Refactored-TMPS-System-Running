package TMPS.Solution.job.template.TemplatesClasses;


import TMPS.Solution.job.JobPrototype;
import TMPS.Solution.job.JobClass.Job;

import java.util.concurrent.ThreadLocalRandom;

public class EmailJobTemplate extends JobPrototype {

    public EmailJobTemplate(String name, String config) {
            super("EMAIL",name, config);
    }


    @Override
    public JobPrototype clonePrototype() {
        return new EmailJobTemplate(this.name, this.config);    }

    @Override
    public Job buildJob() {
        String id = type + "-" + System.currentTimeMillis()+ '-' + ThreadLocalRandom.current().nextInt(1000, 10000);
        return new Job(id, type, name, config);    }
}
