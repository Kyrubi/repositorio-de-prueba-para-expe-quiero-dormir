pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Clonando repositorio desde GitHub...'
                git branch: 'main', url: 'https://github.com/Kyrubi/repositorio-de-prueba-para-expe-quiero-dormir.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Compilando proyecto...'
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                echo 'Ejecutando pruebas...'
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Generando artefacto final (JAR)...'
                sh 'mvn package'
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'CI completado correctamente 🎉'
        }
        failure {
            echo 'CI falló ❌'
        }
    }
}
