package cn.itcast.javamail2;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.javamail2.util.SendEmail;

public class Demo5 {
	 public static void main(String[] args) throws Exception {
		 //gutwnqnuqgfqbedf
	        List<String> map = new ArrayList<>();
	      /*  map.add("123456@qq.com");
	        map.add("456789@qq.com");
	        map.add("hahaha123@gmail.com");*/
	        new SendEmail("653591018@qq.com", "gutwnqnuqgfqbedf")
	                .setDebug(true)
	                .setMyNickName("这是我的昵称")
	                .addFile("D://1.jpg")//添加附件
	                .addFile("D://QuanSongCi.txt")
//	              .addFile(List<String> list)//添加附件集合
	              .setSaveEmail("D://name.eml")//保存邮件
	              .addRecipientT0("653591018@qq.com")//添加收件人地址
//	            .addRecipientT0(map)//添加收件人地址集合
//	            .addRecipientCC(map)//添加密送收件人地址
//	            .addRecipientBCC(map)//添加抄送收件人地址
	              .createMail("标题", "发送的内容", "text/html;charset=utf-8")
	              .sendEmail(new SendEmail.Callback() {
	                    @Override
	                    public void success(String s) {
	                        System.out.println(s);//发送完成后回调接口
	                    }
	 
	                    @Override
	                    public void error(String s, Exception e) {
	                        System.out.println(s);
	                        e.printStackTrace();//异常失败的回调接口
	                    }
	                });
	    }

}
