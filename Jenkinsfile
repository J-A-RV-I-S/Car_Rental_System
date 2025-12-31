pipeline {
  agent any

  triggers {
    cron('H/2 * * * *')
  }

  environment {
    IMAGE_NAME= "car-rental-system"
    IMAGE_TAG= "1.0"
  }

  stages {
    stage('Checkout Code') {
      steps {
        echo 'Cloning github repository'
        checkout scm
      }
    }

    stage('Build Java Application') {
      steps {
        echo 'Compiling java source code'

        sh '''
          java -version
          javac -version

          rm -f bin/*
          mkdir -p bin

          javac -d bin src/*.java
        '''
      }
    }

    stage('Build Docker Image') {
      steps {
        echo 'Building docker image'

        sh '''
          docker --version
          docker build -t $IMAGE_NAME:$IMAGE_TAG .
        '''
      }
    }
  }
  post {
    success {
      echo 'Pipeline completed successfully'
    }
    failure {
      echo 'Pipeline failed'
    }
  }
}
