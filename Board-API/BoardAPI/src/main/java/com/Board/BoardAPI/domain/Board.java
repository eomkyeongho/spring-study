package com.Board.BoardAPI.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    private Long boardId;
    private String title;
    private String writer;
    private String content;
}
