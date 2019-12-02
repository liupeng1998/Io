package com.liupeng.server;

import com.liupeng.entiey.NEWS;

import java.util.List;

public interface NewServer {

    boolean Newsadd(NEWS news);

    List<NEWS> find();

    boolean Newsupdate(NEWS news);

    boolean Newsdelete(int id);

    List<NEWS> Newsfindblurry(String s);

    boolean NewfindByid(int id);
}
