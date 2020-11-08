package bigdemo.bd.controller;



import bigdemo.bd.model.MailMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.AbstractJavaTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/*
    Rabbitmq邮件发送的练习，后期可改进为邮件发送成功秒杀的信息
 */
@RequestMapping("/Mail")
@ResponseBody
@Controller
public class Mail_Rabbltmq {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "/order")
    @ResponseBody
    public String mail() {

        MailMessage mail = new MailMessage();
        mail.setSubject("SpringBoot");
        mail.setContent("<a href='https://www.baidu.com/'>这是一封来自SpringBoot的邮件！</a>");
        mail.setSentDate(new Date());
        mail.setTo("1326571252@qq.com");
        mail.setFrom("1326571252@qq.com");
        //设置交换机
        this.rabbitTemplate.setExchange("mail_exchange");
        //设置路由key
        this.rabbitTemplate.setRoutingKey("mail_route_key");
        Message message = null;
        try {
            //Message该类是RabbitMQ提供的，将邮件信息mail转化为字节后存储Message的body中，设置   				Message的传输模式
            message = MessageBuilder.withBody(objectMapper.writeValueAsBytes(mail))
                    .setDeliveryMode(MessageDeliveryMode.PERSISTENT)
                    .build();
            //设置Message的头属性，内容格式为json
            message.getMessageProperties()
                    .setHeader(AbstractJavaTypeMapper.DEFAULT_CONTENT_CLASSID_FIELD_NAME, 		            MessageProperties.CONTENT_TYPE_JSON);
            //将邮件信息发送到交换机
            this.rabbitTemplate.convertAndSend(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "注册成功";
    }


}
