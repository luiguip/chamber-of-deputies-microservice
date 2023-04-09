package com.github.luiguip.chamber_of_deputies_service.infrastructure.mapper;

import com.github.luiguip.chamber_of_deputies_service.domain.exception.InfrastructureException;
import com.github.luiguip.chamber_of_deputies_service.domain.model.CongressPerson;
import com.github.luiguip.chamber_of_deputies_service.domain.model.Person;
import com.github.luiguip.chamber_of_deputies_service.infrastructure.deputados.model.wsdl.ObterDeputadosResponse;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Mapper(componentModel = ComponentModel.SPRING)
public interface CongressPersonMapper {

  default List<CongressPerson> toDomain(ObterDeputadosResponse response)
      throws InfrastructureException {
    var deputadosRoot = (Node) response.getObterDeputadosResult()
        .getContent()
        .stream()
        .findFirst()
        .orElseThrow(() -> new InfrastructureException("ObterDeputadosResult content can't be empty"));
    var deputadosNodes = deputadosRoot.getChildNodes();
    return toDomain(deputadosNodes);
  }

  private List<CongressPerson> toDomain(NodeList deputadosNodes) {
    return IntStream.range(0, deputadosNodes.getLength())
        .mapToObj(deputadosNodes::item)
        .map(this::toDomain)
        .toList();
  }

  private CongressPerson toDomain(Node node) {
    var nodeFields = node.getChildNodes();
    var fields = IntStream.range(0, nodeFields.getLength())
        .mapToObj(nodeFields::item)
        .filter(n -> !"comissoes".equals(n.getNodeName()))
        .map(this::extractEntry)
        .flatMap(Optional::stream)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    return toDomain(fields);
  }

  private Optional<Map.Entry<String, String>> extractEntry(Node node) {
    var key = node.getNodeName();
    var nodes = node.getChildNodes();
    if ("codOrcamento".equals(node.getNodeName()) && nodes.getLength() == 0) {
      return Optional.empty();
    }
    var value = nodes
        .item(0)
        .getNodeValue();
    return Optional.of(Map.entry(key, value));
  }

  private CongressPerson toDomain(Map<String, String> fields) {
    var name = fields.get("nome");
    var sex = fields.get("sexo");
    var phone = fields.get("fone");
    var email = fields.get("email");
    var person = new Person(name, sex, phone, email);

    var id = Long.valueOf(fields.get("ideCadastro"));
    var uf = fields.get("uf");
    var politicalParty = fields.get("partido");
    return new CongressPerson(id, person, uf, politicalParty);
  }
}
