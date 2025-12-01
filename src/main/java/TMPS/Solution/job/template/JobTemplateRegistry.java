package TMPS.Solution.job.template;

import TMPS.Solution.job.JobPrototype;

import java.util.HashMap;
import java.util.Map;

public class JobTemplateRegistry {
    private final Map<String, JobPrototype> prototypes = new HashMap<>();

    public void registerTemplate(String key, JobPrototype prototype) {
        prototypes.put(key, prototype);
    }

    public JobPrototype getTemplate(String key) {
        JobPrototype prototype = prototypes.get(key);
        if (prototype == null) return null;
        return prototype.clonePrototype();
    }
}
