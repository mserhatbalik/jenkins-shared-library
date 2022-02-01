#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName, String repositoryIp) {
        script.echo 'building the docker image..'
        script.withCredentials([usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "docker build -t $imageName ."
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin $repositoryIp"
            script.sh "docker push $imageName"
        }
    }
}