package com.gooddeep.remoteser.p_public.model;

import com.gooddeep.remoteser.commons.model.SystemBaseBean;

/**
 * 公共新闻
 * @author lhy
 *
 */
public class PublicNews extends SystemBaseBean{


    private String title;

    private Integer gdType;

  

    private String createUser;

    private String affixUrls;

  

    private Integer newsType;

    private String content;

    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getGdType() {
        return gdType;
    }

    public void setGdType(Integer gdType) {
        this.gdType = gdType;
    }

  

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getAffixUrls() {
        return affixUrls;
    }

    public void setAffixUrls(String affixUrls) {
        this.affixUrls = affixUrls;
    }

   

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}