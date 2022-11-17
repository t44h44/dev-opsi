pipeline {
    agent any

    stages {
        
                stage('git') {
            steps {
            
                git branch: 'sarra', url: 'https://github.com/t44h44/dev-opsi.git',
                credentialsId:"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";
                
            }
}
     
        stage('MySQL') {
            steps{
                sh '''
                sudo docker stop mysql || true
                sudo docker restart mysql || true
                '''
            }
        }
       stage ('artifact construction') {
            steps{
                sh '''
		mvn clean
                mvn  package
                '''
            }
        } 
	
        stage ('Unit Test') {
           steps{
                sh '''
		   mvn  test
             	 '''
            }
        }
	            stage('JaCoCo') {
            steps {
                echo 'Code Coverage'
                jacoco()
            }
        }
        stage ('SonarQube') {
            steps{
                sh '''
                mvn sonar:sonar
                '''
            }
        }
        stage('Nexus'){
            steps{
                sh """mvn deploy """
            }
        }
         stage('build')
        {
            steps {
                 sh 'docker build --build-arg IP=0.0.0.0 -t sarraklidi/devops  .'
            }
        }

      stage('Push') {

			steps {
				sh 'echo $dockerhub_PSW | docker login -u sarraklidi -p dckr_pat_os789gFKgYlRvT9wPzplzmIlttk'
				sh 'docker push sarraklidi/devops'
			}
		}
        
       stage('Run app With DockerCompose') {
              steps {
                sh '''
                 docker pull sarraklidi/devops
		 docker-compose up -d 
                 docker-compose ps
		'''
              }
              }
	     
        stage('Sending email'){
           steps {
            mail bcc: '', body: '''Ping.. ,
            Pipeline successfully executed  .
            Keep Up The Good Work''', cc: '', from: '', replyTo: '', subject: 'Devops Pipeline', to: 'sarra.klidi@esprit.tn'
            }
       }
    }
}
