package com.liupeng.server.Impl;

import com.liupeng.dao.Impl.UserdaoImpl;
import com.liupeng.entiey.user;
import com.liupeng.server.logodao;
import com.liupeng.until.CaptchaUtil;
import com.liupeng.until.Md5Util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class logoImpl implements logodao {

    UserdaoImpl userdao=new UserdaoImpl();
    //判断是否有该用户
    @Override
    public List<user> Register(String phone) {
        return userdao.findUserbyusername(phone);


    }

    @Override
    public List<user> RegisterBypwd(user user) {
        if(user.getPassword()!=null) {
            try {
                user.setPassword(Md5Util.md5(user.getPassword()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userdao.findCondition(user);

    }

    @Override
    public boolean isMobileNO(String phone) {
        Pattern p = Pattern.compile("^[1](([3|5|8][\\d])|([4][4,5,6,7,8,9])|([6][2,5,6,7])|([7][^9])|([9][1,8,9]))[\\d]{8}$");
        Matcher m = p.matcher(phone);
        return m.matches();
    }

    //发送验证码
    @Override
    public boolean registeredcode(String phone) {
        return    CaptchaUtil.SMS(phone);

    }

    //注册
    @Override
    public boolean registered(user user) {
        String password=user.getPassword();
        try {
            user.setPassword(Md5Util.md5(password));
        } catch (Exception e) {
            e.printStackTrace();
        }

       return userdao.useradd(user);
    }
}
