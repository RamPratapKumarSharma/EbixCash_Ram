package com.userinputvalidation.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.userinputvalidation.dto.User;


@Repository
public class UserDaoImp implements UserDaoInterface {
	@Autowired
	JdbcTemplate template;

	@Override
	public int userinputvalidation(User user) {
		String qry = "insert into User(data) values('"+user.getData()+"')";
		return template.update(qry);
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

//	@Override
//	public User userinputvalidation(User user) {
//		java.sql.Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebixcash?user=root&password=root");
//			String qry = "insert into User values(?)";
//			preparedStatement = connection.prepareStatement(qry);
//			int result = preparedStatement.executeUpdate();
//			preparedStatement.setString(1, user.getValues());
//			if (result != 0)
//				return user;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (connection != null) {
//				try {
//					connection.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			if (preparedStatement != null) {
//				try {
//					preparedStatement.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return null;
//	}
	
}