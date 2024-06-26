package com.wavecloud.shlib;

import static Constants.GITHUB_CREDENTIALS_ID;

def checkout(String repo, 
    String branch = "master"){
    stage("Checkout"){
        checkout([
            $class: 'GitSCM', 
            branches: [[name: "${branch}"]], 
            doGenerateSubmoduleConfigurations: false, 
            userRemoteConfigs: [[
                credentialsId: "", 
                url: "${repo}"
            ]]
        ])
    }
}