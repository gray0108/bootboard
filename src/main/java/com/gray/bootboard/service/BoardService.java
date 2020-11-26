package com.gray.bootboard.service;

import com.gray.bootboard.dao.BoardDao;
import com.gray.bootboard.domain.entity.Board;
import com.gray.bootboard.domain.repository.BoardRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService { /* Repository를 사용하여 Service를 구현, Form형식으로 내용을 입력받아,
 글쓰기 버튼을 누르면 POST형식으로 요청이 오고, BoardService의 savePost()를 실행 */
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
    @Transactional
    public Long savePost(BoardDao boardDao) {
        return boardRepository.save(boardDao.toEntity()).getId();
    }

    @Transactional
    public List<BoardDao> getBoardList() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardDao> boardDaoList = new ArrayList<>();

        for(Board board : boardList) {
            BoardDao boardDao = BoardDao.builder()
                    .id(board.getId())
                    .author(board.getAuthor())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .createdDate(board.getCreatedDate())
                    .build();
            boardDaoList.add(boardDao);
        }
        return boardDaoList;
    }

    @Transactional
    public BoardDao getPost(Long id) {
        Board board = boardRepository.findById(id).get();

        BoardDao boardDao = BoardDao.builder()
                .id(board.getId())
                .author(board.getAuthor())
                .title(board.getTitle())
                .content(board.getTitle())
                .createdDate(board.getCreatedDate())
                .build();
        return boardDao;
    }
}
