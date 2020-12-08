package com.lhzn.soft.project.processing;

import com.lhzn.soft.project.services.Xml82Service;
import com.lhzn.soft.utils.XmlUtil;
import org.dom4j.Document;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 读取返回队列信息进行处理
 */
@Component
public class DataProcessing {

    @Resource
    private Xml82Service xml82Service;

    @RabbitHandler
//    @RabbitListener(queues = "test-01")
    public void process(@Payload String stringXml82) {
        Document document;
        Map<String,Object> map=new HashMap<>();
        try {
            document = XmlUtil.StringTOXml (stringXml82);
            map = xml82Service.xmlResolve (document);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        xml82Service.xmlUpdate (map, stringXml82);
    }

}

