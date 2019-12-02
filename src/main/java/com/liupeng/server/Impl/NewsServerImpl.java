package com.liupeng.server.Impl;

import com.liupeng.dao.Impl.NewsDaoImpl;
import com.liupeng.entiey.NEWS;
import com.liupeng.server.NewServer;

import java.util.List;

public class NewsServerImpl implements NewServer {
    NewsDaoImpl newsDao=new NewsDaoImpl();
    @Override
    public boolean Newsadd(NEWS news) {

        return newsDao.Newsadd(news);
    }

    @Override
    public List<NEWS> find() {
        return newsDao.find();
    }

    @Override
    public boolean Newsupdate(NEWS news) {
        return newsDao.Newsupdate(news);
    }

    @Override
    public boolean Newsdelete(int id) {
        return newsDao.Newsdelete(id);
    }

    @Override
    public List<NEWS> Newsfindblurry(String s) {
        return newsDao.Newsfindblurry(s);
    }

    @Override
    public boolean NewfindByid(int id) {
        List<NEWS> newsListList=  newsDao.NewfindByid(id);
        if(newsListList!=null){
            return true;
        }
        else  return  false;
    }
}
