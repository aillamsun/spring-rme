package com.gooddeep.remoteser.redis;

import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class dddd {

	public static void main(String[] args) {
		StringRedisSerializer s=new StringRedisSerializer();
		RedisSerializer s2=new JdkSerializationRedisSerializer();
		RedisSerializer s3=new JacksonJsonRedisSerializer(bb.class);
		System.out.println(s.serialize("aaaaaaaaaaaaaa"));
		System.out.println(s2.serialize("aaaaaaaaaaaaaa"));
		bb b=new bb();
		b.setName("ffffffff");
		System.out.println(s3.deserialize(s3.serialize(b)));
		
	}
}

class bb{
	private String name="fff";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
