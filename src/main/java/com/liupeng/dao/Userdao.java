package com.liupeng.dao;

import com.liupeng.entiey.user;

import java.util.List;

public interface Userdao {

    boolean useradd(user user);

    List<user> findUserbyusername(String username);

    List<user> findCondition(user user);

}
