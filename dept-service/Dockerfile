FROM openjdk:8-jre-alpine
LABEL maintainer=me
ENV JAVA_ARGS="-Dfile.encoding=UTF8 -Duser.timezone=GMT+08"
ENV JAR_FILE="dept-service.jar"
COPY ./target/${JAR_FILE} ./
EXPOSE 8020
CMD java -jar ${JAVA_ARGS} ${JAVA_OPTS} /${JAR_FILE}
