package com.ironhack.MidTermProject;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

import static org.hibernate.bytecode.BytecodeLogger.LOGGER;


@SpringBootApplication
public class MidTermProjectApplication implements ApplicationRunner {
	@Autowired
	private Environment env;

	public static void main(String[] args) {
		LOGGER.info("[APP INIT] - Application started.");
		SpringApplication.run(MidTermProjectApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		env.getProperty("spring.datasource.url");
		String aSQLScriptFilePath = "./src/main/resources/populate.sql";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				env.getProperty("spring.datasource.url"),
				env.getProperty("spring.datasource.username"),
				env.getProperty("spring.datasource.password"));
		try {
			ScriptRunner scriptRunner = new ScriptRunner(con);
			Reader reader = new BufferedReader(
					new FileReader(aSQLScriptFilePath));
			scriptRunner.runScript(reader);
		} catch (Exception e) {
			System.err.println("Failed to Execute" + aSQLScriptFilePath
					+ " The error is " + e.getMessage());
		}
	}
}
