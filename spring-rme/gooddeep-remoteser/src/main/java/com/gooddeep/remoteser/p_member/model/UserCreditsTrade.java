package com.gooddeep.remoteser.p_member.model;

import org.springframework.util.StringUtils;

import com.gooddeep.remoteser.commons.model.MemBaseBean;

/**
 * 用户积分交易记录
 * @author lhy
 *
 */
public class UserCreditsTrade extends MemBaseBean{
   

    private String reson;//交易原因

    private Integer gdType; //内部平台

    private Float tradeCredits;//交易积分

    private String fromPlatform;//充值平台

    private Float preCredits;//交易前积分

    private Float nowCredits;//交易后积分

    private String remark;//备注
 
    private Integer tradeType;//交易类型，1充值，2，花费
    
    //以下为临时变量
    private String gdTypeStr;//内部平台
    private String tradeTypeStr;//交易类型
    
    

    
    
    public String getGdTypeStr() {
		return gdTypeStr;
	}

	public void setGdTypeStr(String gdTypeStr) {
		this.gdTypeStr = gdTypeStr;
	}

	public String getTradeTypeStr() {
		return tradeTypeStr;
	}

	public void setTradeTypeStr(String tradeTypeStr) {
		this.tradeTypeStr = tradeTypeStr;
	}

	public Integer getTradeType() {
		return tradeType;
	}

	public void setTradeType(Integer tradeType) {
		this.tradeType = tradeType;
		if(!StringUtils.isEmpty(tradeType))
		{
			if(tradeType==1)
			{
				setTradeTypeStr("充值");
			}
			else if(tradeType==2)
				setTradeTypeStr("消费");
		}
	}

	public String getReson() {
        return reson;
    }

    public void setReson(String reson) {
        this.reson = reson;
    }

    public Integer getGdType() {
        return gdType;
    }

    public void setGdType(Integer gdType) {
        this.gdType = gdType;
        setGdTypeStr(String.valueOf(gdType));
    }

    public Float getTradeCredits() {
        return tradeCredits;
    }

    public void setTradeCredits(Float tradeCredits) {
        this.tradeCredits = tradeCredits;
    }

 

    public String getFromPlatform() {
        return fromPlatform;
    }

    public void setFromPlatform(String fromPlatform) {
        this.fromPlatform = fromPlatform;
    }

    public Float getPreCredits() {
        return preCredits;
    }

    public void setPreCredits(Float preCredits) {
        this.preCredits = preCredits;
    }

    public Float getNowCredits() {
        return nowCredits;
    }

    public void setNowCredits(Float nowCredits) {
        this.nowCredits = nowCredits;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}