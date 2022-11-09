package com.Board.BoardAPI.controller;

import com.Board.BoardAPI.domain.Board;
import com.Board.BoardAPI.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/create")
    public String createBoard(@RequestBody Board board){
        boardService.createBoard(board);

        return "Done";
    }

    @GetMapping("/read/{boardId}")
    public Board getBoard(@PathVariable Long boardId) {
        return boardService.getBoard(boardId);
    }

    @GetMapping("/list")
    public List<Board> getBoardList(Long page) {
        return boardService.getBoardList(page);
    }

    @PostMapping("/update")
    public String updateBoard(@RequestBody Board board) {
        boardService.updateBoard(board);

        return "Done";
    }

    @GetMapping("/delete")
    public String deleteBoard(Long boardId) {
        boardService.deleteBoard(boardId);

        return "Done";
    }
}
