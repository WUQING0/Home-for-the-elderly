package bigdemo.bd.service.impl;

import bigdemo.bd.model.MailMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

/*
    Rabbitmq邮件发送的练习，后期可改进为邮件发送成功秒杀的信息
 */
@Component
public class MailServiceImpl {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JavaMailSender sender;

	//该注解开启监听指定的对列，如果队列中有消息就去出来交给sendSimpleMail方法来处理
    @RabbitListener(queues = "mail_queue")
    public void sendSimpleMail(@Payload byte[] message) {
        try {
             MailMessage mailMessage = this.objectMapper.readValue(message, MailMessage.class);//将message，转换为MailMessage对象(自定义)


//            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();    普通无样式的形式
//            simpleMailMessage.setFrom(mailMessage.getFrom()); 普通无样式的书写方式
//            simpleMailMessage.setTo(mailMessage.getTo());
//            simpleMailMessage.setSentDate(mailMessage.getSentDate());
//            simpleMailMessage.setSubject(mailMessage.getSubject());
//            simpleMailMessage.setText(mailMessage.getContent());

                MimeMessage mimeMessage=this.sender.createMimeMessage();    //HTML方式进行邮件的发送
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true,"utf-8");
                mimeMessageHelper.setFrom(mailMessage.getFrom());
                mimeMessageHelper.setTo(mailMessage.getTo());
                mimeMessageHelper.setSentDate(mailMessage.getSentDate());
                mimeMessageHelper.setSubject(mailMessage.getSubject());
                mimeMessageHelper.setText(mailMessage.getContent(),true);


			//发送邮件
            this.sender.send(mimeMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
