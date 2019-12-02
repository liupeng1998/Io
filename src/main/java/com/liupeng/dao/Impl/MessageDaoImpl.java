package com.liupeng.dao.Impl;

import com.liupeng.dao.MessageDao;
import com.liupeng.entiey.MESSAGE;
import com.liupeng.until.Jdbcuntil;

import java.util.List;

public class MessageDaoImpl implements MessageDao {
    @Override
    public boolean Messageadd(MESSAGE message) {
        String sql="insert into MESSAGE (title,content,Writer) values(?,?,?)";
        Object[]parms={message.getTitle(),message.getContent(),message.getWriter()};

        return Jdbcuntil.AddDeleteUpdate(sql,parms);
    }

    @Override
    public List<MESSAGE> find() {
        String sql="select*from MESSAGE";
        Object[]parms=null;
        return Jdbcuntil.saveMessage(sql,parms);
    }

    @Override
    public boolean MessageupdateCount(int messageId) {
        String sql="update MESSAGE set count=count+1 where messageID=?";
        Object[]parms={messageId};
        return  Jdbcuntil.AddDeleteUpdate(sql,parms);
    }

    @Override
    public List<MESSAGE> findByMesssageId(int messageId) {
        String sql="select*from MESSAGE where messageID=?";
        Object[]parms={messageId};
        return  Jdbcuntil.saveMessage(sql,parms);
    }

    @Override
    public List<MESSAGE> findByREVERT(int messageId) {
        String sql=" SELECT m.messageID ,m.title,m.content,m.count,m.Writer,m.writeDate,r.content recontent,r.writeDate rewriteDate FROM MESSAGE m join REVERT r on m.messageID=r.messageID where m.messageID=?";

        return Jdbcuntil.saveMessageByRever(sql,messageId);
    }

    @Override
    public List<MESSAGE> MessagefindByid(int messageID) {
        String sql="select *from MESSAGE where messageID=?";

        Object[]parms={messageID};

        return Jdbcuntil.saveMessage(sql,parms);
    }


}
