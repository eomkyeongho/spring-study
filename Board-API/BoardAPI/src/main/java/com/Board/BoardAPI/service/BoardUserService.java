package com.Board.BoardAPI.service;

import com.Board.BoardAPI.domain.User;
import com.Board.BoardAPI.mapper.BoardUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardUserService {
    private final BoardUserMapper boardUserMapper;
    public void createUser(User user) {boardUserMapper.createUser(user);}

    public boolean login(User user) {
        User dbUser = boardUserMapper.getUser(user.getUserId());

        return dbUser.getUserPassword().equals(user.getUserPassword());
    }
}
