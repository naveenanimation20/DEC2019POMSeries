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
  
  
stage('reports') {
    steps {
    script {
            allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: '/allure-results']]
            ])
            
            // publish html
        		publishHTML target: [
            allowMissing: false,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: '/build',
            reportFiles: 'TestExecutionReport.html',
            reportName: 'Extent HTML Report'
          ]
    }
    }
}

}

}
