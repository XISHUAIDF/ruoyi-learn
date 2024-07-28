pipeline {
    agent { dockerfile true }
    
    environment {
        TEST_VAR = 'This is a test variable'  // Example environment variable
    }

    stages {
        stage('Run Batch File') {
            steps {
                powershell 'mvn install'
            }
        }

        stage('Build image') {
        // If you have multiple Dockerfiles in your Project, use this:
        // app = docker.build("my-ubuntu-base", "-f Dockerfile.base .")

        app = docker.build("my-ubuntu-base")
    }
    }
}

