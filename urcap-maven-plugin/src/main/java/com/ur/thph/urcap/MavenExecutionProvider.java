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
public class MavenExecutionProvider implements NodeProvider{

    private static final String mavenExecutionGoal = "archetype:generate";

    @Override
    public InvocationRequest setRequest(MavenProject project, Properties properties) throws MojoExecutionException {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setBaseDirectory(new File(project.getBasedir().getAbsolutePath()));
        request.setGoals(Collections.singletonList(mavenExecutionGoal));
        request.setBatchMode(true);
        request.setProperties(properties);
        return request;
    }

    @Override
    public String executeMavenCommand(InvocationRequest request, String mavenEnvironmentVariable) throws MojoExecutionException {
        Invoker invoker = new DefaultInvoker();
        //invoker.setMavenHome(new File(mavenEnvironmentVariable));
        invoker.getMavenExecutable();
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

}
