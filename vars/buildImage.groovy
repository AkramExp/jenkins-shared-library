def call() {
    echo "building the image"
    withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'USER', passwordVariable: 'PASSWORD')]) {
        sh 'docker build -t akramexp/my-repo:jma-3.0'
        sh 'docker login -u $USER -p $PASSWORD'
        sh 'docker push akramexp/my-repo:jma-3.0'
    }
}
