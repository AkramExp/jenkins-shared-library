package com.example

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "building the image"
        script.withCredentials([script.usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'USER', passwordVariable: 'PASSWORD')]) {
            script.sh "docker build -t $imageName ."
            script.sh "docker login -u $script.USER -p $script.PASSWORD"
            script.sh "docker push $imageName"
        }
    }
}