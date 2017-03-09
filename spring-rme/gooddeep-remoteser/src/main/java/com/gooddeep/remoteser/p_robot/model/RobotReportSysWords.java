package com.gooddeep.remoteser.p_robot.model;

import com.gooddeep.remoteser.commons.model.MemBaseBean;


/**
 * 用户报告系统自动回复
 * @author lhy
 *
 */
public class RobotReportSysWords extends MemBaseBean{


    private String word;


    private Integer reportStatus;

    private String requestRemark;

    private String responseRemark;



    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

  

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }

    public String getRequestRemark() {
        return requestRemark;
    }

    public void setRequestRemark(String requestRemark) {
        this.requestRemark = requestRemark;
    }

    public String getResponseRemark() {
        return responseRemark;
    }

    public void setResponseRemark(String responseRemark) {
        this.responseRemark = responseRemark;
    }

}