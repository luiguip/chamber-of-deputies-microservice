//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.07 at 10:41:04 AM BRT 
//


package com.github.luiguip.chamber_of_deputies_service.infrastructure.deputies.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idBloco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numLegislatura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idBloco",
    "numLegislatura"
})
@XmlRootElement(name = "ObterPartidosBlocoCD")
public class ObterPartidosBlocoCD {

    protected String idBloco;
    protected String numLegislatura;

    /**
     * Gets the value of the idBloco property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdBloco() {
        return idBloco;
    }

    /**
     * Sets the value of the idBloco property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdBloco(String value) {
        this.idBloco = value;
    }

    /**
     * Gets the value of the numLegislatura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumLegislatura() {
        return numLegislatura;
    }

    /**
     * Sets the value of the numLegislatura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumLegislatura(String value) {
        this.numLegislatura = value;
    }

}
