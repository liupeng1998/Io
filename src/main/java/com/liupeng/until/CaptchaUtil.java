package com.liupeng.until;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;
import java.util.Random;

public class CaptchaUtil {

    private  static int  appid=1400283357;
    private  static String  appkey="18c3431acb6fce528896808fba58e8db";
    //签名
    private  static String sign="刘朋个人展示";
    //短信正文id
    private static int  templateId=477398;

    public static boolean SMS(String phone){
        //参数存储验证码
        String[] params=new String[1];
        //验证码
        StringBuilder sd=new StringBuilder();
        Random r=new Random();
        for (int i=0;i<6;i++){
            sd.append(r.nextInt(10));
        }
        constant.code=sd.toString();
        params[0]=constant.code;


        //发送短信核心类
        SmsSingleSender ssender=new SmsSingleSender(appid,appkey);

        try {
            SmsSingleSenderResult Result = ssender.sendWithParam("86", phone, templateId,params, sign, "", "");


        }catch (HTTPException e) {
            // HTTP响应码错误
            e.printStackTrace();
        } catch (JSONException e) {
            // json解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络IO错误
            e.printStackTrace();
        }
        return true;
    }

}
