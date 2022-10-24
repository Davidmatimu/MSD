node {
    stage ("Checkout DataService"){
        git branch: 'david', url: 'git@github.com:Davidmatimu/MSD.git'
    }
    
    stage ("Gradle Build - DataService") {
	
        sh 'gradle -b capstone/build.gradle clean build'

    }
    
    stage ("Gradle BootJar-Package - DataService") {
        sh 'gradle -b capstone/build.gradle bootJar'
    }
    
    stage('User Acceptance Test - DataService') {
	
	  def response= input message: 'Is this build good to go?',
	   parameters: [choice(choices: 'Yes\nNo', 
	   description: '', name: 'Pass')]
	
	  if(response=="Yes") {

	    stage('Release- DataService') {
	     sh 'gradle build -x test'
	     sh 'echo DataService is ready to release!'

	    }
	  }
    }
}