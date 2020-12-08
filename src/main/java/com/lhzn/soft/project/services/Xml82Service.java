package com.lhzn.soft.project.services;

import org.dom4j.Document;

import java.util.Map;

public interface Xml82Service {
    /**
     * 82报文解析
     * @param document 82报文
     * @return 返回结果
     * @throws Exception （校验报文异常）
     */
     Map<String,Object> xmlResolve(Document document) throws  Exception;


    /**
     * 将解析完成的对象信息更新到数据库
     * @param map 数据
     * @param xml 报文
     */
     void xmlUpdate (Map<String,Object> map, String xml);
}
