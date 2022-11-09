package com.Board.BoardAPI.service;

import com.Board.BoardAPI.domain.Board;
import com.Board.BoardAPI.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public void createBoard(Board board) {
        //boardMapper.createBoard(board);
    }
}
