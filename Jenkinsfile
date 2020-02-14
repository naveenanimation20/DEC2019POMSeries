node {
	stage ('SCM checkout'){
		git "https://github.com/naveenanimation20/DEC2019POMSeries"
		}
	stage ('Build'){
    	dir("Dec2019POMSeries") {
	   sh "mvn clean install"
       }
       	dir("Dec2019POMSeries/target") {
	   sh "java -jar Dec2019POMSeries-0.0.1-SNAPSHOT.jar"
       }
		}
}