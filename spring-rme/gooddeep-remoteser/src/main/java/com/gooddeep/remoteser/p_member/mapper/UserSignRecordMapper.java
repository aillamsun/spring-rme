package com.gooddeep.remoteser.p_member.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gooddeep.remoteser.commons.dao.MemberBaseMapper;
import com.gooddeep.remoteser.p_member.model.UserSignRecord;

public interface UserSignRecordMapper extends MemberBaseMapper<UserSignRecord>{
	/**
	 * 今天是否签到
	 * @param fkUser
	 * @param date
	 * @return
	 */
	@Select("select * from user_sign_record usr where user.fk_user=#{fkUser} and TO_DAYS(create_time)=TO_DAYS(#{date})")
	public List<UserSignRecord> listSignToday(@Param("fkUser")String fkUser,@Param("date")Date date);
 
}