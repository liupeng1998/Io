package com.liupeng.until;

import com.liupeng.entiey.NEWS;
import com.liupeng.entiey.PRODUCT;
import com.liupeng.entiey.user;

public class Condition {
    public static String userCondition(user user){
        StringBuilder sd= new StringBuilder("select *from user  ");
        if(user.getUserName()==null&&user.getPassword()==null&&user.getStatus()==null)return sd.toString();


        if(user.getUserName()!=null){
            sd.append("  where username=? ");
            if(user.getPassword()!=null){
                sd.append(" and password=? ");
                if(user.getStatus()!=null){
                    sd.append(" and status=?");
                }
            }else if(user.getStatus()!=null){
                sd.append(" and status=?");
            }
        }else if(user.getPassword()!=null){
            sd.append(" where password=? ");
            if(user.getStatus()!=null){
                sd.append(" and status=?");
            }
        }else  if(user.getStatus()!=null){
            sd.append(" where status=?");
        }

        return sd.toString();

    }

    public static String NewsUpdate(NEWS news){
        StringBuilder sd= new StringBuilder("update NEWS set   ");
        if(news.getTitle()!=null)
            sd.append("title=?,");
        if(news.getContent()!=null)
            sd.append("content=?,");
        if(news.getWriterDate()!=null)
            sd.append("writerDate=?,");

        sd.deleteCharAt(sd.length()-1);
        System.out.println(sd.toString());

        sd.append("   where newsID=? ");

        return sd.toString();

    }

    public static String Productupdate(PRODUCT product) {
        StringBuilder sd= new StringBuilder("update PRODUCT set   ");

        String s=",";

        if(product.getSerialNumber()!=null)
            sd.append(" serialNumber=?,");
        if (product.getName() != null)
            sd.append(" name=?,");
        if (product.getBrand() != null)
            sd.append("brand=?,");
        if (product.getModel() != null)
            sd.append("model=?,");
        if (product.getPrice() != 0)
            sd.append("price=?,");
        if (product.getDescription() != null)
            sd.append("description=?,");

        sd.deleteCharAt(sd.length()-1);
        System.out.println(sd.toString());
        sd.append("   where productID=? ");

        return sd.toString();
    }
}
