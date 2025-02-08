package com.kalaiselvan.springbootsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kalaiselvan.springbootsecurity.dto.AuthRequest;
import com.kalaiselvan.springbootsecurity.dto.Product;
import com.kalaiselvan.springbootsecurity.dto.response.AuthResponse;
import com.kalaiselvan.springbootsecurity.entity.UserInfo;
import com.kalaiselvan.springbootsecurity.service.JwtService;
import com.kalaiselvan.springbootsecurity.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4209")
@RequestMapping("/products")
//@RequiredArgsConstructor
public class ProductController {

	@Autowired
	private ProductService service;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/welcome")
	public String welcome() {
//    throw new RuntimeException("Not found");
		return "Welcome this endpoint is not secure";
	}

	@PostMapping("/new")
	public String addNewUser(@RequestBody UserInfo userInfo) {
		return service.addUser(userInfo);
	}

	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Product> getAllTheProducts() {
		return service.getProducts();
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Product getProductById(@PathVariable int id) {
		return service.getProduct(id);
	}

	@PostMapping("/authenticate")
	public AuthResponse authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		AuthResponse response = new AuthResponse();
		if (authentication.isAuthenticated()) {
			String token = jwtService.generateToken(authRequest.getUsername());
			response.setResult(true);
			response.setToken(token);
			response.setUserName(authRequest.getUsername());
			return response;
		} else {
			throw new UsernameNotFoundException("invalid user request !");
		}

	}
}
