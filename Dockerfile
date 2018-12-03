FROM tomcat:8-jre8

COPY ./target/beleza-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/beleza.war


CMD ["catalina.sh", "run"]
