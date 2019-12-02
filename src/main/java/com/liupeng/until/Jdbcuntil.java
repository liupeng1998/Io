package com.liupeng.until;

import com.liupeng.entiey.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Jdbcuntil {

    private static String driver=null;
    private static String url=null;
    private static String username=null;
    private static String password=null;
    private static Connection conn=null;
    private static PreparedStatement p=null;
    private static ResultSet rs=null;
    static{
        InputStream is=Jdbcuntil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties p=new Properties();
        try {
            p.load(is);
            driver=p.getProperty("driver");
            url=p.getProperty("url");
            username=p.getProperty("username");
            password=p.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection  getConnection(){
        try {
            conn = DriverManager.getConnection(url, username, password);
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }

    public static void close(Connection conn,PreparedStatement p){
        if (p != null) {
            try {
                p.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection conn,PreparedStatement p,ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (p != null) {
            try {
                p.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




    /*
    断开式查询
     */
    public static boolean AddDeleteUpdate(String sql,Object[]parms) {
        conn=Jdbcuntil.getConnection();
        try {
            p=conn.prepareStatement(sql);
            for(int i=0;i<parms.length;i++){
                if(parms[i] instanceof String){
                    p.setString(i+1,parms[i].toString());
                }else if(parms[i] instanceof Integer){
                    p.setInt(i+1,(int)parms[i]);
                }else if(parms[i] instanceof Double){
                    p.setDouble(i+1,(double) parms[i]);
                }
            }
            if(p.executeUpdate()>0) return true;
        } catch (SQLException e) {
            return false;
        }finally{
            Jdbcuntil.close(conn,p);
        }
        return false;

    }

    /*
    非断开式查询
     */
    public static List<MESSAGE> saveMessage(String sql, Object[]parms){
        conn=Jdbcuntil.getConnection();
        List<MESSAGE> list=new ArrayList<MESSAGE>();
        try {
            p = conn.prepareStatement(sql);
            if(parms!=null) {
                for (int i = 0; i < parms.length; i++) {
                    if (parms[i] instanceof String) {
                        p.setString(i+1, parms[i].toString());
                    } else if (parms[i] instanceof Integer) {
                        p.setInt(i+1, (int)parms[i]);
                    }
                }
            }
            rs= p.executeQuery();



            while(rs.next()){
                MESSAGE message=new MESSAGE();
                message.setMessageID(rs.getInt("messageID"));
                message.setTitle(rs.getString("title"));
                message.setContent(rs.getString("content"));
                message.setWriter(rs.getInt("writer"));
                message.setWriteDate(rs.getString("writeDate"));
                message.setCount(rs.getInt("count"));
                list.add(message);
            }

        } catch (SQLException e) {
            return list=null;
        }finally {
            Jdbcuntil.close(conn,p,rs);
        }

        if(list.size()>0)
        return  list;
        else return list=null;
    }

    public static List<MESSAGE> saveMessageByRever(String sql, int messageId){
        conn=Jdbcuntil.getConnection();
        List<MESSAGE> list=new ArrayList<MESSAGE>();
        try {
            p = conn.prepareStatement(sql);
            p.setInt(1,messageId);
            rs= p.executeQuery();
            while(rs.next()){
                MESSAGE message=new MESSAGE();
                REVERT revert=new REVERT();
                List<REVERT> revertList=new ArrayList<REVERT>();
                message.setMessageID(rs.getInt("messageID"));
                message.setTitle(rs.getString("title"));
                message.setContent(rs.getString("content"));
                message.setCount(rs.getInt("count"));
                message.setWriter(rs.getInt("writer"));
                message.setWriteDate(rs.getString("writeDate"));
                revert.setContent(rs.getString("recontent"));
                revert.setWriteDate(rs.getString("rewriteDate"));
                revertList.add(revert);
                message.setReverts(revertList);
                list.add(message);
            }

        } catch (SQLException e) {
            return list=null;
        }finally {
            Jdbcuntil.close(conn,p,rs);
        }

        if(list.size()>0)
            return  list;
        else return list=null;
    }

    public static List<NEWS> saveNews(String sql, Object[]parms){
        conn=Jdbcuntil.getConnection();
        List<NEWS> list=new ArrayList<NEWS>();
        try {
            p = conn.prepareStatement(sql);
            if(parms!=null) {
                for (int i = 0; i < parms.length; i++) {
                    if (parms[i] instanceof String) {
                        p.setString(i+1, parms[i].toString());
                    } else if (parms[i] instanceof Integer) {
                        p.setInt(i+1, (int) parms[i]);
                    }
                }
            }
            rs= p.executeQuery();

            while(rs.next()){
                NEWS news1=new NEWS();
                news1.setNewsID(rs.getInt("newsID"));
                news1.setTitle(rs.getString("title"));
                news1.setContent(rs.getString("content"));
                news1.setWriterDate(rs.getString("writerDate"));
                list.add(news1);
            }

        } catch (SQLException e) {
            return list=null;
        }finally {
            Jdbcuntil.close(conn,p,rs);
        }

        if(list.size()>0)
            return  list;
        else return list=null;

    }

    public static List<user> saveUser(String sql, Object[]parms){
        conn=Jdbcuntil.getConnection();
        List<user> list=new ArrayList<user>();
        try {
            p = conn.prepareStatement(sql);
            if(parms!=null) {
                for (int i = 0; i < parms.length; i++) {
                    if (parms[i] instanceof String) {
                        p.setString(i+1, parms[i].toString());
                    } else if (parms[i] instanceof Integer) {
                        p.setInt(i+1, (int) parms[i]);
                    }
                }
            }
            rs= p.executeQuery();



            while(rs.next()){
                user user1=new user();
                user1.setUserID(rs.getInt("userID"));
                user1.setUserName(rs.getString("userName"));
                user1.setPassword(rs.getString("password"));
                user1.setStatus(rs.getString("status"));
                list.add(user1);
            }

        } catch (SQLException e) {
            return list=null;
        }finally {
            Jdbcuntil.close(conn,p,rs);
        }


        if(list.size()>0)
            return  list;
        else return list=null;

    }

    public static List<PRODUCT> saveProduct(String sql, Object[]parms){
        conn=Jdbcuntil.getConnection();
        List<PRODUCT> list=new ArrayList<PRODUCT>();
        try {
            p = conn.prepareStatement(sql);
            if(parms!=null) {
                for (int i = 0; i < parms.length; i++) {
                    if (parms[i] instanceof String) {
                        p.setString(i+1, parms[i].toString());
                    } else if (parms[i] instanceof Integer) {
                        p.setInt(i+1, (int) parms[i]);
                    }else if (parms[i] instanceof Double) {
                        p.setDouble(i+1,(Double) parms[i]);
                    }
                }
            }
            rs= p.executeQuery();


            while(rs.next()){
                PRODUCT product=new PRODUCT();
                product.setProductID(rs.getInt("productID"));
                product.setSerialNumber(rs.getString("serialNumber"));
                product.setName(rs.getString("name"));
                product.setBrand(rs.getString("brand"));
                product.setModel(rs.getString("model"));
                product.setPrice(rs.getDouble("Price"));
                product.setDescription(rs.getString("description"));
                list.add(product);
            }

        } catch (SQLException e) {
            return list=null;
        }finally {
            Jdbcuntil.close(conn,p,rs);
        }

        if(list.size()>0)
            return  list;
        else return list=null;

    }

    public static List<REVERT> saveRevert(String sql, Object[]parms){
        conn=Jdbcuntil.getConnection();
        List<REVERT> list=new ArrayList<REVERT>();
        try {
            p = conn.prepareStatement(sql);
            if(parms!=null) {
                for (int i = 0; i < parms.length; i++) {
                    if (parms[i] instanceof String) {
                        p.setString(i+1, parms[i].toString());
                    } else if (parms[i] instanceof Integer) {
                        p.setInt(i+1, (int) parms[i]);
                    }
                }
            }
            rs= p.executeQuery();


            while(rs.next()){
                REVERT revert=new REVERT();
                revert.setRevertID(rs.getInt("revertID"));
                revert.setMessageID(rs.getInt("messageID"));
                revert.setContent(rs.getString("content"));
                revert.setWriter(rs.getInt("writer"));
                revert.setWriteDate(rs.getString("writeDate"));
                list.add(revert);
            }

        } catch (SQLException e) {
            return list=null;
        }finally {
            Jdbcuntil.close(conn,p,rs);
        }

        if(list.size()>0)
            return  list;
        else return list=null;

    }
}
