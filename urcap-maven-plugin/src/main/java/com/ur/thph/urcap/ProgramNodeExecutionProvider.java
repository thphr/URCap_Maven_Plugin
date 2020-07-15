package com.ur.thph.urcap;


import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.shared.invoker.*;

import javax.inject.Named;
import javax.inject.Singleton;
import java.io.File;
import java.util.Collections;
import java.util.Properties;

@Named
@Singleton
public class ProgramNodeExecutionProvider implements NodeProvider{

    private static final String archetypeGroupId = "com.ur.urcap";
    private static final String archetypeArtifactId = "programnodearchetype";
    private static final String archetypeVersion = "1.0";
    private static final String mavenExecutionGoal = "archetype:generate";


    public InvocationRequest setRequest(MavenProject project, Properties properties) throws MojoExecutionException {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setBaseDirectory(new File(project.getBasedir().getAbsolutePath()));
        request.setGoals(Collections.singletonList(mavenExecutionGoal));
        request.setBatchMode(true);
        request.setProperties(properties);
        return request;
    }


    public String executeMavenCommand(InvocationRequest request, String mavenEnvironmentVariable) throws MojoExecutionException {
        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(mavenEnvironmentVariable));
        String messageResult = "";
        try {
            InvocationResult result = invoker.execute(request);
            if (result.getExitCode() == 0 && result.getExecutionException() == null) {
                messageResult = "The node has been succesfully added!";
            } else {
                messageResult = "Something went wrong during adding of the node!";
            }
        } catch (MavenInvocationException e) {
            e.printStackTrace();
        }
        return messageResult;
    }


    public Properties setProperties(MavenProject project, NodeClassModel model) throws MojoExecutionException {
        if(model instanceof ProgramNodeClassModel) {
            ProgramNodeClassModel programNodemodel = (ProgramNodeClassModel) model;
            Properties properties = new Properties();
            properties.setProperty("interactiveMode", "false");
            properties.setProperty("archetypeGroupId", archetypeGroupId);
            properties.setProperty("archetypeArtifactId", archetypeArtifactId);
            properties.setProperty("archetypeVersion", archetypeVersion);
            properties.setProperty("package", project.getGroupId());
            properties.setProperty("groupId", project.getGroupId());
            properties.setProperty("artifactId", project.getArtifactId());
            properties.setProperty("version", "1.0-SNAPSHOT");
            // properties.setProperty("contributionClassName", contributionClassName + "NodeContribution");
            // properties.setProperty("serviceClassName", serviceClassName + "NodeService");
            //properties.setProperty("viewClassName", viewClassName + "NodeView");
            //properties.setProperty("isChildrenAllowed", isChildrenAllowed);
            //properties.setProperty("nodeId", nodeId);
            //properties.setProperty("nodeTitle", nodeTitle);

            properties.setProperty("contributionClassName", programNodemodel.getContributionClassName() + "NodeContribution");
            properties.setProperty("serviceClassName", programNodemodel.getServiceClassName() + "NodeService");
            properties.setProperty("viewClassName", programNodemodel.getViewClassName() + "NodeView");
            properties.setProperty("isChildrenAllowed", programNodemodel.getIsChildrenAllowed());
            properties.setProperty("nodeId", programNodemodel.getNodeId());
            properties.setProperty("nodeTitle", programNodemodel.getNodeTitle());
            return properties;
        }

        return null;
    }
}
