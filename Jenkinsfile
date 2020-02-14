node {
	stage ('SCM checkout'){
		git "https://github.com/naveenanimation20/DEC2019POMSeries"
		}
	stage ('Build'){
    	dir("DempPipeLine") {
	   sh "mvn clean install"
       }
       	dir("DempPipeLine/target") {
	   sh "java -jar Dec2019POMSeries-0.0.1-SNAPSHOT.jar"
       }
		}
}