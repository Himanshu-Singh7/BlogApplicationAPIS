package com.blogs.apis.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogs.apis.payloads.ApiResponse;
import com.blogs.apis.payloads.UserDto;
import com.blogs.apis.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// POST Create the User
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
             UserDto createUserDto = this.userService.createUser(userDto);
             return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

	// PUT Update the User
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uId) {

		UserDto updateUser = userService.updateUser(userDto, uId);
		return ResponseEntity.ok(updateUser);
	}

	// GET Retrive one data by id
	@GetMapping("/{userId}")
       public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
	 return ResponseEntity.ok(this.userService.getUserById(userId));
      }

	// Delete
        @DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid ){
    	 this.userService.deleteUser(uid);
    	 return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully ",true),HttpStatus.OK);
    	 
	}
    
    // GET Retrive all data
    
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUser(){
	 
    	return ResponseEntity.ok(this.userService.getAllUser());
   }

}
