
package com.demo.springbootbb.mappers;
  
import java.util.List;

import org.codehaus.plexus.component.annotations.Component;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.ComponentScan;

import com.demo.springbootbb.dtos.UserMsDTO;
import com.demo.springbootbb.entities.User;
  
  @Mapper(componentModel = "Spring")  
 // @org.springframework.stereotype.Component("usermapper")
  public interface UserMapper {
	  
	  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	  
	  //User to UserMsDTO
	  @Mappings({
			@Mapping(source= "email", target="emailaddress"),
			@Mapping(source = "role", target="rolename")
			})
	  UserMsDTO userToUserDTO(User user);
	  
	  //List<User> to List<UserMsDTO>
	  List<UserMsDTO> userToUserDTOs(List<User> user);
  
  }
 
