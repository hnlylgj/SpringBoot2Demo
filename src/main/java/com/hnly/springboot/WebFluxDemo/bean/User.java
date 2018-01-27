package com.hnly.springboot.WebFluxDemo.bean;

import java.util.Date;  

/** 
 * Title: User Description: 实体类 Company: blog.csdn.net/lu1005287365/ 
 *  
 * @author L lulu 
 */  
public class User 
{  
    private Integer id;  
    private String name;  
    private Date date;  
    private char sex;  

    public Integer getId() {  
        return id;  
    }  

    public void setId(Integer id) {  
        this.id = id;  
    }  

    public String getName() {  
        return name;  
    }  

    public void setName(String name) {  
        this.name = name;  
    }  

    public Date getDate() {  
        return date;  
    }  

    public void setDate(Date date) {  
        this.date = date;  
    }  

    public char getSex() {  
        return sex;  
    }  

    public void setSex(char sex) {  
        this.sex = sex;  
    }  

}  

