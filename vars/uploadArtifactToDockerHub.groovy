def call(String imageName, String tag, String username, String dockerCredentialsId = 'dockerhub') {
   sh "echo Pushing docker file to docker hub..${username}"
     sh "echo Pushing docker file to docker hub..${imageName}"
   withCredentials([usernamePassword(credentialsId: dockerCredentialsId, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
       echo "Logging in to Docker Hub"
       sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin ${registry}"

      docker.withRegistry('https://index.docker.io/v1/', dockerCredentialsId) {
                            sh """
                                docker push ${username}/${imageName}:${tag}
                            """
                  }
       }

}
