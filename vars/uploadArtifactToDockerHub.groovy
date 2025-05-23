def call(String imageName, String tag, String username, String dockerCredentialsId = 'dockerhub', String registry = 'docker.io') {
   echo "Logging in to Docker Hub ...Upadates"
   withCredentials([usernamePassword(credentialsId: dockerCredentialsId, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
       echo "Logging in to Docker Hub"
       sh 'echo $DOCKER_PASSWORD | /usr/local/bin/docker login -u $DOCKER_USERNAME --password-stdin ${registry}'

      docker.withRegistry('https://index.docker.io/v1/', dockerCredentialsId) {
                            sh """
                                /usr/local/bin/docker push ${username}/${imageName}:${tag}
                            """
                  }
       }

}
