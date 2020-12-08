package com.lhzn.soft.webcli;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class WebCliTest {

    @Resource
    private AmqpTemplate amqpTemplate;

    @Test
    void selectBySessionId() {
        String stringXml = "<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"?>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<GATHER_INFO>\\n\" +\n" +
                "                \"  <I_E_FLAG>I</I_E_FLAG>\\n\" +\n" +
                "                \"  <AREA_ID>0</AREA_ID>\\n\" +\n" +
                "                \"  <CHNL_NO>CNGQD070003WI01</CHNL_NO>\\n\" +\n" +
                "                \"  <CUS_CODE>0808</CUS_CODE>\\n\" +\n" +
                "                \"  <SESSION_ID>003WI0120200720103842</SESSION_ID>\\n\" +\n" +
                "                \"  <RPB_TYPE>1</RPB_TYPE>\\n\" +\n" +
                "                \"  <IC_INFO>\\n\" +\n" +
                "                \"    <IC_ID>1000</IC_ID>\\n\" +\n" +
                "                \"    <IC_NO>1000</IC_NO>\\n\" +\n" +
                "                \"    <IC_Type>2000</IC_Type>\\n\" +\n" +
                "                \"    <IC_EXTENDED_CONTENT>30000</IC_EXTENDED_CONTENT>\\n\" +\n" +
                "                \"  </IC_INFO>\\n\" +\n" +
                "                \"  <DR_CUSTOMS_NO></DR_CUSTOMS_NO>\\n\" +\n" +
                "                \"  <VE_CUSTOMS_NO></VE_CUSTOMS_NO>\\n\" +\n" +
                "                \"  <VE_LICENSE_NO>辽A80637</VE_LICENSE_NO>\\n\" +\n" +
                "                \"  <CONTA_ID></CONTA_ID>\\n\" +\n" +
                "                \"  <ESEAL_ID></ESEAL_ID>\\n\" +\n" +
                "                \"  <GROSS_WT>25000</GROSS_WT>\\n\" +\n" +
                "                \"  <VE_RFID>\\n\" +\n" +
                "                \"    <RFID_ID>20</RFID_ID>\\n\" +\n" +
                "                \"    <VE_LICENSE_NO>3000</VE_LICENSE_NO>\\n\" +\n" +
                "                \"    <VE_CUSTOMS_NO></VE_CUSTOMS_NO>\\n\" +\n" +
                "                \"    <VE_WT>5000</VE_WT>\\n\" +\n" +
                "                \"    <VE_COMPANY></VE_COMPANY>\\n\" +\n" +
                "                \"    <VE_PERFORMANCE></VE_PERFORMANCE>\\n\" +\n" +
                "                \"  </VE_RFID>\\n\" +\n" +
                "                \"  <FORM_INFO>\\n\" +\n" +
                "                \"    <FORM_TYPE>10</FORM_TYPE>\\n\" +\n" +
                "                \"    <FORM_ID>100</FORM_ID>\\n\" +\n" +
                "                \"  </FORM_INFO>\\n\" +\n" +
                "                \"  <DR_RFID>\\n\" +\n" +
                "                \"    <RFID_ID>10</RFID_ID>\\n\" +\n" +
                "                \"    <DR_NAME>宋老板</DR_NAME>\\n\" +\n" +
                "                \"    <DR_CUSTOMS_NO>20</DR_CUSTOMS_NO>\\n\" +\n" +
                "                \"    <DR_COMPANY>辽中</DR_COMPANY>\\n\" +\n" +
                "                \"    <DR_PERFORMANCE>1000</DR_PERFORMANCE>\\n\" +\n" +
                "                \"  </DR_RFID>\\n\" +\n" +
                "                \"  <PHOTO>\\n\" +\n" +
                "                \"    <PHOTO_GUID>3000</PHOTO_GUID>\\n\" +\n" +
                "                \"    <PHOTO_PERSPECTIVE>40000</PHOTO_PERSPECTIVE>\\n\" +\n" +
                "                \"  </PHOTO>\\n\" +\n" +
                "                \"  <OPERATOR_ID></OPERATOR_ID>\\n\" +\n" +
                "                \"  <OPERATE_TIME></OPERATE_TIME>\\n\" +\n" +
                "                \"  <EXTEND>\\n\" +\n" +
                "                \"    <NAME>100</NAME>\\n\" +\n" +
                "                \"    <VALUE>200</VALUE>\\n\" +\n" +
                "                \"  </EXTEND>\\n\" +\n" +
                "                \"  <CONTA_RECOGNITION>\\n\" +\n" +
                "                \"    <CONTA_ID>10</CONTA_ID>\\n\" +\n" +
                "                \"    <CONTA_TYPE>20</CONTA_TYPE>\\n\" +\n" +
                "                \"    <CONTA_LOCK>n</CONTA_LOCK>\\n\" +\n" +
                "                \"    <CONFIDENCE_RATIO></CONFIDENCE_RATIO>\\n\" +\n" +
                "                \"  </CONTA_RECOGNITION>\\n\" +\n" +
                "                \"  <VE_LICENSE_RECOGNITION>\\n\" +\n" +
                "                \"    <DOMESTIC_LICENSE_NO>20</DOMESTIC_LICENSE_NO>\\n\" +\n" +
                "                \"    <DOMESTIC_LICENSE_COLOR>红色</DOMESTIC_LICENSE_COLOR>\\n\" +\n" +
                "                \"    <FOREIGN_LICENSE_NO>30</FOREIGN_LICENSE_NO>\\n\" +\n" +
                "                \"    <FOREIGN_LICENSE_COLOR>yellow</FOREIGN_LICENSE_COLOR>\\n\" +\n" +
                "                \"    <CONFIDENCE_RATIO>y</CONFIDENCE_RATIO>\\n\" +\n" +
                "                \"  </VE_LICENSE_RECOGNITION>\\n\" +\n" +
                "                \"</GATHER_INFO>\\n";
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("locationId","12345678888");
        messageProperties.setContentType("text/plain");
        messageProperties.setContentEncoding("UTF-8");
        Message message = new Message(stringXml.getBytes(), messageProperties);
        amqpTemplate.convertAndSend("test-01", message);
    }
}