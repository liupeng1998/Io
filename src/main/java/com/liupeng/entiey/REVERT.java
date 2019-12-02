package com.liupeng.entiey;

/*
回帖表
 */
public class REVERT {
    private  int revertID;       //id
    private  int messageID;      //发帖id
    private  String content;    //回复内容
    private  int Writer;        //作者
    private  String writeDate;  //时间default

    public REVERT() {
    }

    public REVERT(int revertID, int messageID, String content, int writer, String writeDate) {
        this.revertID = revertID;
        this.messageID = messageID;
        this.content = content;
        Writer = writer;
        this.writeDate = writeDate;
    }

    public int getRevertID() {
        return revertID;
    }

    public void setRevertID(int revertID) {
        this.revertID = revertID;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
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

    @Override
    public String toString() {
        return
                "id:" + revertID +
                "\n 发帖id：" + messageID +
                "\n 内容：=" + content +
                "\n 作者id：" + Writer +
                "\n 时间：" + writeDate;
    }
}
