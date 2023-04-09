package com.github.luiguip.chamber_of_deputies_service.config;


import com.github.luiguip.chamber_of_deputies_service.infrastructure.deputados.client.DeputadosClient;
import com.github.luiguip.chamber_of_deputies_service.infrastructure.deputados.model.wsdl.ObjectFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WsdlConfig {

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    // this package must match the package in the <generatePackage> specified in
    // pom.xml
    marshaller.setContextPath("com.github.luiguip.chamber_of_deputies_service.infrastructure.deputies.wsdl");
    return marshaller;
  }

  @Bean
  public DeputadosClient deputiesClient(Jaxb2Marshaller marshaller, ObjectFactory objectFactory) {
    DeputadosClient client = new DeputadosClient(objectFactory);
    client.setDefaultUri("https://www.camara.leg.br/SitCamaraWS/Deputados.asmx");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
  }

  @Bean
  public ObjectFactory objectFactory() {
    return new ObjectFactory();
  }
}
