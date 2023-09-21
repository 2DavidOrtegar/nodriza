pipeline {
    environment{
            done = null
            doneLength = null
            doneTwo = null
            doneTwoLength = null
            doneThree = null
            doneThreeLength = null
            doneFour = null
            doneFourLength = null
        }
    agent any
    stages {
        stage('Clean Build') {
            steps {
                sh 'chmod +x gradlew'
                
                script{
                    result=0
                }
            }
        }
        stage('Regression Low') {
            steps
            {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE')
                {
                    sh './gradlew regressionLowTag'
                }
                script
                {
                    def strCurl = "curl -X GET -u davidortega:1125a696a94e951d78b2693fc0394191bc http://jenkinsqa.ddns.net:9292/job/QA/job/Mobile%20Automation/${env.BUILD_NUMBER}/consoleText";
                    def response = sh (script: strCurl, returnStdout: true);
                    int firstUrl = response.substring(0, response.indexOf("https://reports.cucumber.io/reports/")).length();
                    doneLength=firstUrl+72;
                    done = response.substring(firstUrl, firstUrl+72);
                    env.done = done;
                }
            }
        }
        stage('Regression Middle')
        {
            steps
            {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE')
                {
                    sh './gradlew regressionMiddleTag'
                }
                    script
                    {
                        def strCurl = "curl -X GET -u davidortega:1125a696a94e951d78b2693fc0394191bc http://jenkinsqa.ddns.net:9292/job/QA/job/Mobile%20Automation/${env.BUILD_NUMBER}/consoleText";
                        def response = sh (script: strCurl, returnStdout: true);
                        def response2 = response.substring("${doneLength}".toInteger(), response.length());;
                        int secondUrl = response2.substring(0, response2.indexOf("https://reports.cucumber.io/reports/")).length();
                        doneTwoLength=secondUrl+72;
                        doneTwo = response2.substring(secondUrl, secondUrl+72);
                        env.doneTwo = doneTwo;
                    }

            }
        }
         stage('Regression High')
         {
            steps
            {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE')
                {
                    sh './gradlew regressionHighTag'
                    script{result=1}
                }
                script
                {
                    def strCurl = "curl -X GET -u davidortega:1125a696a94e951d78b2693fc0394191bc http://jenkinsqa.ddns.net:9292/job/QA/job/Mobile%20Automation/${env.BUILD_NUMBER}/consoleText";
                    def response = sh (script: strCurl, returnStdout: true);

                    def suma = "${doneLength}".toInteger()+"${doneTwoLength}".toInteger();
                    def response2 = response.substring(suma, response.length());
                    int thirdUrl = response2.substring(0, response2.indexOf("https://reports.cucumber.io/reports/")).length();
                    doneThreeLength=thirdUrl+72;
                    doneThree = response2.substring(thirdUrl, thirdUrl+72);
                    env.doneThree = doneThree;
                }

            }
         }


         stage('Regression Very High')
         {
             steps
             {
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE')
                    {
                        script
                          {
                            if(result==1)
                            {
                                sh './gradlew regressionVeryHighTag'
                            }else{
                                echo "Se detiene Pipeline ejecucion fallo en estado ALTO"
                                sh 'exit 1';
                            }
                          }
                    }
                 script
                 {

                    if(result==1)
                    {
                        def strCurl = "curl -X GET -u davidortega:1125a696a94e951d78b2693fc0394191bc http://jenkinsqa.ddns.net:9292/job/QA/job/Mobile%20Automation/${env.BUILD_NUMBER}/consoleText";
                       def response = sh (script: strCurl, returnStdout: true);
                       def suma = "${doneLength}".toInteger()+"${doneTwoLength}".toInteger()+"${doneThreeLength}".toInteger();
                       def response2 = response.substring(suma, response.length());
                       int fourthUrl = response2.substring(0, response2.indexOf("https://reports.cucumber.io/reports/")).length();
                       doneFourLength=fourthUrl+72
                       doneFour = response2.substring(fourthUrl, fourthUrl+72);
                       env.doneFour = doneFour

                       def resultTask = response.indexOf("Task :regressionVeryHighTag FAILED");
                       if(resultTask>0){
                            echo "Se detiene Pipeline ejecucion fallo en estado MUY ALTO"
                            sh 'exit 1';
                       }
                    }else{
                        echo "Se detiene Pipeline ejecucion fallo en estado ALTO"
                        sh 'exit 1';
                    }
                 }
             }
        }
    }


  post {
  success {
        echo 'Sucesss Pipeline!!'
        echo "Result Regression Low: ${done}"
        echo "Result Regression Middle: ${doneTwo}"
        echo "Result Regression High: ${doneThree}"
        echo "Result Regression Very High: ${doneFour}"
      }

    unstable {
     echo 'Unsucessful Pipeline!!'
     echo "Result Regression Low: ${done}"
     echo "Result Regression Middle: ${doneTwo}"
     echo "Result Regression High: ${doneThree}"
     echo "Result Regression Very High: ${doneFour}"
    }
    failure {
     echo 'FAILURE Pipeline!!'
     echo "Result Regression Low: ${done}"
     echo "Result Regression Middle: ${doneTwo}"
     echo "Result Regression High: ${doneThree}"
     echo "Result Regression Very High: ${doneFour}"
    }
    aborted {
     echo 'aborted Pipeline!!'
     echo "Result Regression Low: ${done}"
     echo "Result Regression Middle: ${doneTwo}"
     echo "Result Regression High: ${doneThree}"
     echo "Result Regression Very High: ${doneFour}"
    }
    always {
      echo 'Limpiando espacio de trabajo....'
    }
  }
}
