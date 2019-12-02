package com.liupeng.dao.Impl;

import com.liupeng.dao.RevertDao;
import com.liupeng.entiey.REVERT;
import com.liupeng.until.Jdbcuntil;

import java.util.List;

public class RevertDaoImpl implements RevertDao {
    @Override
    public boolean Revereadd(REVERT revert) {
        String sql="insert into REVERT (messageID,content,Writer) values(?,?,?)";
        Object[]parms={revert.getMessageID(),revert.getContent(),revert.getWriter()};

        return Jdbcuntil.AddDeleteUpdate(sql,parms);
    }

    @Override
    public List<REVERT> find() {
        String sql="select*from REVERT";
        Object[]parms=null;
        return Jdbcuntil.saveRevert(sql,parms);
    }
}
