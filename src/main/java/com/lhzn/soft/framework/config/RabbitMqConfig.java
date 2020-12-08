package com.lhzn.soft.framework.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
@Configuration
public class RabbitMqConfig {

    @Value("${spring.rabbitmq.host}")
    private String addresses;

    @Value("${spring.rabbitmq.port}")
    private String port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(addresses+":"+port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setConnectionTimeout(60000);
        connectionFactory.setPublisherConfirms(true);
        return connectionFactory;
    }


    /**
     * rabbitAdmin代理类
     * @return
     */
    @Bean
    public RabbitAdmin rabbitAdmin(){
        return new RabbitAdmin(connectionFactory());
    }



    /**
     * 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置
     */
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean("rabbitTemplate")
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setDefaultReceiveQueue("test-01");
        template.setEncoding("UTF-8");
        return template;
    }

    @Bean
    public Queue goodsQueue() {
        Queue goodsQueue = new Queue("receive",true,false,false);
        return goodsQueue;
    }

    @Bean
    DirectExchange mqDirectExchange() {
        return new DirectExchange("mq-exchange",true,false);
    }

    @Bean
    Binding bindingExchangSmsQueue(Queue smsQueue, DirectExchange  mqDirectExchange) {
        Binding binding = BindingBuilder.bind(smsQueue).to(mqDirectExchange).with("upload-queue");
        return  binding;
    }
}
