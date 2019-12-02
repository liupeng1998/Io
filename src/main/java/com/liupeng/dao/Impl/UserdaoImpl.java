package com.liupeng.dao.Impl;

import com.liupeng.dao.Userdao;
import com.liupeng.entiey.user;
import com.liupeng.until.Condition;
import com.liupeng.until.Jdbcuntil;

import java.util.ArrayList;
import java.util.List;

public class UserdaoImpl  implements Userdao {
    @Override
    public boolean useradd(user user) {
        String sql="insert into user (userName,password,status) values(?,?,?)";
        Object[]parms={user.getUserName(),user.getPassword(),user.getStatus()};
        return  Jdbcuntil.AddDeleteUpdate(sql, parms);

    }

    @Override
    public List<user> findUserbyusername(String username) {
        String sql="select*from user where username=?";
        Object[]parms={username};
        return  Jdbcuntil.saveUser(sql, parms);

    }

    @Override
    public List<user> findCondition(user user) {

        String sql=Condition.userCondition(user);
        List<Object> list=new ArrayList<Object>();
        if(user.getUserName()!=null){
           list.add(user.getUserName());
            if(user.getPassword()!=null){
                list.add(user.getPassword());
                if(user.getStatus()!=null){
                    list.add(user.getStatus());
                }
            }else if(user.getStatus()!=null){
                list.add(user.getStatus());
            }
        }else if(user.getPassword()!=null){
            list.add(user.getPassword());
            if(user.getStatus()!=null){
                list.add(user.getStatus());
            }
        }else  if(user.getStatus()!=null){
            list.add(user.getStatus());
        }

        Object[] parms=new Object[list.size()];
        for (int i=0;i<list.size();i++){
           parms[i]=list.get(i);
         }

        return  Jdbcuntil.saveUser(sql, parms);

    }
}
