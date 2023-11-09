package com.blogs.apis.service.Impl;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blogs.apis.entites.User;
import com.blogs.apis.payloads.UserDto;
import com.blogs.apis.repositories.UserRepo;
import com.blogs.apis.service.UserService;
import com.blogs.apis.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {

		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userTodto(savedUser);

	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updateUser = this.userRepo.save(user);
		UserDto userDto1 = this.userTodto(updateUser);
		
		return userDto1;
				
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		return this.userTodto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> users =   this.userRepo.findAll();
		List<UserDto> usersDtos = users.stream().map(user -> this.userTodto(user)).collect(Collectors.toList());
		return usersDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", "id",userId));
		this.userRepo.delete(user);
	}

	
	private User dtoToUser(UserDto userDto) {

		User user = this.modelMapper.map(userDto, User.class);

//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());

		return user;

	}

	public UserDto userTodto(User user) {
        
		UserDto userDto = this.modelMapper.map(user,UserDto.class);
		return userDto;

	}

}
