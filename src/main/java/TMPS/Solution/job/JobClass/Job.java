package TMPS.Solution.job.JobClass;

import TMPS.Solution.model.User;

public class Job {
    private final String id;
    private final String type;
    private final String name;
    private final String config;
    private User requestedBy;

    public Job(String id, String type, String name, String config) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.config = config;
    }

    public String getId() { return id; }
    public String getType() { return type; }
    public String getName() { return name; }
    public String getConfig() { return config; }
    public User getRequestedBy() { return requestedBy; }
    public void setRequestedBy(User requestedBy) { this.requestedBy = requestedBy; }

}
