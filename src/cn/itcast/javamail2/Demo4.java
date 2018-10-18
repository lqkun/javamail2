package cn.itcast.javamail2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

//创建最复杂邮件
public class Demo4 {

  public static void main(String[] args) throws Exception {

      //创建邮件
      Session session = Session.getDefaultInstance(new Properties());
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress("653591018@qq.com"));
      message.setRecipient(Message.RecipientType.TO, new InternetAddress("1129706754@qq.com"));
      message.setSubject("测试");
      
      //创建bodypart封装正文
      MimeBodyPart text = new MimeBodyPart();
      text.setContent("这是中文邮件a<img src='cid:1.jpg'>", "text/html;charset=UTF-8");
      
      //创建bodypart封装图片
      MimeBodyPart image = new MimeBodyPart();
      image.setDataHandler(new DataHandler(new FileDataSource("D://1.jpg")));
      image.setContentID("1.jpg");
      
      //创建bodypart封装附件,解决乱码
      MimeBodyPart attach = new MimeBodyPart();
      DataHandler dh = new DataHandler(new FileDataSource("D://QuanSongCi.txt"));
      attach.setDataHandler(dh);
      attach.setFileName(MimeUtility.encodeText(dh.getName()));//content-disposition
      
      //描述数据关系
      MimeMultipart content = new MimeMultipart();
      content.addBodyPart(text);
      content.addBodyPart(image);
      content.setSubType("related");
      
      MimeBodyPart mbp = new MimeBodyPart();
      mbp.setContent(content);
      MimeMultipart mm = new MimeMultipart();
      mm.addBodyPart(mbp);
      mm.addBodyPart(attach);
      mm.setSubType("mixed");
      
      message.setContent(mm);
      message.saveChanges();
      
      message.writeTo(new FileOutputStream("D:\\1.eml"));
     
  }
}