pipeline {
    agent any
    stages {
        stage('Jenkins Board') {
            steps {
                echo 'Board Interface'
            }
        }
        stage('Build') { 
            steps {
                sh 'mvn clean install'
            }
        }      
    }
}