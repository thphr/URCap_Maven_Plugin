package com.ur.thph.urcap;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

import java.util.Properties;

public abstract class NodeClassModel {

    abstract public Properties setProperties(MavenProject project, NodeClassModel model);
}
