package com.liupeng.entiey;

/*
新闻表
 */
public class NEWS {
    private int newsID;         //标识id
    private String title;       //标题
    private String content;     //内容
    private String writerDate;  //时间default

    public NEWS() {
    }

    public NEWS(int newsID, String title, String content, String writerDate) {
        this.newsID = newsID;
        this.title = title;
        this.content = content;
        this.writerDate = writerDate;
    }

    public int getNewsID() {
        return newsID;
    }

    public void setNewsID(int newsID) {
        this.newsID = newsID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriterDate() {
        return writerDate;
    }

    public void setWriterDate(String writerDate) {
        this.writerDate = writerDate;
    }

    @Override
    public String toString() {
        return
                "id为：" + newsID +
                "\n 标题为：" + title +
                "\n内容为：" + content +
                "\n时间为：" + writerDate ;
    }
}
