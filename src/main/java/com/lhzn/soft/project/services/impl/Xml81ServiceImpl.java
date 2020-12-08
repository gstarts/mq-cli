package com.lhzn.soft.project.services.impl;

import com.lhzn.soft.project.domain.GatherdataLog;
import com.lhzn.soft.project.services.Xml81Service;
import com.lhzn.soft.utils.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;

@Service
public class Xml81ServiceImpl implements Xml81Service {

    @Value("${station.CustomsMaster}")
    private String CustomsMaster;

    @Value("${station.RpbType}")
    private String RpbType;

    @Override
    public String create81Xml(GatherdataLog gatherdataLog) {


        // 创建一个Document实例
        Document doc = DocumentHelper.createDocument();

        // 添加根节点
        Element root = doc.addElement("GATHER_INFO");
        root.addElement("I_E_FLAG").addText(StringUtils.replaceNullString(gatherdataLog.getIEFlag()));

        root.addElement("AREA_ID").addText(StringUtils.replaceNullString(gatherdataLog.getAreaId()));

        root.addElement("CHNL_NO").addText(StringUtils.replaceNullString(gatherdataLog.getChnlNo()));


        root.addElement("CUS_CODE").addText(StringUtils.replaceNullString(CustomsMaster));

        root.addElement("SESSION_ID").addText(StringUtils.replaceNullString(gatherdataLog.getSessionId()));

        root.addElement("RPB_TYPE").addText(StringUtils.replaceNullString(RpbType));


        // 在根节点下添加第一个子节点
        Element oneChildElement = root.addElement("IC_INFO");
        oneChildElement.addElement("IC_ID")
                .addText(StringUtils.replaceNullString(gatherdataLog.getIcInfo().getIcId()));
        oneChildElement.addElement("IC_NO")
                .addText(StringUtils.replaceNullString(gatherdataLog.getIcInfo().getIcNo()));
        oneChildElement.addElement("IC_Type")
                .addText(StringUtils.replaceNullString(gatherdataLog.getIcInfo().getIcType()));
        oneChildElement.addElement("IC_EXTENDED_CONTENT")
                .addText(StringUtils.replaceNullString(gatherdataLog.getIcInfo().getIcExtendedContent()));


        root.addElement("DR_CUSTOMS_NO").addText(StringUtils.replaceNullString(gatherdataLog.getDrCustomsNo()));
        root.addElement("VE_CUSTOMS_NO").addText(StringUtils.replaceNullString(gatherdataLog.getVeCustomsNo()));
        root.addElement("VE_LICENSE_NO").addText(StringUtils.replaceNullString(gatherdataLog.getVeLicenseNo()));
        root.addElement("CONTA_ID").addText(StringUtils.replaceNullString(gatherdataLog.getContaId()));
        root.addElement("ESEAL_ID").addText(StringUtils.replaceNullString(gatherdataLog.getEsealId()));
        root.addElement("GROSS_WT").addText(StringUtils.replaceNullString(gatherdataLog.getGrossWt()));


        // 在根节点下添加第一个子节点
        Element twoChildElement = root.addElement("VE_RFID");
        twoChildElement.addElement("RFID_ID")
                .addText(StringUtils.replaceNullString(gatherdataLog.getVeRfid().getRfidId()));
        twoChildElement.addElement("VE_LICENSE_NO")
                .addText(StringUtils.replaceNullString(gatherdataLog.getVeRfid().getVeLicenseNo()));
        twoChildElement.addElement("VE_CUSTOMS_NO")
                .addText(StringUtils.replaceNullString(gatherdataLog.getVeRfid().getVeCustomsNo()));
        twoChildElement.addElement("VE_WT")
                .addText(StringUtils.replaceNullString(gatherdataLog.getVeRfid().getVeWt()));
        twoChildElement.addElement("VE_COMPANY")
                .addText(StringUtils.replaceNullString(gatherdataLog.getVeRfid().getVeCompany()));
        twoChildElement.addElement("VE_PERFORMANCE")
                .addText(StringUtils.replaceNullString(gatherdataLog.getVeRfid().getVePerformance()));

        // FORM_INFO
        Element threeChildElement = root.addElement("FORM_INFO");
        threeChildElement.addElement("FORM_TYPE")
                .addText(StringUtils.replaceNullString(gatherdataLog.getFormInfo().getFormType()));
        threeChildElement.addElement("FORM_ID")
                .addText(StringUtils.replaceNullString(gatherdataLog.getFormInfo().getFormId()));

        // DR_RFID
        Element fourChildElement = root.addElement("DR_RFID");
        fourChildElement.addElement("RFID_ID")
                .addText(StringUtils.replaceNullString(gatherdataLog.getDrRfid().getRfidId()));
        fourChildElement.addElement("DR_NAME")
                .addText(StringUtils.replaceNullString(gatherdataLog.getDrRfid().getDrName()));
        fourChildElement.addElement("DR_CUSTOMS_NO")
                .addText(StringUtils.replaceNullString(gatherdataLog.getDrRfid().getDrCustomsNo()));
        fourChildElement.addElement("DR_COMPANY")
                .addText(StringUtils.replaceNullString(gatherdataLog.getDrRfid().getDrCompany()));
        fourChildElement.addElement("DR_PERFORMANCE")
                .addText(StringUtils.replaceNullString(gatherdataLog.getDrRfid().getDrPerformance()));

        // photo
        Element fiveChildElement = root.addElement("PHOTO");
        fiveChildElement.addElement("PHOTO_GUID")
                .addText(StringUtils.replaceNullString(gatherdataLog.getPhotoOne().getPhotoGuid()));
        fiveChildElement.addElement("PHOTO_PERSPECTIVE")
                .addText(StringUtils.replaceNullString(gatherdataLog.getPhotoOne().getPhotoPerspective()));

        root.addElement("OPERATOR_ID").addText(StringUtils.replaceNullString(gatherdataLog.getOperatorId()));
        root.addElement("OPERATE_TIME").addText(StringUtils.replaceNullString(gatherdataLog.getOperateTime()));

        // EXTEND
        Element sixChildElement = root.addElement("EXTEND");
        sixChildElement.addElement("NAME")
                .addText(StringUtils.replaceNullString(gatherdataLog.getExtend().getName()));
        sixChildElement.addElement("VALUE")
                .addText(StringUtils.replaceNullString(gatherdataLog.getExtend().getValue()));

        // CONTA_RECOGNITION
        Element sevenChildElement = root.addElement("CONTA_RECOGNITION");
        sevenChildElement.addElement("CONTA_ID")
                .addText(StringUtils.replaceNullString(gatherdataLog.getContaRecognition().getContaId()));
        sevenChildElement.addElement("CONTA_TYPE")
                .addText(StringUtils.replaceNullString(gatherdataLog.getContaRecognition().getContaType()));
        sevenChildElement.addElement("CONTA_LOCK")
                .addText(StringUtils.replaceNullString(gatherdataLog.getContaRecognition().getContaLock()));
        sevenChildElement.addElement("CONFIDENCE_RATIO")
                .addText(StringUtils.replaceNullString(gatherdataLog.getContaRecognition().getConfidenceRatio()));

        Element eightChildElement = root.addElement("VE_LICENSE_RECOGNITION");
        eightChildElement.addElement("DOMESTIC_LICENSE_NO")
                .addText(StringUtils.replaceNullString(gatherdataLog.getVeLicenseRecognition().getDomesticLicenseNo()));
        eightChildElement.addElement("DOMESTIC_LICENSE_COLOR")
                .addText(StringUtils.replaceNullString(gatherdataLog.getVeLicenseRecognition().getDomesticLicenseColor()));
        eightChildElement.addElement("FOREIGN_LICENSE_NO")
                .addText(StringUtils.replaceNullString(gatherdataLog.getVeLicenseRecognition().getForeignLicenseNo()));
        eightChildElement.addElement("FOREIGN_LICENSE_COLOR")
                .addText(StringUtils.replaceNullString(gatherdataLog.getVeLicenseRecognition().getForeignLicenseColor()));
        eightChildElement.addElement("CONFIDENCE_RATIO")
                .addText(StringUtils.replaceNullString(gatherdataLog.getVeLicenseRecognition().getConfidenceRatio()));
        // xml格式化样式

        OutputFormat oFormat = OutputFormat.createPrettyPrint();
        oFormat.setEncoding("UTF-8");
        StringWriter sWriter = new StringWriter();
        XMLWriter xWriter = new XMLWriter(sWriter, oFormat);
        try {
            xWriter.write(doc);
            xWriter.flush();
            xWriter.close();
        } catch (IOException e) {
            System.err.println("转换xml异常！");
        }
        String xml81 = sWriter.toString();

        System.out.println("dom4j create81Xml success!");
        return xml81;
    }
}
