URCap Maven Plugin

This project is a maven plugin made for development of URCaps using Swing and Java. It can be cloned and installed as instructed in the following steps or it can be opened in an IDE and further development of this is very much welcome!
It contains feature for adding code skeleton for the classes: view, service and contribution as a starting point for adding:

Program node
Installation node
Toolbar node 

To use this plugin, the plugin must be installed using maven by directing to the /target and run the following command in the terminal(required to have maven installed on the computer):

	mvn org.apache.maven.plugins:maven-install-plugin:3.0.0-M1:install-file -Dfile=urcap-maven-plugin-1.0.jar -DgroupId=com.ur.thph.urcap -DartifactId=urcap-maven-plugin -Dversion=1.0 -Dpackaging=jar

It is also necessary to install jar files for the nodes by directing to the /src/main/resource/archetype directory and run the following three commands in the terminaL one after another:

	mvn install:install-file -Dfile=installationnodearchetype-1.0.jar -DgroupId=com.ur.urcap -DartifactId=installationnodearchetype -Dversion=1.0 -Dpackaging=jar

	mvn install:install-file -Dfile=programnodearchetype-1.0.jar -DgroupId=com.ur.urcap -DartifactId=programnodearchetype -Dversion=1.0 -Dpackaging=jar

	mvn install:install-file -Dfile=toolbarnodearchetype-1.0.jar -DgroupId=com.ur.urcap -DartifactId=toolbarnodearchetype -Dversion=1.0 -Dpackaging=jar

When these jars have been installed the plugin can be used by inserting the following the pom.xml file under the <profiles> tag:

		<profile>
			<id>addprogramnode</id>
			<build>
				<plugins>
					<plugin>
						<groupId>com.ur.thph.urcap</groupId>
						<artifactId>urcap-maven-plugin</artifactId>
						<version>1.0-SNAPSHOT</version>
						<executions>
							<execution>
								<id>programnode-install-urcap</id>
								<phase>install</phase>
								<goals>
									<goal>addprogramnode</goal>
								</goals>
							</execution>
						</executions>
					</plugin>
				</plugins>
			</build>
		</profile> 
		
		<profile>
			<id>addinstallationnode</id>
			<build>
				<plugins>
					<plugin>
						<groupId>com.ur.thph.urcap</groupId>
						<artifactId>urcap-maven-plugin</artifactId>
						<version>1.0-SNAPSHOT</version>
						<executions>
							<execution>
								<id>installationnode-install-urcap</id>
								<phase>install</phase>
								<goals>
									<goal>addinstallationnode</goal>
								</goals>
							</execution>
						</executions>
					</plugin>
				</plugins>
			</build>
		</profile> 

		<profile>
			<id>addtoolbarnode</id>
			<build>
				<plugins>
					<plugin>
						<groupId>com.ur.thph.urcap</groupId>
						<artifactId>urcap-maven-plugin</artifactId>
						<version>1.0-SNAPSHOT</version>
						<executions>
							<execution>
								<id>toolbarnode-install-urcap</id>
								<phase>install</phase>
								<goals>
									<goal>addtoolbarnode</goal>
								</goals>
							</execution>
						</executions>
					</plugin>
				</plugins>
			</build>
		</profile> 

Before doing the following step, please make sure that the value of the tags in the pom.xml file is not empty - this is considered empty:

	<home></home>

Now it should be possible to use the plugin by running the command from the root directory of the project:

For adding program node:

	mvn install -P addprogramnode -DcontributionClassName=<ClassName> -DserviceClassName=<ClassName> -DviewClassName=<ClassName> -DisChilderenAllowed=<Boolean> -DnodeId <NodeId> -DnodeTitle=<Title>

For adding installation node:

	mvn install -P addinstallationnode -DcontributionClassName=<ClassName> -DserviceClassName=<ClassName> -DviewClassName=<ClassName> -DisChilderenAllowed=<Boolean>-DnodeTitle=<Title>

For adding toolbar node:

	mvn install -P addtoolbarnode -DcontributionClassName=<ClassName> -DserviceClassName=<ClassName> -Dicon=<path>

The icon value must be a path where the icon is and the icon must be located in the resource file of the project.
