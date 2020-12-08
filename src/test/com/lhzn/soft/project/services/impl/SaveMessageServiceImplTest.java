package com.lhzn.soft.project.services.impl;

import com.lhzn.soft.project.domain.MessageHistory;
import com.lhzn.soft.project.services.SaveMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
@SpringBootTest
@RunWith(SpringRunner.class)
class SaveMessageServiceImplTest {
    @Resource
    private SaveMessageService service;
    @Test
    void insertMessage() {
        MessageHistory mh = new MessageHistory();
        mh.setLocationId("121121");
        mh.setQueueName("测试");
        mh.setBody("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "\n" +
                "<GATHER_INFO>\n" +
                "  <I_E_FLAG>I</I_E_FLAG>\n" +
                "  <AREA_ID>0</AREA_ID>\n" +
                "  <CHNL_NO>CNGQD070003WI01</CHNL_NO>\n" +
                "  <CUS_CODE>0808</CUS_CODE>\n" +
                "  <SESSION_ID>003WI0120200720103842</SESSION_ID>\n" +
                "  <RPB_TYPE>1</RPB_TYPE>\n" +
                "  <IC_INFO>\n" +
                "    <IC_ID>1000</IC_ID>\n" +
                "    <IC_NO>1000</IC_NO>\n" +
                "    <IC_Type>2000</IC_Type>\n" +
                "    <IC_EXTENDED_CONTENT>30000</IC_EXTENDED_CONTENT>\n" +
                "  </IC_INFO>\n" +
                "  <DR_CUSTOMS_NO></DR_CUSTOMS_NO>\n" +
                "  <VE_CUSTOMS_NO></VE_CUSTOMS_NO>\n" +
                "  <VE_LICENSE_NO>辽A80637</VE_LICENSE_NO>\n" +
                "  <CONTA_ID></CONTA_ID>\n" +
                "  <ESEAL_ID></ESEAL_ID>\n" +
                "  <GROSS_WT>25000</GROSS_WT>\n" +
                "  <VE_RFID>\n" +
                "    <RFID_ID>20</RFID_ID>\n" +
                "    <VE_LICENSE_NO>3000</VE_LICENSE_NO>\n" +
                "    <VE_CUSTOMS_NO></VE_CUSTOMS_NO>\n" +
                "    <VE_WT>5000</VE_WT>\n" +
                "    <VE_COMPANY></VE_COMPANY>\n" +
                "    <VE_PERFORMANCE></VE_PERFORMANCE>\n" +
                "  </VE_RFID>\n" +
                "  <FORM_INFO>\n" +
                "    <FORM_TYPE>10</FORM_TYPE>\n" +
                "    <FORM_ID>100</FORM_ID>\n" +
                "  </FORM_INFO>\n" +
                "  <DR_RFID>\n" +
                "    <RFID_ID>10</RFID_ID>\n" +
                "    <DR_NAME>宋老板</DR_NAME>\n" +
                "    <DR_CUSTOMS_NO>20</DR_CUSTOMS_NO>\n" +
                "    <DR_COMPANY>辽中</DR_COMPANY>\n" +
                "    <DR_PERFORMANCE>1000</DR_PERFORMANCE>\n" +
                "  </DR_RFID>\n" +
                "  <PHOTO>\n" +
                "    <PHOTO_GUID>3000</PHOTO_GUID>\n" +
                "    <PHOTO_PERSPECTIVE>40000</PHOTO_PERSPECTIVE>\n" +
                "  </PHOTO>\n" +
                "  <OPERATOR_ID></OPERATOR_ID>\n" +
                "  <OPERATE_TIME></OPERATE_TIME>\n" +
                "  <EXTEND>\n" +
                "    <NAME>100</NAME>\n" +
                "    <VALUE>200</VALUE>\n" +
                "  </EXTEND>\n" +
                "  <CONTA_RECOGNITION>\n" +
                "    <CONTA_ID>10</CONTA_ID>\n" +
                "    <CONTA_TYPE>20</CONTA_TYPE>\n" +
                "    <CONTA_LOCK>n</CONTA_LOCK>\n" +
                "    <CONFIDENCE_RATIO></CONFIDENCE_RATIO>\n" +
                "  </CONTA_RECOGNITION>\n" +
                "  <VE_LICENSE_RECOGNITION>\n" +
                "    <DOMESTIC_LICENSE_NO>20</DOMESTIC_LICENSE_NO>\n" +
                "    <DOMESTIC_LICENSE_COLOR>红色</DOMESTIC_LICENSE_COLOR>\n" +
                "    <FOREIGN_LICENSE_NO>30</FOREIGN_LICENSE_NO>\n" +
                "    <FOREIGN_LICENSE_COLOR>yellow</FOREIGN_LICENSE_COLOR>\n" +
                "    <CONFIDENCE_RATIO>y</CONFIDENCE_RATIO>\n" +
                "  </VE_LICENSE_RECOGNITION>\n" +
                "</GATHER_INFO>\n");
        service.insertMessage(mh);
    }
}