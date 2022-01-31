#!/usr/bin/env groovy

def call() {
    echo "building the Application..."
    sh 'mvn package'
}