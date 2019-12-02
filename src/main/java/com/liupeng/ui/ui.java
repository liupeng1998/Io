package com.liupeng.ui;


import com.liupeng.entiey.*;
import com.liupeng.server.Impl.*;
import com.liupeng.until.constant;
import com.sun.org.apache.regexp.internal.RE;

import java.text.SimpleDateFormat;
import java.util.*;

public class ui {
    private static Scanner sc = new Scanner(System.in);
    private static logoImpl logo = new logoImpl();
    private static  String userName="15072111942";
    private static  String RMstatus="M";
    private static  int userID=4;
    public static void main(String[] args) {
            //登录注册模块
            logo();
            //功能模块
            Features();


    }

    private static void Features() {
        boolean falg = true;
        int i=0;
        while (falg){
            if (RMstatus.equals("M")) {
                System.out.println("欢迎管理员" + userName + "您进入新闻信息管理");
            } else {
                System.out.println("欢迎用户" + userName + "您进入新闻信息管理");
            }
            System.out.println("1.新闻信息管理\n" + "2.产品信息管理\n" + "3.消息评论信息管理\n请输入...");

            while (true) {
                try {
                    i = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("输入格式错误，请重新输入");
                    sc=new Scanner(System.in);

                }
            }
            switch (i) {
                case 1:
                    //新闻信息管理
                    Newmanagement();
                    break;
                case 2:
                    //商品信息管理
                    shoppmanagement();
                    break;
                case 3:
                    //消息评论信息管理
                    commentmanagement();
                    break;
                default:
                    System.exit(0);
                    break;
            }
     }
    }

    //消息评论信息管理
    private static void commentmanagement() {
        String title="";
        MESSAGE message=null;

        REVERT revert=null;
        int messageID=0;
        int i=0;
        MessageServerImpl messageServer=new MessageServerImpl();
        RevertServerImpl revertServer=new RevertServerImpl();
        boolean falg=true;

        while (falg){
            if(RMstatus.equals("M")){
                System.out.println("欢迎管理员"+userName+"您进入消息评论信息管理");
            }else
            {System.out.println("欢迎用户"+userName+"您进入消息评论信息管理");}
            System.out.println("1.发表帖子\n2.发表帖子回复\n3.查询指定贴子和相关评论\n请选择...");
            while (true) {
                try {
                    i = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("输入格式错误，请重新输入");
                    sc=new Scanner(System.in);

                }
            }

            switch (i){
                case 1:
                    //发表帖子
                    StringBuilder sd = new StringBuilder();
                    String exit = "0";
                    System.out.println("请输入帖子标题....");
                    title = sc.next();
                    System.out.println("请输入帖子内容....\n输入exit结束输入");
                    while (!"exit".equals(exit)) {
                        sd.append(sc.next());
                        exit = sd.substring(sd.length() - 4, sd.length());
                        if (exit.equals("exit")) {
                            for (int i1 = 0; i1 < 4; i1++) {
                                sd.deleteCharAt(sd.length() - 1);
                            }
                            break;
                        } else sd.append("\n");
                    }
                    message=new MESSAGE();
                    message.setTitle(title);
                    message.setContent(sd.toString());
                    message.setWriter(userID);
                    boolean messageadd = messageServer.Messageadd(message);
                    if (messageadd) System.out.println("添加成功...");
                    else System.out.println("添加失败...");

                    break;
                case 2:
                    //发表帖子回复
                    List<MESSAGE> messages = messageServer.find();
                    for (MESSAGE l : messages) {
                        System.out.println(l.toString());
                    }
                    revert =new REVERT();
                    message =new MESSAGE();
                    System.out.println("请选择要回复的帖子id...");

                    while (true) {
                        try {
                            messageID = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println("输入格式错误，请重新输入");
                            sc=new Scanner(System.in);

                        }
                    }

                    boolean b = messageServer.MessagefindByid(messageID);
                    if(b==false){
                        while (true){
                            System.out.println("无此id,请重新输入...");
                            while (true) {
                                try {
                                    messageID = sc.nextInt();
                                    break;
                                }catch (Exception e){
                                    System.out.println("输入格式错误，请重新输入...");
                                    sc=new Scanner(System.in);
                                }
                            }

                            boolean b1 =messageServer.MessagefindByid(messageID);
                            if(b1) break;
                        }
                    }

                    revert.setMessageID(messageID);
                    revert.setWriter(messageServer.findByMesssageId(messageID));


                    StringBuilder sd1 = new StringBuilder();
                    String exit1 = "0";
                    System.out.println("请输入帖子内容....\n输入exit结束输入");
                    while (!"exit".equals(exit1)) {
                        sd1.append(sc.next());
                        exit = sd1.substring(sd1.length() - 4, sd1.length());
                        if (exit.equals("exit")) {
                            for (int i1 = 0; i1 < 4; i1++) {
                                sd1.deleteCharAt(sd1.length() - 1);
                            }
                            break;
                        } else sd1.append("\n");
                    }
                    revert.setContent(sd1.toString());


                    boolean messageadd1=revertServer.Revereadd(revert);

                    if (messageadd1) {

                        boolean b1 = messageServer.MessageUpdatecount(messageID);
                        if (b1) System.out.println("回复成功...");
                        else System.out.println("回复失败...");
                    }
                    else System.out.println("回复失败...");
                    break;
                case 3:
                    //查询指定贴子和相关评论
                    System.out.println("请输入查看的帖子id...");
                    while (true) {
                        try {
                            messageID = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println("输入格式错误，请重新输入");
                            sc=new Scanner(System.in);
                        }
                    }
                    List<MESSAGE> messageList= messageServer.findByRever(messageID);

                    if(messageList!=null) {
                        for (MESSAGE ml : messageList) {
                            List<REVERT> reverts = ml.getReverts();
                            revert=new REVERT();
                            revert.setContent(reverts.get(0).getContent());
                            revert.setWriteDate(reverts.get(0).getWriteDate());
                            System.out.println("帖子id为：" + ml.getMessageID() +
                                    "\n标题为：" + ml.getTitle() +
                                    "\n正文为：" + ml.getContent() +
                                    "\n回复量为：" + ml.getCount() +
                                    "\n发帖时间为：：" + ml.getWriteDate() +
                                    "\n回复为：" + revert.getContent() +
                                    "\n回复时间为：" + revert.getWriteDate());
                        }
                    }else{
                        List<MESSAGE> byId = messageServer.findById(messageID);
                        if(byId!=null){
                            for (MESSAGE by:byId){
                                System.out.println(by.toString());
                            }
                        }else
                        System.out.println("无此查询的帖子");
                    }
                    break;
                default:falg=false;
                break;
            }

        }
    }

    //商品信息管理
    private static void shoppmanagement() {
        int productID=0;
        String serialNumber="";
        String name="";
        String brand="";
        String model="";
        double price=0;
        String description="";
        PRODUCT product=null;
        boolean falg=true;
        int i=0;
        ProductServerImpl productServer=new ProductServerImpl();
        while (falg) {
            if(RMstatus.equals("M")){
                System.out.println("欢迎管理员"+userName+"您进入商品信息管理");
            }else
            {System.out.println("欢迎用户"+userName+"您进入商品信息管理");}
            System.out.println("1.添加产品\n2.修改产品\n3.删除产品\n4.按产品名查询产品\n请选择...");
            while (true) {
                try {
                    i = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("输入格式错误，请重新输入");
                    sc=new Scanner(System.in);

                }
            }

            switch (i){
                case 1:
                    //添加产品
                    StringBuilder sd = new StringBuilder();
                    String exit = "0";
                    System.out.println("请输入商品编号....");
                    serialNumber = sc.next();
                    System.out.println("请输入商品名称....");
                    name = sc.next();
                    System.out.println("请输入商品品牌....");
                    brand = sc.next();
                    System.out.println("请输入商品型号....");
                    model = sc.next();
                    System.out.println("请输入商品价格....");
                    while (true) {
                        try {

                            price = sc.nextDouble();
                            break;

                        } catch (Exception e) {
                            System.out.println("输入格式错误，请重新输入...");
                            sc = new Scanner(System.in);
                        }
                    }
                    System.out.println("请输入商品详情....输入exit结束输入");

                    while (!"exit".equals(exit)) {
                        sd.append(sc.next());
                        exit = sd.substring(sd.length() - 4, sd.length());
                        if (exit.equals("exit")) {
                            for (int i1 = 0; i1 < 4; i1++) {
                                sd.deleteCharAt(sd.length() - 1);
                            }
                            break;
                        } else sd.append("\n");
                    }
                    product = new PRODUCT();
                    product.setSerialNumber(serialNumber);
                    product.setName(name);
                    product.setBrand(brand);
                    product.setModel(model);
                    product.setPrice(price);
                    product.setDescription(sd.toString());

                    boolean productadd = productServer.Productadd(product);
                    if (productadd) System.out.println("添加成功");
                    else System.out.println("添加失败");

                    break;
                case 2:
                    //修改产品

                    List<PRODUCT> list = productServer.find();
                    for (PRODUCT l : list) {
                        System.out.println(l.toString());
                    }
                    product = new PRODUCT();
                    System.out.println("请选择要修改的id...");
                    while (true) {
                    try {
                        productID = sc.nextInt();
                            break;
                        }catch (Exception e){
                        System.out.println("输入格式错误，请重新输入...");
                        sc=new Scanner(System.in);
                         }
                    }
                    //加判断是否有此id
                    boolean b = productServer.ProductfindByid(productID);
                    if(b==false){
                        while (true){
                            System.out.println("无此id,请重新输入...");
                            while (true) {
                                try {
                                    productID = sc.nextInt();
                                    break;
                                }catch (Exception e){
                                    System.out.println("输入格式错误，请重新输入...");
                                    sc=new Scanner(System.in);
                                }
                            }
                            boolean b1 = productServer.ProductfindByid(productID);
                            if(b1) break;
                        }
                    }

                        product.setProductID(productID);
                        System.out.println("请输入标题的修改商品编号,不修改请输入0...");
                        serialNumber = sc.next();
                        if (!"0".equals(serialNumber)) product.setSerialNumber(serialNumber);
                        System.out.println("请输入标题的修改商品名称,不修改请输入0...");
                        name = sc.next();
                        if (!"0".equals(name)) product.setName(name);
                        System.out.println("请输入标题的修改商品品牌,不修改请输入0...");
                        brand = sc.next();
                        if (!"0".equals(brand)) product.setBrand(brand);
                        System.out.println("请输入标题的修改商品型号,不修改请输入0...");
                        model = sc.next();
                        if (!"0".equals(model)) product.setModel(model);
                        System.out.println("请输入标题的修改商品价格,不修改请输入0...");
                        while (true) {
                            try {
                                price = sc.nextDouble();
                                break;
                            } catch (Exception e) {
                                System.out.println("价格输入格式错误...");
                                sc=new Scanner(System.in);
                            }
                        }
                        if (!"0".equals(price)) product.setPrice(price);
                        System.out.println("请输入标题的修改商品描述exit结束修改,不修改时请输入0...");

                        String exit1 = "";
                        StringBuilder sd1=new StringBuilder();
                        while (!"exit".equals(exit1)&&!"0".equals(exit1)) {
                            sd1.append(sc.next());
                            exit1 = sd1.substring(sd1.length() - 1, sd1.length());
                            if(exit1.equals("0")){
                                break;
                             }
                             exit1 = sd1.substring(sd1.length() - 4, sd1.length());
                             if (exit1.equals("exit")) { for (int i1 = 0; i1 < 4; i1++) {
                                sd1.deleteCharAt(sd1.length() - 1);
                             }
                                break;
                            } else sd1.append("\n");
                        }
                        if (!"0".equals(exit1)) product.setDescription(sd1.toString());


                        if (product.getSerialNumber() == null && product.getName() == null && product.getBrand() == null && product.getModel() != null && product.getPrice() != 0 && product.getDescription() != null) {
                            System.out.println("你没有修改任何值...");

                        } else {
                            boolean productupdate = productServer.Productupdate(product);
                            if (productupdate) System.out.println("修改成功");
                            else System.out.println("修改失败");
                        }

                    break;
                case 3:

                    //3.删除产品
                    List<PRODUCT> list1 = productServer.find();
                    for (PRODUCT l : list1) {
                        System.out.println(l.toString());
                    }
                    product = new PRODUCT();
                    System.out.println("请选择要删除的标识id");
                    try {
                        productID = sc.nextInt();
                    }catch (Exception e){
                        System.out.println("输入格式错误，请重新输入...");
                        break;
                    }
                    boolean productdelete = productServer.Productdelete(productID);
                    if(productdelete) System.out.println("删除成功");
                    else System.out.println("删除失败,无此id");
                    break;
                case 4:

                    //按产品名查询产品
                    System.out.println("请输入要查询的产品名或关键字...");
                    String s=sc.next();
                    List<PRODUCT> productfindblurry = productServer.Productfindblurry(s);
                    if(productfindblurry!=null) {
                        for (PRODUCT l : productfindblurry) {
                            System.out.println(l.toString());
                        }
                    }else System.out.println("无此查询！！！");
                    break;
                default:
                    falg=false;
                    break;
            }


        }
    }

    //新闻信息管理
    private static void Newmanagement() {
        int id=0;
        String title="";
        String content="";
        String time="";
        NEWS news=null;
        boolean falg=true;

        NewsServerImpl newsServer=new NewsServerImpl();
        while (falg) {
            int i=0;
            if(RMstatus.equals("M")){
                System.out.println("欢迎管理员"+userName+"您进入新闻信息管理");
            }else
            {System.out.println("欢迎用户"+userName+"您进入新闻信息管理");}
            System.out.println("1.添加新闻\n2.修改新闻\n3.删除新闻\n4.按关键字模糊查询新闻\n请输入...");
            while (true) {
                try {
                    i = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("输入格式错误，请重新输入");
                    sc=new Scanner(System.in);

                }
            }
            switch (i){
                case 1:
                    //添加新闻
                        StringBuilder sd = new StringBuilder();
                        String exit = "0";
                        System.out.println("请输入新闻标题....");
                        title = sc.next();
                        System.out.println("请输入新闻内容....输入exit结束输入");

                        while (!"exit".equals(exit)) {
                            sd.append(sc.next());
                            exit = sd.substring(sd.length() - 4, sd.length());
                            if (exit.equals("exit")) {
                                for (int i1 = 0; i1 < 4; i1++) {
                                    sd.deleteCharAt(sd.length() - 1);
                                }
                                break;
                            } else sd.append("\n");
                        }
                        news = new NEWS();
                        news.setTitle(title);
                        news.setContent(sd.toString());
                        boolean newsadd = newsServer.Newsadd(news);
                        if (newsadd) System.out.println("添加成功");
                        else System.out.println("添加失败");

                    break;
                case 2:
                    //修改新闻
                        List<NEWS> list = newsServer.find();
                        for (NEWS l : list) {
                            System.out.println(l.toString());
                        }
                        news = new NEWS();
                        System.out.println("请选择要修改的id...");
                        while (true) {
                            try {
                                id = sc.nextInt();
                                break;
                            } catch (Exception e) {
                                System.out.println("输入格式错误，请重新输入...");
                                sc=new Scanner(System.in);
                            }
                        }
                        //加判断是否有此id
                        boolean b = newsServer.NewfindByid(id);
                        if(b==false){
                            while (true){
                                System.out.println("无此id,请重新输入...");
                                while (true) {
                                    try {
                                        id = sc.nextInt();
                                        break;
                                    }catch (Exception e){
                                        System.out.println("输入格式错误，请重新输入...");
                                        sc=new Scanner(System.in);
                                    }
                                }
                                boolean b1 = newsServer.NewfindByid(id);
                                if(b1) break;
                            }
                        }

                            news.setNewsID(id);
                            System.out.println("请输入标题的修改内容,不修改请输入0...");
                            title = sc.next();
                            if (!"0".equals(title)) news.setTitle(title);
                            System.out.println("请输入内容的修改exit退出,不修改请输入0...");
                            String exit1 = "";
                            StringBuilder sd1=new StringBuilder();
                            while (!"exit".equals(exit1)&&!"0".equals(exit1)) {
                                sd1.append(sc.next());
                                exit1 = sd1.substring(sd1.length() - 1, sd1.length());
                                if(exit1.equals("0")){
                                    break;
                                }
                                exit1 = sd1.substring(sd1.length() - 4, sd1.length());
                                if (exit1.equals("exit")) { for (int i1 = 0; i1 < 4; i1++) {
                                      sd1.deleteCharAt(sd1.length() - 1);
                                  }
                                    break;
                                 } else sd1.append("\n");
                            }
                            if (!"0".equals(exit1)) news.setContent(sd1.toString());
                            System.out.println("请输入时间的修改,不修改请输入0，选择当前时间输入1...");
                            time = sc.next();
                            if (!"0".equals(time) && !"1".equals(time)) news.setWriterDate(time);
                            else if ("1".equals(time)) {
                                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                                news.setWriterDate(df.format(new Date()));
                            }
                            if (news.getTitle() == null && news.getContent() == null && news.getWriterDate() == null) {
                                System.out.println("你没有修改任何值...");

                            } else {
                                boolean newsupdate = newsServer.Newsupdate(news);
                                if (newsupdate) System.out.println("修改成功");
                                else System.out.println("修改失败");
                            }

                    break;
                case 3:

                    //3.删除新闻
                    List<NEWS> list1 = newsServer.find();
                    for (NEWS l : list1) {
                        System.out.println(l.toString());
                    }
                    news = new NEWS();
                    System.out.println("请选择要删除的id");
                    while (true) {
                        try {
                            id = sc.nextInt();
                            break;
                        } catch (Exception e) {
                            System.out.println("输入格式错误，请重新输入");
                            sc=new Scanner(System.in);

                        }
                    }
                    boolean newsdelete = newsServer.Newsdelete(id);
                    if(newsdelete) System.out.println("删除成功");
                    else System.out.println("删除失败,无此id");
                        break;
                case 4:

                    //模糊查询
                    System.out.println("请输入要查询的关键字...");
                    String s=sc.next();
                    List<NEWS> newsfindblurry = newsServer.Newsfindblurry(s);
                    if(newsfindblurry!=null){
                        for (NEWS l : newsfindblurry) {
                        System.out.println(l.toString());
                        }
                    }else System.out.println("无此查询！！！");
                    break;
                default:
                    falg=false;
                    break;
            }
        }
    }

    private static void logo() {

        String phone = null;
        String password = null;
        String status = null;
        boolean falg=true;
        int i=0;
        user user = null;
        System.out.println("欢迎使用企业宣传专栏IO字符流版本");
        System.out.println("1.注册\n" + "2.登录\n" + "请选择……");
        while (true) {
            try {
                i = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("输入格式错误，请重新输入");
                sc=new Scanner(System.in);

            }
        }

        while (i != 1 && i != 2) {
            System.out.println("输入错误，请从新输入");
            System.out.println("欢迎使用企业宣传专栏IO字符流版本");
            System.out.println("1.注册\n" + "2.登录\n" + "请选择……");
            while (true) {
                try {
                    i = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("输入格式错误，请重新输入");
                    sc=new Scanner(System.in);

                }
            }
        }

        while (falg) {
            switch (i) {
                //注册
                case 1:
                    while (true) {
                        System.out.println("请输入手机号");
                        phone = sc.next();
                        while (logo.isMobileNO(phone) == false) {
                            System.out.println("手机号格式错误，请重新输入");
                            phone = sc.next();
                        }


                        boolean register=logo.Register(phone)!=null?true:false;


                        if (!register) {

                            break;
                        } else System.out.println("该账号已存在请重新输入...");
                    }


                    while (true) {
                        boolean registeredcode = logo.registeredcode(phone);
                        if (registeredcode) {
                            System.out.println("验证码已发送，请耐心等待");
                            System.out.println("请输入验证码");
                            String Verificationcode = sc.next();
                            if (constant.code.equals(Verificationcode)) {
                                System.out.println("请输入密码...");
                                password = sc.next();
                                System.out.println("请输入注册身份...");
                                System.out.println("R/用户\nM/管理员");
                                status = sc.next();
                                while (!status.equals("R") && !status.equals("M")) {
                                    System.out.println("输入格式错误...");
                                    System.out.println("R---用户\nM----管理员");
                                    status = sc.next();
                                }
                                user = new user();
                                user.setUserName(phone);
                                user.setPassword(password);
                                user.setStatus(status);

                                boolean registered = logo.registered(user);
                                if (registered == true) {
                                    System.out.println("注册成功");
                                    i = 2;
                                } else System.out.println("注册失败");
                                break;
                            } else {
                                System.out.println("验证码发送失败");
                                System.out.println("30秒后重新发送");
                                try {
                                    for (int i1 = 5; i1 > 0; i1--) {
                                        Thread.sleep(1000);
                                        System.out.println("还剩" + i1 + "秒");
                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        user = new user();
                        System.out.println("请输入帐号...");
                        phone = sc.next();
                        System.out.println("请输入密码...");
                        password = sc.next();
                        user.setUserName(phone);
                        user.setPassword(password);
                        List<user> users = logo.RegisterBypwd(user);

                        if (users != null) {

                            userName=user.getUserName();
                            RMstatus=users.get(0).getStatus();
                            userID=users.get(0).getUserID();
                            falg=false;
                            break;
                        } else {
                            System.out.println("账号密码输入错误请重新输入....");
                        }
                    }
                    break;
                default:break;
            }
        }

    }
}
