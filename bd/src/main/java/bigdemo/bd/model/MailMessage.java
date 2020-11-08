package bigdemo.bd.model;

import java.io.Serializable;
import java.util.Date;


/*
    Rabbitmq邮件发送的练习，后期可改进为邮件发送成功秒杀的信息
 */
public class MailMessage implements Serializable {

    private static final long serialVersionUID = 136177995387991971L;
    private String to;
    private String from;
    private String subject;
    private String content;
    private Date sentDate;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    @Override
    public String toString() {
        return "MailMessage{" +
                "to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", sentDate=" + sentDate +
                '}';
    }
}
