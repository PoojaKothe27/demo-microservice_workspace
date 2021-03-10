# demo-microservice_workspace

12 Factor

Codebase

You can use GitHub repositories to provide a dedicated codebase per microservice so that each microservice can have its own release schedule.

Dependencies

Instead of packaging the third-party libraries inside your microservice, specify your dependencies in your Maven pom.xml or Gradle settings.gradle file. This enables you to freely move up to newer versions.

Config

Configuration is one of the most important factors. The golden rule of developing microservices is to write once, configure everywhere. When changing configuration, you don’t want to repackage your microservices. The way to achieve this is to externalise the configuration from the microservice application code. MicroProfile Config enables you to place configuration in properties files that can be easily updated without recompiling your microservices.

Backing services

Treat backing services as attached resources. They should be configurable so that you can easily switch the attached resource by just changing the configuration. Again, MicroProfile Config can help here.

Build, release, run

Separate the build, release, and run stages. Seriously.

Processes

Microservices should be stateless. REST is a well adopted transport protocol, and JAX-RS can be used to achieve a RESTful architecture. Systems that follow the REST paradigm are stateless. In this way, underlying infrastructure can destroy or create new microservices without losing any information.

Port binding

Export services using port binding. In the world of microservices, it is common that microservices talk to each other. When deploying them in the cloud, the ports need to change, so it is important to have a way to rebind the port. MicroProfile Config can help this. You can specify the new port in Kubernetes ConfigMap, and MicroProfile Config automatically picks up the value to give the correct info to the deployed microservices. MicroProfile Rest Client can help with creating client code to connect from one microservice to another.

Concurrency

The microservices should be able to be scaled up or down, depending on the workload. Kubernetes autoscaler can help with this.

Disposability

Microservices should be robust but gracefully shut down when necessary. Microservices should be fault tolerant and able to function under any situation. MicroProfile Fault Tolerance can help out with this. They should also, however, be treated like cattle, not pets: without identity and be replaceable. If a microservice process is not healthy, underlying cloud infrastructure should be able to directly kill it and quickly start a new one.

Dev/prod parity

The best practice of operating on microservices is keeping development, staging, and production environments as similar as possible. Docker images are here to ensure that the environments stay the same so that you don’t run into the problem of “it runs on my laptop".

Logs

Treat logs as event streams. You should stream out logs in real time so that killing an instance does not cause logs to go missing.

Admin processes

Do not put one-off admin process inside your microservices; run them as Kubernetes tasks instead. In this way, your microservices can focus on business logic.



Application start flow :

ServiceRegistry
ServerConfig
APIGateway
Histrix Dashboard
All microservices


For log Tracing we are using the Zipkin and sluth
C:\Users\ab93923\Documents\microservice_workspace>java -jar zipkin-server-2.23.2-exec.jar
Copy and past the http://127.0.0.1:9411/ on browser we can see the zipkin server activities.

Refer : https://www.youtube.com/watch?v=BnknNTN8icw : Microservices using SpringBoot | Full Example
