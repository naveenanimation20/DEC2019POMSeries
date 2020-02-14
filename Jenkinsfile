pipeline {
    agent any
    tools {
        maven 'apache-maven-3.0.1' 
    }
    stages {
    
    stage('Checkout') {
        checkout scm
    }
    
        stage('Run tests') {
          dir('DEC2019POMSeries') {
            sh 'mvn clean test'
          }
      
    }
    }
}
