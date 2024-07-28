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
        steps {
            docker.build("my-ubuntu-base")
        }
    }

    }
}

