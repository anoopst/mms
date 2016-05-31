package com.dv.mms.app.domain.useraccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class UserAAServiceImpl extends JdbcDaoImpl implements UserAAService {

	@Override
	protected List<UserDetails> loadUsersByUsername(String username) {

		return getJdbcTemplate().query(getUsersByUsernameQuery(),
				new String[] { username }, new RowMapper<UserDetails>() {
					public UserDetails mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						String username = rs.getString(1);
						String password = rs.getString(2);
						String role = rs.getString(3);
						return new User(username, password, true, true, true,
								true, AuthorityUtils.createAuthorityList(role));
					}
				});
	}

	public void changePassword(String username, String password) {		
		getJdbcTemplate().update("UPDATE mm_user SET PASSWORD = ? WHERE US_NAME = ?", password,	username);
	}

}