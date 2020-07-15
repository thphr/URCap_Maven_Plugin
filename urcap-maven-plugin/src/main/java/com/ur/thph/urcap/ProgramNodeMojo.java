package com.ur.thph.urcap;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.shared.invoker.*;

import javax.inject.Inject;
import java.io.File;
import java.util.Collections;
import java.util.Properties;

/**
 * An Maven Mojo that adds relevant classes for creating a program node to the chosen project.
 */
@Mojo(name = "addprogramnode",defaultPhase = LifecyclePhase.INSTALL)
public class ProgramNodeMojo extends AbstractMojo {

    @Parameter(property = "contributionClassName", defaultValue = "Test")
    private String contributionClassName;

    @Parameter(property = "serviceClassName", defaultValue = "Test")
    private String serviceClassName;

    @Parameter(property = "viewClassName", defaultValue = "Test")
    private String viewClassName;

    @Parameter(property = "isChildrenAllowed", defaultValue = "false")
    private String isChildrenAllowed;

    @Parameter(property = "nodeId", defaultValue = "myNode")
    private String nodeId;

    @Parameter(property = "nodeTitle", defaultValue = "My Node")
    private String nodeTitle;

    @Parameter(property = "project", readonly = true)
    private MavenProject project;

    @Inject
    NodeProvider provider;

    private String mavenHomeEnvironment = System.getenv("MAVEN_HOME");

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        ProgramNodeClassModel model = new ProgramNodeClassModel(contributionClassName,serviceClassName,viewClassName,isChildrenAllowed,nodeId,nodeTitle);
        Properties properties = provider.setProperties(project,model);
        InvocationRequest request = provider.setRequest(project,properties);
        String messageResult = provider.executeMavenCommand(request,mavenHomeEnvironment);

        getLog().info("Adding program node to the project! " + messageResult);
    }

}
