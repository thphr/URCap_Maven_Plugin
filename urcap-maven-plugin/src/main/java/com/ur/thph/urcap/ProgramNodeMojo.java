package com.ur.thph.urcap;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.shared.invoker.*;
import org.eclipse.sisu.Parameters;

import javax.annotation.PreDestroy;
import java.io.File;
import java.util.Collections;
import java.util.Properties;

/**
 * An Maven Mojo that adds relevant classes for creating a program node to the chosen project.
 */
@Mojo(name = "addprogramnode",defaultPhase = LifecyclePhase.INSTALL)
public class ProgramNodeMojo extends AbstractMojo {
    /**
     *

    @Parameter(property = "maven.command", defaultValue = "mvn archetype:generate")
    private String command;

    @Parameter(property = "groupId", defaultValue = "com.ur")
    private String groupId;

    @Parameter(property = "artifactId", defaultValue = "URCap")
    private String articfactId;

     */

    @Parameter(property = "project", readonly = true)
    private MavenProject project;

    private static final String archetypeGroupId = "com.ur.urcap";
    private static final String archetypeArtifactId = "programnodearchetype";
    private static final String archetypeVersion = "1.0";
    private static final String mavenExecutionGoal = "archetype:generate";

    private String mavenHome = System.getenv("MAVEN_HOME");

    private String className = "Test";
    private String nodeName = "myNode";
    private String hasChild = "false";

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        InvocationRequest request = new DefaultInvocationRequest();
        String pomFilePath = project.getBasedir().getAbsolutePath()+"/pom.xml";
        //String pomFilePath = "/home/ur/workspace/MyURCap/pom.xml";
        String groupId = project.getGroupId();
        String artifactId = project.getArtifactId();

        Properties properties = new Properties();
        properties.setProperty("interactiveMode", "false");
        properties.setProperty("archetypeGroupId",archetypeGroupId);
        properties.setProperty("archetypeArtifactId",archetypeArtifactId);
        properties.setProperty("archetypeVersion",archetypeVersion);
        properties.setProperty("package",groupId);
        properties.setProperty("groupId",groupId);
        properties.setProperty("artifactId",artifactId);
        properties.setProperty("contributionClassName",className+"NodeContribution");
        properties.setProperty("serviceClassName",className+"NodeService");
        properties.setProperty("viewClassName",className+"NodeView");
        properties.setProperty("isChildrenAllowed",hasChild);
        properties.setProperty("nodeId",nodeName);
        properties.setProperty("nodeTitle",nodeName);
        properties.setProperty("version","1.0-SNAPSHOT");

       // request.setPomFile(new File(pomFilePath));
        request.setBaseDirectory(new File(project.getBasedir().getAbsolutePath()));
        request.setGoals(Collections.singletonList(mavenExecutionGoal));
        request.setBatchMode(true);
        request.setProperties(properties);

        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(mavenHome));


        String messageResult = "";

        try {
            InvocationResult result = invoker.execute(request);
            if (result.getExitCode() == 0 && result.getExecutionException() == null) {
                messageResult = "The project has been succesfully deployed!";
                getLog().info(messageResult);
            } else {
                messageResult = "Something went wrong during deployment of the URCap!";
                getLog().info(messageResult);
            }
        } catch (MavenInvocationException e) {
            getLog().info("Could not execute! Exception occured!");
            e.printStackTrace();
        }


        getLog().info("Adding program node to the project! " + messageResult);

    }
}
