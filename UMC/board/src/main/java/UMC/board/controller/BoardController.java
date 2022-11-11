package UMC.board.controller;

import UMC.board.domain.Board;
import UMC.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    @GetMapping("/hello")
    public String hello() {
        return "boards/hello";
    }

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("list", service.boardList());

        return "boards/main";
    }

    @GetMapping("/view")
    public String viewBoard(Model model, Long boardId) {
        service.increaseRead(boardId);
        model.addAttribute("halo", service.getBoard(boardId));

        return "boards/view";
    }

    @GetMapping("/upload")
    public String uploadBoardForm() {
        return "boards/upload";
    }

    @PostMapping("/upload")
    public String uploadBoard(Board board) {
        service.uploadBoard(board);
        return "redirect:/board/main";
    }

    @GetMapping("/delete")
    public String deleteBoard(Long boardId) {
        service.deleteBoard(boardId);
        return "redirect:/board/main";
    }

    @GetMapping("/update")
    public String updateBoardForm(Model model, Long boardId) {
        model.addAttribute("halo", service.getBoard(boardId));
        return "boards/update";
    }

    @PostMapping("/update")
    public String updateBoard(Board board) {
        service.updateBoard(board);
        return "redirect:/board/view?boardId=" + board.getBoardId();
    }
}
