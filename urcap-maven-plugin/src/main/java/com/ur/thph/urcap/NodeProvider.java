package com.ur.thph.urcap;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;
import org.apache.maven.shared.invoker.InvocationRequest;
import java.util.Properties;

public interface NodeProvider {

    InvocationRequest setRequest(MavenProject project, Properties properties) throws MojoExecutionException;

    String executeMavenCommand(InvocationRequest request, String mavenEnvironmentVariable) throws MojoExecutionException;
}
