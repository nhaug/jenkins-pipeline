import com.jenkins.*
    
def call (body) {
    LinkedHashMap config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    
    pipeline {
        agent { label "nhaug" }
        stages {
            stage ("helloWorld") {
                steps {
                    script {
                        echo ${config.name}
                        def lib = new HelloWorld()
                        lib.helloWorld(this)
                    }
                }
            }
            stage("cleanup") {
                steps {
                    echo "Vor clean"
                    sh "ls -al"
                    cleanWs()
                    echo "Nach Clean"
                    sh "pwd"
                    sh "ls -al"
                }
            }
            stage("checkout") {
                steps {
                    echo "jetzt muss checkout erfolgen"
                }
            }
            stage("start") {
                steps {
                    echo "jetzt wirklich"
                }
            }
            stage("build") {
                steps {
                    echo "build"
                    sh '''
                      cp *.py 
                    '''
                }
            }
            stage("archive") {
                steps {
                    echo "jetzt das Archive hochladen"
                }
            }
        }
        post {
            always {
                sh 'printenv'
            }
        }
    }
}
