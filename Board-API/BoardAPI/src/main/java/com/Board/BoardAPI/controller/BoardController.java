package com.Board.BoardAPI.controller;

import com.Board.BoardAPI.domain.Board;
import com.Board.BoardAPI.domain.User;
import com.Board.BoardAPI.security.JwtTokenProvider;
import com.Board.BoardAPI.service.BoardService;
import com.Board.BoardAPI.service.BoardUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final BoardUserService boardUserService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        boardUserService.createUser(user);

        return "사용자 등록 완료";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        boolean result = boardUserService.login(user);

        if(result == true) {
            return jwtTokenProvider.createToken(user.getUserId());
        } else {
            return "로그인 실패";
        }
    }

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
    public String updateBoard(@RequestBody Board board, @PathVariable Long boardId) {
        board.setBoardId(boardId);
        boardService.updateBoard(board);

        return "게시 글 수정 완료";
    }

    @DeleteMapping("/posts/{boardId}")
    public String deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);

        return "게시 글 삭제 완료";
    }
}
