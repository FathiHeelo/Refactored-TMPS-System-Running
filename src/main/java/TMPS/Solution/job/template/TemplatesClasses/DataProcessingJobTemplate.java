package TMPS.Solution.job.template.TemplatesClasses;


import TMPS.Solution.job.JobPrototype;
import TMPS.Solution.job.JobClass.Job;

import java.util.concurrent.ThreadLocalRandom;

public class DataProcessingJobTemplate extends JobPrototype {

    public DataProcessingJobTemplate(String name, String config) {
        super("DATA", name, config );
    }


    @Override
    public JobPrototype clonePrototype() {
        return new DataProcessingJobTemplate(this.name, this.config);
    }

    @Override
    public Job buildJob() {
        String id = type + "-" + System.currentTimeMillis()+ '-' + ThreadLocalRandom.current().nextInt(1000, 10000);
        return new Job(id, type, name, config);
    }
}


