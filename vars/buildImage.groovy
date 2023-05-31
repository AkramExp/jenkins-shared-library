def call(String imageName) {
    echo "building the image"
    withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'USER', passwordVariable: 'PASSWORD')]) {
        sh "docker build -t $imageName ."
        sh "docker login -u $USER -p $PASSWORD"
        sh "docker push $imageName"
    }
}
