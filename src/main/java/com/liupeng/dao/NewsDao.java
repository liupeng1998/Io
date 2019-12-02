package com.liupeng.dao;

import com.liupeng.entiey.NEWS;

import java.util.List;

public interface NewsDao {

    boolean Newsadd(NEWS news);

    List<NEWS> find();

    boolean Newsupdate(NEWS news);

    boolean Newsdelete(int id);

    List<NEWS> Newsfindblurry(String s);

    List<NEWS> NewfindByid(int id);
}
