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

    @GetMapping("/list")
    public List<Board> getBoardList(Long page) {
        return boardService.getBoardList(page);
    }

    @PostMapping("/post")
    public String createBoard(@RequestBody Board board){
        boardService.createBoard(board);

        return "Create Board Done";
    }

    @GetMapping("/post/detail/{boardId}")
    public Board getBoard(@PathVariable Long boardId) {
        return boardService.getBoard(boardId);
    }

    @PutMapping("/post/detail/{boardId}")
    public String updateBoard(@RequestBody Board board) {
        boardService.updateBoard(board);

        return "Update Board Done";
    }

    @DeleteMapping("/post/detail/{boardId}")
    public String deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);

        return "Delete Board Done";
    }
}
