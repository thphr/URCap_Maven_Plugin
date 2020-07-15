package com.ur.thph.urcap;

import org.apache.maven.project.MavenProject;

import java.util.Properties;


public class ToolbarNodeClassModel extends NodeClassModel {

    private static final String archetypeGroupId = "com.ur.urcap";
    private static final String archetypeArtifactId = "toolbarnodearchetype";
    private static final String archetypeVersion = "1.0";

    private String contributionClassName;
    private String serviceClassName;
    private String icon;

    private Properties properties;

    public ToolbarNodeClassModel(String contributionClassName, String serviceClassName, String icon) {
        this.contributionClassName = contributionClassName;
        this.serviceClassName = serviceClassName;
        this.icon = icon;
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
            properties.setProperty("contributionClassName", this.contributionClassName+ "ToolbarNodeContribution");
            properties.setProperty("serviceClassName", this.serviceClassName + "ToolbarNodeService");
            properties.setProperty("icon", this.icon);
            return properties;
    }
}
