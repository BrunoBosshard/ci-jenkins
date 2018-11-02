node('master') {
	stage('Poll') {
		checkout scm
	}
	stage('Build and Unit Test'){
		sh 'mvn clean verify -DskipITs=true';
		junit '**/target/surefire-reports/TEST-*.xml'
		archive 'target/*.jar'
	}
	stage('SonarQube Scan') {
		// Create JaCoCo code coverage report
		sh 'mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install -Dmaven.test.failure.ignore=false'
		withSonarQubeEnv('Default SonarQube server') {
			sh 'mvn clean verify sonar:sonar -Dsonar.projectName=example-project -Dsonar.projectKey=example-project -Dsonar.projectVersion=$BUILD_NUMBER';
		}
	}
	stage('SonarQube Quality Gate') {
		timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
			def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
			if (qg.status != 'OK') {
				error "Pipeline aborted due to quality gate failure: ${qg.status}"
			}
		}
	}
	stage ('Integration Test'){
		sh 'mvn clean verify -Dsurefire.skip=true';
		junit '**/target/failsafe-reports/TEST-*.xml'
		archive 'target/*.jar'
	}
	stage ('Publish'){
		def server = Artifactory.server 'Default Artifactory Server'
		def uploadSpec = """{
			"files": [
				{
					"pattern": "target/*.war",
					"target": "example-project/${BUILD_NUMBER}/",
					"props": "Integration-Tested=Yes;Performance-Tested=No"
				}
			]
		}"""
		server.upload(uploadSpec)
	}
}
