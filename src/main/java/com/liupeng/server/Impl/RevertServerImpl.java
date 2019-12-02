package com.liupeng.server.Impl;

import com.liupeng.dao.Impl.RevertDaoImpl;
import com.liupeng.entiey.REVERT;
import com.liupeng.server.RevertServer;

import java.util.List;

public class RevertServerImpl implements RevertServer {
    RevertDaoImpl revertDao=new RevertDaoImpl();
    @Override
    public boolean Revereadd(REVERT revert) {
        return revertDao.Revereadd(revert);
    }

    @Override
    public List<REVERT> find() {
        return revertDao.find();
    }
}
