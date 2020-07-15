package com.ur.thph.urcap;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.shared.invoker.InvocationRequest;

import javax.inject.Inject;
import java.util.Properties;
/**
 * An Maven Mojo that adds relevant classes for creating an installation node to the chosen project.
 */
@Mojo(name = "addinstallationnode",defaultPhase = LifecyclePhase.INSTALL)
public class InstallationNodeMojo extends AbstractMojo {

    @Parameter(property = "contributionClassName", defaultValue = "Test")
    private String contributionClassName;

    @Parameter(property = "serviceClassName", defaultValue = "Test")
    private String serviceClassName;

    @Parameter(property = "viewClassName", defaultValue = "Test")
    private String viewClassName;

    @Parameter(property = "nodeTitle", defaultValue = "My Node")
    private String nodeTitle;

    @Parameter(property = "project", readonly = true)
    private MavenProject project;

    @Inject
    NodeProvider provider;

    private String mavenHomeEnvironment = System.getenv("MAVEN_HOME");

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        InstallationNodeClassModel model = new InstallationNodeClassModel(contributionClassName,serviceClassName,viewClassName,nodeTitle);
        Properties properties = model.setProperties(project);
        InvocationRequest request = provider.setRequest(project,properties);
        String messageResult = provider.executeMavenCommand(request,mavenHomeEnvironment);

        getLog().info("Adding installation node to the project! " + messageResult);
    }
}
