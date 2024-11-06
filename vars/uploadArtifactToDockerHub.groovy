def call(String imageName, String tag, String username, String registry = 'docker.io', String dockerCredentialsId = 'dockerhub') {

   withCredentials([usernamePassword(credentialsId: dockerCredentialsId, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
       echo "Logging in to Docker Hub"
       sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin ${registry}'

      docker.withRegistry('https://index.docker.io/v1/', dockerCredentialsId) {
                            sh """
                                docker push ${username}/${imageName}:${tag}
                            """
                  }
       }

}
