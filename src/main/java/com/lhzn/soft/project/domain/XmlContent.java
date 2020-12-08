package com.lhzn.soft.project.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class XmlContent implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    /**
     * 报文名称
     */
    private String xmlName;
    /**
     * 报文序号
     */
    private String sessionId;
    /**
     * 报文内容
     */
    private String xmlContent;
    /**
     * 入库时间
     */
    private String time;
}
