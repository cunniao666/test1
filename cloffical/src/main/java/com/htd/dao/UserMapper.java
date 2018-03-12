package com.htd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.htd.domain.User;

@Mapper
public interface UserMapper {
	
	@Select("select * from user")
	List<User> findUserByName();

}
