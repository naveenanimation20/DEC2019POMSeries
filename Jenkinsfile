pipeline {
  agent any
  tools {
    maven 'M3'
  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean test'
      }
    }
  }
  
  allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
}
