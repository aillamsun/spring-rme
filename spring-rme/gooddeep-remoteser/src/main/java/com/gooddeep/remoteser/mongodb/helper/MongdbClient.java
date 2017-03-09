package com.gooddeep.remoteser.mongodb.helper;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongdbClient {
	
	/**
	 * 获取不需要认证的客户端
	 * @param ip
	 * @param port
	 * @return
	 */
	public MongoClient getClientNotAuth(String ip,int port)
	{
		MongoClient client=null;
		try {
		MongoClientOptions.Builder build = new MongoClientOptions.Builder();
		// 与数据最大连接数50
		build.connectionsPerHost(50);
		// 如果当前所有的connection都在使用中，则每个connection上可以有50个线程排队等待
		build.threadsAllowedToBlockForConnectionMultiplier(50);
		build.connectTimeout(1 * 60 * 1000);
		build.maxWaitTime(2 * 60 * 1000);
		MongoClientOptions options = build.build();
		InetAddress inetAddress;
	
			inetAddress = InetAddress.getByName(ip);
		
		ServerAddress addr=new ServerAddress(inetAddress, port);//设置地址
		client = new MongoClient(addr, options);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
		
	}
	
	/**
	 * 获取认证的客户端
	 * @param ip
	 * @param port
	 * @param authDb
	 * @param account
	 * @param password
	 * @return
	 */
	public MongoClient getClientNotAuth(String ip,int port,String authDb,String account,String password)
	{

		MongoClientOptions.Builder build = new MongoClientOptions.Builder();
		// 与数据最大连接数50
		build.connectionsPerHost(50);
		// 如果当前所有的connection都在使用中，则每个connection上可以有50个线程排队等待
		build.threadsAllowedToBlockForConnectionMultiplier(50);
		build.connectTimeout(1 * 60 * 1000);
		build.maxWaitTime(2 * 60 * 1000);

		MongoClientOptions options = build.build();
		MongoCredential crclientedentials = MongoCredential
				.createScramSha1Credential(account, authDb, password.toCharArray());
		List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
		credentialsList.add(crclientedentials);//凭证列表，英文一个数据库中可能有多个账号密码
		InetAddress inetAddress;
		MongoClient client=null;
		try {
			inetAddress = InetAddress.getByName(ip);
			ServerAddress addr=new ServerAddress(inetAddress, port);//设置地址
			client = new MongoClient(addr, credentialsList, options);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		

			return client;
		
	}

}
