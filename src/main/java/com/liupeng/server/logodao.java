package com.liupeng.server;

import com.liupeng.entiey.NEWS;
import com.liupeng.entiey.user;

import java.util.List;

public interface logodao {
    List<user> Register(String phone);

    List<user> RegisterBypwd(user user);

    boolean isMobileNO(String phone);

    boolean registeredcode(String phone);

    boolean registered(user user);
}
