pipeline {

    agent any
    tools {
        maven 'Maven_3.6.3' 
    }
    
    stage('Checkout') {
        checkout scm
    }
    
    stage('Run tests') {
      withMaven(maven: 'Maven_3.6.3') {
          dir('DEC2019POMSeries') {
            sh 'mvn clean test'
          }
      }
    }

}