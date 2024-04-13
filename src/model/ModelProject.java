package model;

public class ModelProject {
    private int id;
    private String projectArea;
    private String projectSubArea;
    private String projectName;
    private String projectManager;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectArea() {
        return projectArea;
    }

    public void setProjectArea(String projectArea) {
        this.projectArea = projectArea;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getProjectSubArea() {
        return projectSubArea;
    }

    public void setProjectSubArea(String projectSubArea) {
        this.projectSubArea = projectSubArea;
    }
    
    public ModelProject() {
    }

    public ModelProject(int id, String projectArea,String projectSubArea, String projectName, String projectManager) {
        this.id = id;
        this.projectArea = projectArea;
        this.projectSubArea = projectSubArea;
        this.projectName = projectName;
        this.projectManager = projectManager;
    }
    
    
}
