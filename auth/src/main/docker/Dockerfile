FROM rceledon/java:8.0.111

MAINTAINER Roberto Celedon <roberto.celedon.a@gmail.com>

#ADD ./lib/* /lib/
ADD auth-0.0.1.jar /usr/local/app/pkto-back/app.jar

#RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/usr/local/app/pkto-back/app.jar"]
