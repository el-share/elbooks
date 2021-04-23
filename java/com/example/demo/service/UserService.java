package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.LoginUser;
 
 
@Service
@Transactional
public class UserService implements UserDetailsService {
	@Autowired
	LoginUserDao loginUserDao;
 
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		LoginUser user = loginUserDao.findUser(userName);
		System.out.println("LOGINUSER INSTANCE");

		if (user == null) {
			throw new UsernameNotFoundException("userName" + userName + "was not found in the database");
		}
 
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority("USER");
		grantList.add(authority);
 
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
 
		UserDetails userDetails = (UserDetails) new User(user.getUser_name(), encoder.encode(user.getPass()),
				grantList);
		return userDetails;
	}
}
