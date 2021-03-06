package com.ur.thph.urcap;


import org.apache.maven.project.MavenProject;

import java.util.Properties;

public class InstallationNodeClassModel extends NodeClassModel {

    private static final String archetypeGroupId = "com.ur.urcap";
    private static final String archetypeArtifactId = "installationnodearchetype";
    private static final String archetypeVersion = "1.0";

    private String contributionClassName;
    private String serviceClassName;
    private String viewClassName;
    private String nodeTitle;

    private Properties properties;

    public InstallationNodeClassModel(String contributionClassName,String serviceClassName,String viewClassName, String nodeTitle){
        this.contributionClassName = contributionClassName;
        this.serviceClassName = serviceClassName;
        this.viewClassName = viewClassName;
        this.nodeTitle = nodeTitle;
    }

    @Override
    public Properties setProperties(MavenProject project) {
            properties = new Properties();
            properties.setProperty("interactiveMode", "false");
            properties.setProperty("archetypeGroupId", archetypeGroupId);
            properties.setProperty("archetypeArtifactId", archetypeArtifactId);
            properties.setProperty("archetypeVersion", archetypeVersion);
            properties.setProperty("package", project.getGroupId());
            properties.setProperty("groupId", project.getGroupId());
            properties.setProperty("artifactId", project.getArtifactId());
            properties.setProperty("version", "1.0-SNAPSHOT");
            properties.setProperty("contributionClassName", this.contributionClassName + "InstallationNodeContribution");
            properties.setProperty("serviceClassName", this.serviceClassName + "InstallationNodeService");
            properties.setProperty("viewClassName", this.viewClassName + "InstallationNodeView");
            properties.setProperty("nodeTitle", this.nodeTitle);
            return properties;

    }

}
