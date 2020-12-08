package com.lhzn.soft.project.processing;

import com.lhzn.soft.project.domain.GatherdataLog;
import com.lhzn.soft.project.services.BusinessHandleService;
import com.lhzn.soft.project.services.Xml81Service;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class FanoutProducer {
    @Resource
    private AmqpTemplate amqpTemplate;
    @Resource
    private BusinessHandleService handleService;
    @Resource
    private Xml81Service xml81Service;
    @Value("${station.queuename}")
    private String queueName;
    @Value("${station.locationId}")
    private String locationId;
    // 每0.3秒 查询一次 进行上传
    @Scheduled(cron = "0/1 * * * * ? ")
    public void selectBySessionId() {
        // 查询数据库
        getLogList(handleService, xml81Service);
    }

    public void getLogList(BusinessHandleService handleService, Xml81Service xml81Service) {
        List<GatherdataLog> logs = handleService.selectBySessionId();
        if (logs.size() > 0) {
            for (GatherdataLog gatherdataLog : logs) {
                // 作成81报文
                String stringXml = xml81Service.create81Xml(gatherdataLog);
                // 将消息写入队列中
                MessageProperties messageProperties = new MessageProperties();
                messageProperties.setHeader("locationId",locationId);
                messageProperties.setContentType("text/plain");
                messageProperties.setContentEncoding("UTF-8");
                Message message = new Message(stringXml.getBytes(), messageProperties);
                amqpTemplate.convertAndSend(queueName, message);
                // 将生成后的报文更新回数据库
                handleService.updateData81Command(stringXml, gatherdataLog.getSessionId());
            }
        }
    }

}
