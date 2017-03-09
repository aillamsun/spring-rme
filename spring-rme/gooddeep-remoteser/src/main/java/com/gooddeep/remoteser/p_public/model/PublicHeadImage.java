package com.gooddeep.remoteser.p_public.model;

import com.gooddeep.remoteser.commons.model.SystemBaseBean;

/**
 * 
 * @author lhy
 *
 */
public class PublicHeadImage extends SystemBaseBean{
   

    private String title;

    private String content;

    private Integer gdType;

    private String imgUrl;



    private String createUser;

    private String url;



   

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

    public Integer getGdType() {
        return gdType;
    }

    public void setGdType(Integer gdType) {
        this.gdType = gdType;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

   
}