def call(String username, String imageName, String tag) {
   sh """
      docker buildx build -t ${username}/${imageName}:${tag} .
   """
}
