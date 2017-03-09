package com.gooddeep.remoteser.mongodb.helper;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

//不需要认证
public class Auth_no {
	
	/**
	 * 获得无密码验证的client
	 * @param ip
	 * @param port
	 * @return
	 */
	public static MongoClient getClient(String ip,int port){
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
	
	
	public static void main(String args[]) throws UnknownHostException {
		MongoClientOptions.Builder build = new MongoClientOptions.Builder();
		// 与数据最大连接数50
		build.connectionsPerHost(50);
		// 如果当前所有的connection都在使用中，则每个connection上可以有50个线程排队等待
		build.threadsAllowedToBlockForConnectionMultiplier(50);
		build.connectTimeout(1 * 60 * 1000);
		build.maxWaitTime(2 * 60 * 1000);
		MongoClientOptions options = build.build();
		InetAddress inetAddress=InetAddress.getByName("127.0.0.1");
		ServerAddress addr=new ServerAddress(inetAddress, 2222);//设置地址
		MongoClient client = new MongoClient(addr, options);

		// 获取数据库test,不存在的话，会自动建立该数据库
		MongoDatabase db = client.getDatabase("lhy");

		// 获取data集合，不存在的话，会自动建立该集合（相当于关系数据库中的数据表）
		MongoCollection<Document> users = db.getCollection("lhy");
		Document document = new Document();
		document.append("firstName", "lei");
		document.append("address", "sichuan chengdu");
		users.insertOne(document);
		// MongoClient使用完后必须要close释放资源
		client.close();
	}
}