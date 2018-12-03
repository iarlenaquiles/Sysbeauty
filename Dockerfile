FROM tomcat:8-jre8

RUN echo "export JAVA_OPTS=\"-Dapp.env=staging\"" > /usr/local/tomcat/bin/setenv.sh
COPY ./target/beleza-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/beleza.war


CMD ["catalina.sh", "run"]
