node {

	def lib = library (
		identifier: 'simple-lib@master', 
		retriever: 
			modernSCM([
				$class: 'GitSCMSource', 
				credentialsId: '', 
				remote: 'https://github.com/hqzhang/jenkins-shared-library-example.git', 
				traits: [[$class: 'jenkins.plugins.git.traits.BranchDiscoveryTrait']]
			])
	)
    stage("Checkout class"){
        echo "STAGE: Checkout Class"
        lib.com.wavecloud.shlib.Checkout.new().checkout(
            "https://github.com/hqzhang/jenkins-shared-library-example.git",
            "master"
        );
    }

    stage("Maven builder"){
        echo "STAGE: Maven builder"
        def mavenLib = lib.com.wavecloud.shlib
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