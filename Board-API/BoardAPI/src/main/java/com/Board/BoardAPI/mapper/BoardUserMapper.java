package com.Board.BoardAPI.mapper;

import com.Board.BoardAPI.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardUserMapper {
    void createUser(User user);
    User getUser(String userId);
}
