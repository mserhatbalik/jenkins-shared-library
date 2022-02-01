#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo 'building the docker image..'
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin(String repositoryIp) {
        script.withCredentials([script.usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin $repositoryIp"
        }
    }

    def dockerPush(String $imageName) {
        script.sh "docker push $imageName"
    }
}