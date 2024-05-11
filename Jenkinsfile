node {

	def lib = library (
		identifier: 'simple-lib@temp', 
		retriever: 
			modernSCM([
				$class: 'GitSCMSource', 
				credentialsId: '', 
				remote: 'https://github.com/hqzhang/jenkins-shared-library-example.git', 
				traits: [[$class: 'jenkins.plugins.git.traits.BranchDiscoveryTrait']]
			])
	)
    stage("Checkout class"){
        lib.by.bulgak.jenkins.lib.Checkout.new().checkout(
            "git@github.com:aleksei-bulgak/jenkins-shared-library-example.git",
            "master"
        );
    }

    stage("Maven builder"){
        def mavenLib = lib.by.bulgak.jenkins.lib
        def mvn = mavenLib.Maven.builder(this)
            .action("clean install")
            .argument(mavenLib.MavenArgument.create().withPrefix("-D").withKey("key").withName("value").build())
            .argument(mavenLib.MavenArgument.create().withPrefix("-D").withKey("key2").withName("value2").build())
            .silent(true)
            .build();
       def constants = mavenLib.Constants.new()
        mvn.execute(constants.MAVEN);
    }
}