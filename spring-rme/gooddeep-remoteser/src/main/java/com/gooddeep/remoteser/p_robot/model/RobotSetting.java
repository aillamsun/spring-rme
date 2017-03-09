package com.gooddeep.remoteser.p_robot.model;

import com.gooddeep.remoteser.commons.model.MemBaseBean;

/**
 * 用户设置
 * @author lhy
 *
 */
public class RobotSetting extends MemBaseBean{
 

    private Boolean useSysReply;


    public Boolean getUseSysReply() {
        return useSysReply;
    }

    public void setUseSysReply(Boolean useSysReply) {
        this.useSysReply = useSysReply;
    }

    
}