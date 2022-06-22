#!/bin/sh

echo "##################################"
echo "###         FOUNDATION         ###"
echo "##################################"

echo ${PATH_LOG_FILE}
echo ${JAVA_OPTS}
exec java -jar /home/foundation/app.jar -Dcom.sun.management.jmxremote $@
