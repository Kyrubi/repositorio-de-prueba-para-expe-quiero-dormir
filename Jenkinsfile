pipeline {
    agent any

    tools {
        maven 'Default Maven'   // Usa Maven instalado en Jenkins
        jdk   'Default JDK'      // Usa el JDK por defecto
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Descargando código desde GitHub...'
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
                echo 'Ejecutando tests...'
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Empaquetando JAR final...'
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
            echo 'Pipeline ejecutado correctamente 🎉'
        }
        failure {
            echo 'Pipeline falló ❌'
        }
    }
}
