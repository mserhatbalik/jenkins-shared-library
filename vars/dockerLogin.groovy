#!/usr/bin/env groovy
import com.example.Docker

def call(String repositoryIp) {
    return new Docker(this).dockerLogin(repositoryIp)
}