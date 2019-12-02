package com.liupeng.server.Impl;

import com.liupeng.dao.Impl.MessageDaoImpl;
import com.liupeng.entiey.MESSAGE;
import com.liupeng.server.MessageServer;

import java.util.List;

public class MessageServerImpl implements MessageServer {

    MessageDaoImpl messageDao=new MessageDaoImpl();
    @Override
    public boolean Messageadd(MESSAGE message) {
        return messageDao.Messageadd(message);
    }

    @Override
    public List<MESSAGE> find() {
        return messageDao.find();
    }

    @Override
    public int  findByMesssageId(int messageId) {
        List<MESSAGE> byMesssageId = messageDao.findByMesssageId(messageId);
        return   byMesssageId.get(0).getWriter();
    }

    @Override
    public List<MESSAGE> findById(int messageId) {
        return  messageDao.findByMesssageId(messageId);
    }

    @Override
    public boolean MessageUpdatecount(int messageId) {
        return messageDao.MessageupdateCount(messageId);
    }

    @Override
    public List<MESSAGE> findByRever(int messageID) {

        return messageDao.findByREVERT(messageID);
    }

    @Override
    public boolean MessagefindByid(int messageID) {
        List<MESSAGE> messageList = messageDao.MessagefindByid(messageID);
        if(messageList!=null){
            return true;
        }
        else  return  false;
    }
}
