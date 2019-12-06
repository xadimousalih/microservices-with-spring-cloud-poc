# microservices-with-spring-cloud-poc
Implementation of a microservices architecture with spring cloud components by xadimouSALIH

1. Start **spring-cloud-config-server** which is the Spring cloud Bus embedded a git repository that centralize all project configurations

2. Start **config-management-service** microservice which manage configurations

3. Start **eureka-naming-and-discovery-server** the naming and discovery serveur with eureka

4. Start **declaration-timbre-service** a business microservice to declare a tax

5. Start **paiement-timbre-service** a business microservice to pay declared tax

6. Start **zuul-api-gateway-server** representing the api gateway of this POC

