package com.Board.BoardAPI.mapper;

import com.Board.BoardAPI.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BoardMapper {
    void createBoard(Board board);

    Board getBoard(Long boardId);

    void updateBoard(Board board);

    void deleteBoard(Long boardId);

    List<Board> getBoardList(Long startNum);
}
