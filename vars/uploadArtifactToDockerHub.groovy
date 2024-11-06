def call(String imageName, String tag, String username, String dockerCredentialsId = 'dockerhub') {
   echo 'Pushing docker file to docker hub..${username}'
   withCredentials([usernamePassword(credentialsId: dockerCredentialsId)]) {
      docker.withRegistry('https://index.docker.io/v1/', dockerCredentialsId) {
                            sh """
                                docker push ${registry}/${imageName}:${tag}
                            """
                  }
       }

}
