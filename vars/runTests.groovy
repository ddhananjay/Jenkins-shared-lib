def call(String language) {
    if (language == "java") {
        echo "Testing a Java project"
        sh './gradlew test'
    } else if (language == "nodejs") {
        echo "Testing a Node.js project"
        def packageJson = readJSON file: 'package.json'
        if (packageJson.scripts?.test) {
               sh 'npm runTests'
         } else {
                 echo "No runTests specified in package.json, skipping runTests stage."
         }
    } else {
        error "Unknown language: ${language}"
    }
}
