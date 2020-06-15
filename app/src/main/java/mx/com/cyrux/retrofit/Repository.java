package mx.com.cyrux.retrofit;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private String name;
    private String description;

    public Repository(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static List<Repository> getRepositories() {
        List<Repository> repositoryList = new ArrayList<>();
        repositoryList.add(new Repository("Cyrux", "Cyrux Description"));
        repositoryList.add(new Repository("Razor", "Razor Description"));
        repositoryList.add(new Repository("Lolo", "Lolo Description"));
        return repositoryList;
    }
}
