package com.github.luiguip.chamber_of_deputies_service.infrastructure.deputados.client;

import com.github.luiguip.chamber_of_deputies_service.domain.exception.InfrastructureException;
import com.github.luiguip.chamber_of_deputies_service.infrastructure.deputados.model.wsdl.ObjectFactory;
import com.github.luiguip.chamber_of_deputies_service.infrastructure.deputados.model.wsdl.ObterDeputados;
import com.github.luiguip.chamber_of_deputies_service.infrastructure.deputados.model.wsdl.ObterDeputadosResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.oxm.XmlMappingException;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

@Slf4j
@RequiredArgsConstructor
public class DeputadosClient extends WebServiceGatewaySupport {

  private final ObjectFactory objectFactory;

  public ObterDeputadosResponse findDeputados() throws InfrastructureException {

    try {
      ObterDeputados request = objectFactory.createObterDeputados();

      return (ObterDeputadosResponse) getWebServiceTemplate()
          .marshalSendAndReceive(request, message ->
              ((SoapMessage) message).setSoapAction(
                  "https://www.camara.gov.br/SitCamaraWS/Deputados/ObterDeputados"));
    } catch (XmlMappingException | WebServiceClientException e) {
      throw new InfrastructureException(e);
    }  catch (RuntimeException e) {
      throw new InfrastructureException("Unexpected client Exception", e);
    }
  }
}
