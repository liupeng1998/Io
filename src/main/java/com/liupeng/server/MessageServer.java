package com.liupeng.server;

import com.liupeng.entiey.MESSAGE;

import java.util.List;

public interface MessageServer {

    boolean Messageadd(MESSAGE message);

    List<MESSAGE> find();

    int findByMesssageId(int messageId);

    List<MESSAGE> findById(int messageId);

    boolean MessageUpdatecount(int messageId);

    List<MESSAGE> findByRever(int messageID);

    boolean MessagefindByid(int messageID);
}
