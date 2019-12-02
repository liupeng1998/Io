package com.liupeng.entiey;

import java.util.List;

/*
发的帖子
 */
public class MESSAGE {
    private  int messageID;      //标识id
    private  String title;      //标题
    private  String content;    //内容
    private  int Writer;        //作者
    private  String writeDate;  //时间default
    private  int count;         //回复数量default(0)
    private List<REVERT> reverts; //回复帖子

    public List<REVERT> getReverts() {
        return reverts;
    }

    public void setReverts(List<REVERT> reverts) {
        this.reverts = reverts;
    }

    public MESSAGE() {
    }

    public MESSAGE(int messageID, String title, String content, int writer, String writeDate, int count) {
        this.messageID = messageID;
        this.title = title;
        this.content = content;
        Writer = writer;
        this.writeDate = writeDate;
        this.count = count;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
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

    public int getWriter() {
        return Writer;
    }

    public void setWriter(int writer) {
        Writer = writer;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public String toString() {
        return
            "id:" + messageID +
            "\n标题：" + title +
            "\n内容：" + content +
            "\n作者：" + Writer +
            "\n时间：" + writeDate+
                "\n回复量："+count;
    }


}
