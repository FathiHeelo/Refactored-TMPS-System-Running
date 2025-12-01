package TMPS.Solution.job;


public abstract class JobPrototype  {
    protected final String type;
    protected final String name;
    protected final String config;

    protected JobPrototype(String type, String name, String config) {
        this.type = type;
        this.name = name;
        this.config = config;
    }

    public abstract JobPrototype clonePrototype();
    public abstract TMPS.Solution.job.JobClass.Job buildJob();
}
