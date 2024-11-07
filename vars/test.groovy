def call(String language) {
    if (language == "java") {
        echo "Testing a Java project"
        sh './gradlew test'
    } else if (language == "nodejs") {
        echo "Testing a Node.js project"
        def packageJson = readJSON file: 'package.json'
        if (packageJson.scripts?.test) {
               sh 'npm test'
         } else {
                 echo "No test specified in package.json, skipping test stage."
         }
    } else {
        error "Unknown language: ${language}"
    }
}
