FROM openjdk:8-jre-alpine
LABEL maintainer=me
ENV JAVA_ARGS="-Dfile.encoding=UTF8 -Duser.timezone=GMT+08"
ENV JAR_FILE="gateway-service.jar"
COPY ./${JAR_FILE} ./
EXPOSE 9999
CMD java -jar ${JAVA_ARGS} ${JAVA_OPTS} /${JAR_FILE}