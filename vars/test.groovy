def call(String language) {
    if (language == "java") {
        echo "Testing a Java project"
        sh './gradlew test'
    } else if (language == "nodejs") {
        echo "Testing a Node.js project"
        sh 'npm test '
    } else {
        error "Unknown language: ${language}"
    }
}
