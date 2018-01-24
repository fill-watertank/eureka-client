#eureka-client

Simple ms springBoot app to demonstrate profiled instances, negotiating through service discovery (#eureka-service).


Run instructions:

#eureka-service must be up and running (http://localhost:8761/)

gradle clean assemble

java -jar -Dspring.profiles.active=demo-subject build/libs/eureka-client-0.0.1-SNAPSHOT.jar
java -jar -Dspring.profiles.active=demo-verb build/libs/eureka-client-0.0.1-SNAPSHOT.jar
java -jar -Dspring.profiles.active=demo-article build/libs/eureka-client-0.0.1-SNAPSHOT.jar
java -jar -Dspring.profiles.active=demo-adjective build/libs/eureka-client-0.0.1-SNAPSHOT.jar
java -jar -Dspring.profiles.active=demo-noun build/libs/eureka-client-0.0.1-SNAPSHOT.jar
java -jar build/libs/eureka-service-0.0.1-SNAPSHOT.jar

Check URL: http://localhost:8085/api/sentence/say


