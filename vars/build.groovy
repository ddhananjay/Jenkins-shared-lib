def call(String language) {
    if (language == "java") {
        echo "Building a Java project"
          sh './gradlew clean build'
    } else if (language == "nodejs") {
        echo "Building a Node.js project"
        sh 'npm install && npm start'
    } else if (language == "python") {
        echo "Building a Python project"
        sh 'pip install -r requirements.txt && python setup.py install'
    } else {
        error "Unknown language: ${language}"
    }
}
