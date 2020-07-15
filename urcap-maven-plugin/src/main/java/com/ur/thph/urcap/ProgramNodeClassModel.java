package com.ur.thph.urcap;

import org.apache.maven.project.MavenProject;

import java.util.Properties;

public class ProgramNodeClassModel extends NodeClassModel{

    private static final String archetypeGroupId = "com.ur.urcap";
    private static final String archetypeArtifactId = "programnodearchetype";
    private static final String archetypeVersion = "1.0";

    private String contributionClassName;
    private String serviceClassName;
    private String viewClassName;
    private String isChildrenAllowed;
    private String nodeId;
    private String nodeTitle;

    private Properties properties;


    public ProgramNodeClassModel(String contributionClassName,String serviceClassName,String viewClassName,String isChildrenAllowed,String nodeId,String nodeTitle){
        this.contributionClassName = contributionClassName;
        this.serviceClassName = serviceClassName;
        this.viewClassName = viewClassName;
        this.isChildrenAllowed = isChildrenAllowed;
        this.nodeId = nodeId;
        this.nodeTitle = nodeTitle;
    }

    @Override
    public Properties setProperties(MavenProject project) {
            Properties properties = new Properties();
            properties.setProperty("interactiveMode", "false");
            properties.setProperty("archetypeGroupId", archetypeGroupId);
            properties.setProperty("archetypeArtifactId", archetypeArtifactId);
            properties.setProperty("archetypeVersion", archetypeVersion);
            properties.setProperty("package", project.getGroupId());
            properties.setProperty("groupId", project.getGroupId());
            properties.setProperty("artifactId", project.getArtifactId());
            properties.setProperty("version", "1.0-SNAPSHOT");
            properties.setProperty("contributionClassName", this.contributionClassName + "ProgramNodeContribution");
            properties.setProperty("serviceClassName", this.serviceClassName + "ProgramNodeService");
            properties.setProperty("viewClassName", this.viewClassName + "ProgramNodeView");
            properties.setProperty("isChildrenAllowed", this.isChildrenAllowed);
            properties.setProperty("nodeId", this.nodeId);
            properties.setProperty("nodeTitle", this.nodeTitle);
            return properties;
    }
}
