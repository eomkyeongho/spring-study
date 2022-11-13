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

    @GetMapping("/posts")
    public List<Board> getBoardList(Long page) {
        if(page == null) page = 1L;
        return boardService.getBoardList((page-1) * 5);
    }

    @PostMapping("/posts")
    public String createBoard(@RequestBody Board board){
        boardService.createBoard(board);

        return "게시 글 작성 완료";
    }

    @GetMapping("/posts/{boardId}")
    public Board getBoard(@PathVariable Long boardId) {
        return boardService.getBoard(boardId);
    }

    @PutMapping("/posts/{boardId}")
    public String updateBoard(@RequestBody Board board) {
        boardService.updateBoard(board);

        return "게시 글 수정 완료";
    }

    @DeleteMapping("/posts/{boardId}")
    public String deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);

        return "게시 글 삭제 완료";
    }
}
