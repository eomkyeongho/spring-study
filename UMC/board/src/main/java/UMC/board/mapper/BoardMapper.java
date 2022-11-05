package UMC.board.mapper;

import UMC.board.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {
    int boardCount();

    List<Board> getList();

    Board getBoard(Long boardId);

    void uploadBoard(Board board);

    void deleteBoard(Long boardId);

    void updateBoard(Board board);

    void increaseRead(Long boardId);
}
