package com.liupeng.dao;

import com.liupeng.entiey.MESSAGE;

import java.util.List;

public interface MessageDao {

    boolean Messageadd(MESSAGE message);

    List<MESSAGE> find();

    boolean MessageupdateCount(int messageId);

    List<MESSAGE> findByMesssageId(int messageId);

    List<MESSAGE> findByREVERT(int messageId);

    List<MESSAGE> MessagefindByid(int messageID);
}
