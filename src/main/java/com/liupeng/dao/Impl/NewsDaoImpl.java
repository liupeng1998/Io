package com.liupeng.dao.Impl;

import com.liupeng.dao.NewsDao;
import com.liupeng.entiey.NEWS;
import com.liupeng.until.Condition;
import com.liupeng.until.Jdbcuntil;

import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl implements NewsDao {


    @Override
    public boolean Newsadd(NEWS news) {
        String sql="insert into NEWS (title,content) values(?,?)";
        Object[]parms={news.getTitle(),news.getContent()};

        return Jdbcuntil.AddDeleteUpdate(sql,parms);
    }

    @Override
    public List<NEWS> find() {
        String sql="select*from NEWS";
        Object[]parms=null;
        return Jdbcuntil.saveNews(sql,parms);
    }

    @Override
    public boolean Newsupdate(NEWS news) {
        String sql= Condition.NewsUpdate(news);

        List<Object> list=new ArrayList<Object>();
        if(news.getTitle()!=null)
            list.add(news.getTitle());
        if(news.getContent()!=null)
            list.add(news.getContent());
        if(news.getWriterDate()!=null)
            list.add(news.getWriterDate());
        list.add(news.getNewsID());
        Object[] parms=new Object[list.size()];
        for (int i=0;i<list.size();i++){
            parms[i]=list.get(i);

        }

        return  Jdbcuntil.AddDeleteUpdate(sql, parms);

    }

    @Override
    public boolean Newsdelete(int id) {
        String sql="delete from NEWS where newsID=?";
        Object[]parms={id};

        return Jdbcuntil.AddDeleteUpdate(sql,parms);
    }

    @Override
    public List<NEWS> Newsfindblurry(String s) {
        String sql="select *from NEWS where content LIKE ?";

        Object[]parms={"%"+s+"%"};

        return Jdbcuntil.saveNews(sql,parms);
    }

    @Override
    public List<NEWS> NewfindByid(int id) {
        String sql="select *from NEWS where newsID=?";

        Object[]parms={id};

        return Jdbcuntil.saveNews(sql,parms);
    }
}
