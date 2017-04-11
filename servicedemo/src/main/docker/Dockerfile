FROM java:8
VOLUME /tmp
ADD servicedemo-0.1.0.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 7777
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
