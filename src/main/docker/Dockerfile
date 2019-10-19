FROM docker.io/java:8
WORKDIR /database
ADD *.jar database.jar
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -Duser.timezone=GMT+08 -Dfile.encoding=UTF-8 -server -Xverify:none  -jar  ${jvmoptions}  database.jar --spring.profiles.active=${profile}
