package com.viks.rest.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.viks.rest.config.Constants;
import com.viks.rest.repositories.entity.User;
import com.viks.rest.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(tags = "User management API")
@RestController
@RequestMapping("/user")
@ComponentScan("com.viks.rest")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Create user")
	@ApiResponses(value = { @ApiResponse(code = Constants.STATUS_CODE_OK, message = "CREATED"),
			@ApiResponse(code = Constants.STATUS_CODE_BAD_REQUEST, message = "Invalid request"),
			@ApiResponse(code = Constants.STATUS_CODE_UNEXPECTED_ERROR, message = "Unexpected error occured")
	})
	@PostMapping("/")
	public ResponseEntity<User> createUser(@ApiParam(value = "user") @RequestBody User user){
		User createdUser = userService.create(user);
		if (createdUser == null)
			return ResponseEntity.notFound().build();

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdUser.getId())
				.toUri();
		return ResponseEntity.created(uri).body(createdUser);
	}

	@ApiOperation(value = "Retrieve user by id")
	@ApiResponses(value = { @ApiResponse(code = Constants.STATUS_CODE_OK, message = "OK"),
			@ApiResponse(code = Constants.STATUS_CODE_BAD_REQUEST, message = "Invalid request"),
			@ApiResponse(code = Constants.STATUS_CODE_NOT_FOUND, message = "Not found"),
			@ApiResponse(code = Constants.STATUS_CODE_UNEXPECTED_ERROR, message = "Unexpected error occured")
	})
	@GetMapping("/{id}")
	public ResponseEntity<User> findUser(@RequestParam(value = "id", required = true) int id) {
		User user = userService.find(id);
		if(user == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(user);
	}

	@ApiOperation(value = "Update user")
	@ApiResponses(value = { @ApiResponse(code = Constants.STATUS_CODE_OK, message = "OK"),
			@ApiResponse(code = Constants.STATUS_CODE_BAD_REQUEST, message = "Invalid request"),
			@ApiResponse(code = Constants.STATUS_CODE_NOT_FOUND, message = "Not found"),
			@ApiResponse(code = Constants.STATUS_CODE_UNEXPECTED_ERROR, message = "Unexpected error occured")
	})
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@RequestBody User user) {
		User updatedUser = userService.update(user);
		if(updatedUser == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(user);
	}

	@ApiOperation(value = "Delete user")
	@ApiResponses(value = { @ApiResponse(code = Constants.STATUS_CODE_OK, message = "DELETED"),
			@ApiResponse(code = Constants.STATUS_CODE_BAD_REQUEST, message = "Invalid request"),
			@ApiResponse(code = Constants.STATUS_CODE_UNEXPECTED_ERROR, message = "Unexpected error occured")
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@RequestParam(value = "id") int id) {
		userService.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);

	}


}

