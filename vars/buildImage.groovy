#!/usr/bin/env groovy

def call(String imageName) {
    echo 'building the docker image..'
    withCredentials([usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t $imageName ."
        sh "echo $PASS | docker login -u $USER --password-stdin 159.65.85.180:8083"
        sh "docker push $imageName"
    }
}