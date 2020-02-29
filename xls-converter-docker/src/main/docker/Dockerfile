FROM openjdk:8u212-jre-alpine

EXPOSE 8080

ENV HEALTHCHECK_URL="http://localhost:8080/actuator/health"
HEALTHCHECK \
  --interval=5s \
  --timeout=3s \
  --start-period=10s \
  --retries=5 \
  CMD curl -f $HEALTHCHECK_URL || exit 1

ENV SERVICE_NAME=xls-converter
COPY ./xls-converter-application/target/xls-converter-application-*-uberjar.jar /opt/service/lib/$SERVICE_NAME.jar

ENV BASE_JAVA_ARGS="-XshowSettings:vm -XX:+PrintCommandLineFlags -XX:MaxRAMPercentage=50.0"
CMD java $BASE_JAVA_ARGS $SERVICE_JAVA_ARGS -jar /opt/service/lib/$SERVICE_NAME.jar