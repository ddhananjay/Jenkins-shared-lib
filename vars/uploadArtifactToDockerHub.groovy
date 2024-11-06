def call(String imageName, String tag, String username, String dockerCredentialsId = 'dockerhub') {
   sh 'echo Pushing docker file to docker hub..${username}'
     sh 'echo Pushing docker file to docker hub..${imageName}'
   withCredentials([usernamePassword(credentialsId: dockerCredentialsId)]) {
      docker.withRegistry('https://index.docker.io/v1/', dockerCredentialsId) {
                            sh """
                                docker push ${registry}/${imageName}:${tag}
                            """
                  }
       }

}
