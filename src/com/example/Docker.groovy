package com.example

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def buildImage(String imageName) {
        script.sh "docker build -t $imageName ."
    }
    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'USER', passwordVariable: 'PASSWORD')]) {
            script.sh "docker login -u $script.USER -p $script.PASSWORD"
        }
    }
    def dockerPush(String imageName) {
        script.sh "docker push $imageName"
    }
}