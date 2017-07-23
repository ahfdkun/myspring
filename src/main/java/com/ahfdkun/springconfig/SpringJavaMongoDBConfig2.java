package com.ahfdkun.springconfig;

/**
 * @Description 基于Spring Data MongoDB 的第二种写法
 *
 * @author zhaoyakun
 *
 * @date 2017年7月19日 上午12:09:09
 */
// @Configuration
// 使用Spring Data MongoDB实现自动化的Repository
// @EnableMongoRepositories(basePackageClasses = Order.class)
public class SpringJavaMongoDBConfig2 /*extends AbstractMongoConfiguration*/ {

	/*@Autowired
	public Environment env;
	
	@Override
	protected String getDatabaseName() {
		return "OrdersDB";
	}

	@Override
	public Mongo mongo() throws Exception {
		MongoCredential credential = MongoCredential.createCredential(env.getProperty("mongo.username"), "OrdersDB",
				env.getProperty("mongo.password").toCharArray());
		return new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
		return new MongoClient("localhost", 27017);
	}*/
	
}
