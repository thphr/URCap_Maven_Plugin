package com.ur.thph.urcap;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * An Maven Mojo that adds relevant classes for creating a program node to the chosen project.
 */
@Mojo(name = "addprogramnode",defaultPhase = LifecyclePhase.INSTALL)
public class ProgramNodeMojo extends AbstractMojo {
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Adding program node to the project!");
    }
}
