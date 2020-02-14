#!groovy

node('master') {
    stage('Checkout') {
        echo 'Code checkout'
    }
    
    stage('Run tests') {
        echo 'mvn clean install'
    }
}