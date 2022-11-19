pipeline{
    agent any
    tools{
        maven 'Maven3'
    }
    stages{
        stage('Build jar file'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/turskein/mublesStgoUnidad2.git']]])
                bat 'cd ./micro-services/eureka-service && mvn clean install -DskipTests'
                bat 'cd ./micro-services/gateway-service && mvn clean install -DskipTests'
                bat 'cd ./micro-services/salaries-service && mvn clean install -DskipTests'
                bat 'cd ./micro-services/uploadtimestamps-service && mvn clean install -DskipTests'
                bat 'cd ./micro-services/uploadextrahours-service && mvn clean install -DskipTests'
                bat 'cd ./micro-services/uploadjustification-service && mvn clean install -DskipTests'
            }
        }
        stage('Build Docker Images'){
            steps{
                bat 'cd ./micro-services/eureka-service && docker build -t alexpachecolaos/eureka-image .'
                bat 'cd ./micro-services/gateway-service && docker build -t alexpachecolaos/gateway-image .'
                bat 'cd ./micro-services/salaries-service && docker build -t alexpachecolaos/salaries-image .'
                bat 'cd ./micro-services/uploadtimestamps-service && docker build -t alexpachecolaos/uploadtimestamps-image .'
                bat 'cd ./micro-services/uploadextrahours-service && docker build -t alexpachecolaos/uploadextrahours-image .'
                bat 'cd ./micro-services/uploadjustification-service && docker build -t alexpachecolaos/uploadjustification-image .'
            }
        }
        stage('Push Docker Images'){
            steps{
                bat 'docker push alexpachecolaos/eureka-image'
                bat 'docker push alexpachecolaos/gateway-image'
                bat 'docker push alexpachecolaos/salaries-image'
                bat 'docker push alexpachecolaos/uploadtimestamps-image'
                bat 'docker push alexpachecolaos/uploadextrahours-image'
                bat 'docker push alexpachecolaos/uploadjustification-image'
            }
        }
        
    }
}