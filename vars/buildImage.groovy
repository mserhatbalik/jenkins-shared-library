#!/usr/bin/env groovy

def call() {
    echo 'building the docker image..'
    withCredentials([usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t 159.65.85.180:8083/my-latest-app:1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin 159.65.85.180:8083"
        sh 'docker push 159.65.85.180:8083/my-latest-app:1.0'
    }
}