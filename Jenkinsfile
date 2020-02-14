#!groovy

node('master') {
    stage('Checkout') {
        checkout scm
    }
    
    stage('Run tests') {
      withMaven(maven: 'Maven 3') {
          dir('Dec2019POMSeries') {
            sh 'mvn clean test'
          }
      }
    }
}
