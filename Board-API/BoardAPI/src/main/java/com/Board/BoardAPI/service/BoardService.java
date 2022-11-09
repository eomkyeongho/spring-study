package com.Board.BoardAPI.service;

import com.Board.BoardAPI.domain.Board;
import com.Board.BoardAPI.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public void createBoard(Board board) {
        boardMapper.createBoard(board);
    }

    public List<Board> getBoardList(Long page) {
        return boardMapper.getBoardList(page);
    }
    public Board getBoard(Long boardId) {
        return boardMapper.getBoard(boardId);
    }

    public void updateBoard(Board board) {
        boardMapper.updateBoard(board);
    }

    public void deleteBoard(Long boardId) {
        boardMapper.deleteBoard(boardId);
    }
}
