pipeline {

    agent any
    tools {
        maven 'Maven_3.6.3' 
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