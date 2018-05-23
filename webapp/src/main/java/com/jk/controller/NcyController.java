/**
 * Copyright (C), 2018-2018, 金科教育有限公司
 * FileName: NcyController
 * Author:   ${牛春云}
 * Date:     2018-5-14 20:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * ${牛春云}           2018-5-14 20:30           版本号              描述
 */
package com.jk.controller;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.jk.pojo.User;
import com.jk.service.NcyService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.FormSubmitEvent;
import java.rmi.ServerException;
import java.util.Map;
import java.util.Random;
import com.aliyuncs.http.MethodType;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ${牛春云}
 * @create 2018-5-14
 * @since 1.0.0
 */
@Controller
@RequestMapping("ncyController")
public class NcyController {

    @Autowired
   private NcyService ncyService;
    private static Random dom = new Random();
    //登陆
    @RequestMapping("login")
    @ResponseBody
    public Map<String,Object> login(HttpSession session, User user, HttpServletRequest request, HttpServletResponse response){
        //Map<String,Object> map=new HashMap<String,Object>();
        return ncyService.login(session,user,request,response);
    }

    @RequestMapping("tocenter")
    public ModelAndView tocenter(){
        ModelAndView mav = new ModelAndView("usercenter");
        return mav;
    }



   /* 手机注册*/

  /* @RequestMapping("zhuce")
   @ResponseBody
    public void  testma()throws ServerException,ClientException {

       String code = (dom.nextInt(9000)+1000)+"";
       System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
       System.setProperty("sun.net.client.defaultReadTimeout", "10000");
       //初始化ascClient需要的几个参数
       final String product = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
       final String domain = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）
       //替换成你的AK
       final String accessKeyId = "LTAIK6G9BYNIZcZS";//你的accessKeyId,参考本文档步骤2
       //final String accessKeyId = "LTAI3wPhzsoPip2v";//你的accessKeyId,参考本文档步骤2
       final String accessKeySecret = "jWSbLihU9v16TmczSlY51yf2HDa68M";//你的accessKeySecret，参考本文档步骤2
       //final String accessKeySecret = "yANFyoFd67Us6IJuTfR9xX0Lfnpoqn";//你的accessKeySecret，参考本文档步骤2
       //初始化ascClient,暂时不支持多region（请勿修改）
       IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
               accessKeySecret);

       DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);

       IAcsClient acsClient = new DefaultAcsClient(profile);
       //组装请求对象
       SendSmsRequest request = new SendSmsRequest();
       //使用post提交
       //request.setMethod(FormSubmitEvent.MethodType.POST);
       request.setMethod(MethodType.POST);
       //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
       request.setPhoneNumbers(userphone);
       //必填:短信签名-可在短信控制台中找到
       request.setSignName("品邮购");
       //必填:短信模板-可在短信控制台中找到
       request.setTemplateCode("SMS_134317096");
       //request.setTemplateCode("SMS_134327592");
       //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
       //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
       request.setTemplateParam("{\"name\":\"Tom\", \"code\":\""+code+"\"}");
       //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
       //request.setSmsUpExtendCode("90997");
       //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
       request.setOutId("yourOutId");
       //请求失败这里会抛ClientException异常
       SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
       if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
       *//* req.getSession().setAttribute(userphone,code);*//*
           ServletActionContext.getRequest().getSession().setAttribute("code",code);
           ServletActionContext.getRequest().getSession().setAttribute("phone",userphone);
           System.out.println(sendSmsResponse.getCode());
        *//*我注释的return sendSmsResponse.getCode();*//*
       }
   }

    //*进行普通用户注册============================================================
    @RequestMapping( "zhuce")
    public void zhuce(){
        String phone = ServletActionContext.getRequest().getSession().getAttribute("phone").toString();
        String Code = ServletActionContext.getRequest().getSession().getAttribute("code").toString();
        String username=user.getUsername();
        String password=user.getPassword();

        String megar="";
        if(user.getUserphone().equals(phone)&&code.equals(Code)){
            loginService.addzhuces(username,password,phone);

            megar= "2";
        }else {

            megar= "1";
        }
        super.writeJson(megar);
    }*/

}
