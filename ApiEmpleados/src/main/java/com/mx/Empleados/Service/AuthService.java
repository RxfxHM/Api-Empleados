package com.mx.Empleados.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mx.Empleados.Entity.Role;
import com.mx.Empleados.Entity.User;
import com.mx.Empleados.Repository.IUserDao;
import com.mx.Empleados.Request.AuthResponse;
import com.mx.Empleados.Request.LoginRequest;
import com.mx.Empleados.Request.RegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	private IUserDao UserDao;
	
	@Autowired
	private PasswordEncoder passwordEnconder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public AuthResponse login(LoginRequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		UserDetails user=UserDao.findByUsername(request.getUsername()).orElseThrow();
		String token = jwtService.getToken(user);
		return AuthResponse.builder()
				.token(token)
				.build();
	}
	
	public AuthResponse register(RegisterRequest request) {
		User user = User.builder()
				.username(request.getUsername())
				.password(passwordEnconder.encode(request.getPassword()))
				.firstname(request.getFirstname())
				.lastname(request.getLastname())
				.country(request.getCountry())
				.role(Role.USER)
				.build();
		UserDao.save(user);
		
		return AuthResponse.builder()
				.token(jwtService.getToken(user))
				.build();	
	}
	
	
}
