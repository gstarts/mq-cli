package com.lhzn.soft.utils;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

public class XmlUtil {

    /**
     * 字符串格式的转换为xml文档
     * @param str 字符串
     * @return 结果
     */
    public static Document StringTOXml(String str) throws DocumentException {
        return DocumentHelper.parseText(str);
    }

}
