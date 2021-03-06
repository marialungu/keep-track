package com.keeptrack.service;

import com.keeptrack.dto.BoardDto;
import com.keeptrack.dto.BoardDtoTransformer;
import com.keeptrack.entity.Board;
import com.keeptrack.entity.Note;
import com.keeptrack.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardDtoTransformer boardDtoTransformer;

    public List<BoardDto> getAllBoards() {
        return boardRepository.findAll().stream()
                .map( board -> boardDtoTransformer.transform(board))
                .collect(Collectors.toList());
    }

    public void deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
    }

    public void createBoard(BoardDto boardDto) {
        Board board = new Board();
        boardSetter(boardDto, board);
        boardRepository.save(board);
    }

    private void boardSetter(BoardDto boardDto, Board board) {
        board.setBoardColor(boardDto.getBoardColor());
        board.setBoardName(boardDto.getBoardName());
//        board.setUserId(boardDto.getUserId());
    }

    public void updateBoard(BoardDto boardDto) {
        Board board = boardRepository.getOne(boardDto.getBoardId());
        boardSetter(boardDto, board);
        boardRepository.save(board);
    }
}
