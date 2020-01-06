#This is the base.
FROM java:8

#This is the port.
EXPOSE 8015:8015

#No idea
ADD /target/TermAccountJar.jar TermAccountJar.jar

#No idea
ENTRYPOINT ["java", "-jar", "TermAccountJar.jar"]