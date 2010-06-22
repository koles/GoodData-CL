/*
 * Copyright (c) 2009 GoodData Corporation.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Redistributions in any form must be accompanied by information on
 *    how to obtain complete source code for this software and any
 *    accompanying software that uses this software.  The source code
 *    must either be included in the distribution or be available for no
 *    more than the cost of distribution plus a nominal fee, and must be
 *    freely redistributable under reasonable conditions.  For an
 *    executable file, complete source code means the source code for all
 *    modules it contains.  It does not include source code for modules or
 *    files that typically accompany the major components of the operating
 *    system on which the executable file runs.
 *
 * THIS SOFTWARE IS PROVIDED BY GOODDATA ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR
 * NON-INFRINGEMENT, ARE DISCLAIMED.  IN NO EVENT SHALL ORACLE BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
 * BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN
 * IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * DescribeTab.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sforce.soap.partner;

public class DescribeTab  implements java.io.Serializable {
    private boolean custom;

    private String iconUrl;

    private String label;

    private String miniIconUrl;

    private String sobjectName;

    private String url;

    public DescribeTab() {
    }

    public DescribeTab(
           boolean custom,
           String iconUrl,
           String label,
           String miniIconUrl,
           String sobjectName,
           String url) {
           this.custom = custom;
           this.iconUrl = iconUrl;
           this.label = label;
           this.miniIconUrl = miniIconUrl;
           this.sobjectName = sobjectName;
           this.url = url;
    }


    /**
     * Gets the custom value for this DescribeTab.
     * 
     * @return custom
     */
    public boolean isCustom() {
        return custom;
    }


    /**
     * Sets the custom value for this DescribeTab.
     * 
     * @param custom
     */
    public void setCustom(boolean custom) {
        this.custom = custom;
    }


    /**
     * Gets the iconUrl value for this DescribeTab.
     * 
     * @return iconUrl
     */
    public String getIconUrl() {
        return iconUrl;
    }


    /**
     * Sets the iconUrl value for this DescribeTab.
     * 
     * @param iconUrl
     */
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }


    /**
     * Gets the label value for this DescribeTab.
     * 
     * @return label
     */
    public String getLabel() {
        return label;
    }


    /**
     * Sets the label value for this DescribeTab.
     * 
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
    }


    /**
     * Gets the miniIconUrl value for this DescribeTab.
     * 
     * @return miniIconUrl
     */
    public String getMiniIconUrl() {
        return miniIconUrl;
    }


    /**
     * Sets the miniIconUrl value for this DescribeTab.
     * 
     * @param miniIconUrl
     */
    public void setMiniIconUrl(String miniIconUrl) {
        this.miniIconUrl = miniIconUrl;
    }


    /**
     * Gets the sobjectName value for this DescribeTab.
     * 
     * @return sobjectName
     */
    public String getSobjectName() {
        return sobjectName;
    }


    /**
     * Sets the sobjectName value for this DescribeTab.
     * 
     * @param sobjectName
     */
    public void setSobjectName(String sobjectName) {
        this.sobjectName = sobjectName;
    }


    /**
     * Gets the url value for this DescribeTab.
     * 
     * @return url
     */
    public String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this DescribeTab.
     * 
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof DescribeTab)) return false;
        DescribeTab other = (DescribeTab) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.custom == other.isCustom() &&
            ((this.iconUrl==null && other.getIconUrl()==null) || 
             (this.iconUrl!=null &&
              this.iconUrl.equals(other.getIconUrl()))) &&
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
            ((this.miniIconUrl==null && other.getMiniIconUrl()==null) || 
             (this.miniIconUrl!=null &&
              this.miniIconUrl.equals(other.getMiniIconUrl()))) &&
            ((this.sobjectName==null && other.getSobjectName()==null) || 
             (this.sobjectName!=null &&
              this.sobjectName.equals(other.getSobjectName()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += (isCustom() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getIconUrl() != null) {
            _hashCode += getIconUrl().hashCode();
        }
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
        }
        if (getMiniIconUrl() != null) {
            _hashCode += getMiniIconUrl().hashCode();
        }
        if (getSobjectName() != null) {
            _hashCode += getSobjectName().hashCode();
        }
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DescribeTab.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "DescribeTab"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("custom");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "custom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iconUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "iconUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("miniIconUrl");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "miniIconUrl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sobjectName");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "sobjectName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:partner.soap.sforce.com", "url"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
