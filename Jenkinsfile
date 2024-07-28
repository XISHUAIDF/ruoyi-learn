pipeline {
    agent any
    
    environment {
        TEST_VAR = 'This is a test variable'  // Example environment variable
    }

    stages {
        stage('Run Batch File') {
            steps {
                echo 'Preparing to execute the batch file...'
                
                // Execute the batch script
                bat """
                echo -----------------------------------
                echo Executing example.bat
                echo -----------------------------------
                call example.bat
                echo -----------------------------------
                echo Finished executing example.bat
                echo -----------------------------------
                """
            }
        }
    }
}

