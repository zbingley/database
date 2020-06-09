FROM java:8
WORKDIR /database
ADD *.jar ./app.jar
EXPOSE 8080
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -Duser.timezone=GMT+08 -Dfile.encoding=UTF-8 -server -Xverify:none  -jar  ${jvmoptions}  database.jar --spring.profiles.active=${profile}
