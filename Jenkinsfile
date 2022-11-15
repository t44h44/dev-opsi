pipeline {
    agent any

    stages {
        
                stage('git') {
            steps {
            
                git branch: 'sarra', url: 'https://github.com/t44h44/dev-opsi.git',
                credentialsId:"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";
                
            }
}
/*     
        stage('MySQL') {
            steps{
                sh '''
                sudo docker stop mysql || true
                sudo docker restart mysql || true
                '''
            }
        }
	*/
       stage ('artifact construction') {
            steps{
                sh '''
		mvn clean
                mvn  package
                '''
            }
        } 
	    /*
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
	 stage('Snyk') {
      steps {
        echo 'Testing...'
	snykSecurity failOnError: false, failOnIssues: false, snykInstallation: 'Snyk', snykTokenId: 'Snyk-jenkins'
        
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
                 sh 'docker build --build-arg IP=192.168.1.114 -t ghaithbhs/devops  .'
            }
        }

      stage('Push') {

			steps {
				sh 'echo $dockerhub_PSW | docker login -u ghaithbhs -p dckr_pat_PvFfLE0rm--tKJiRL1igKeLc2fQ'
				sh 'docker push ghaithbhs/devops'
			}
		}
        
       stage('Run app With DockerCompose') {
              steps {
                sh '''
                 docker pull ghaithbhs/devops
                 docker pull ghaithbhs/achat_frontf
		 docker-compose up -d 
                 docker-compose ps
		'''
              }
              }
	     
        stage('Sending email'){
           steps {
            mail bcc: '', body: '''Ping.. ,
            Pipeline successfully executed  .
            Keep Up The Good Work''', cc: '', from: '', replyTo: '', subject: 'Devops Pipeline', to: 'ghaith.belhadjsghaier@esprit.tn'
            }
       }
*/
    }
}
