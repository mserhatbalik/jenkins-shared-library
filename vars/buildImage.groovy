#!/usr/bin/env groovy

def call(String imageName, String repositoryIp) {
    echo 'building the docker image..'
    withCredentials([usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t $imageName ."
        sh "echo $PASS | docker login -u $USER --password-stdin $repositoryIp"
        sh "docker push $imageName"
    }
}