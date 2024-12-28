 #!/usr/bin/env bash


 error_exit ()
 {
     echo "ERROR: $1 !!"
     exit 1
 }
 

echo "JAVA_HOME: ${JAVA_HOME}"
export JAVA_HOME
CLASSPATH="${JAVA_HOME}/lib/tools.jar:${JAVA_HOME}/lib/dt.jar"
export CLASSPATH

echo "CLASSPATH: ${CLASSPATH}"