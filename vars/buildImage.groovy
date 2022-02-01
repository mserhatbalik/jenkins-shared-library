#!/usr/bin/env groovy
import com.example.Docker

def call(String imageName, String repositoryIp) {
    return new Docker(this).buildDockerImage(imageName, repositoryIp)
}