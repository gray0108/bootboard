package com.gray.bootboard.controller;

import com.gray.bootboard.dao.BoardDao;
import com.gray.bootboard.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/") /* 목록 출력 */
    public String list(Model model) {
        List<BoardDao> boardDaoList = boardService.getBoardList();
        model.addAttribute("postList",boardDaoList);
        return "board/list.html";
    }
    @GetMapping("/post")
    public String post(){
        return "board/post.html";
    }

    @PostMapping("/post")
    public String write(BoardDao boardDao) {
        boardService.savePost(boardDao);
        return "redirect:/";
    }

    @GetMapping("/post/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        BoardDao boardDao = boardService.getPost(id);
        model.addAttribute("post", boardDao);
        return "board/detail.html";
    }

    @GetMapping("/post/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        BoardDao boardDao = boardService.getPost(id);
        model.addAttribute("post",boardDao);
        return "board/edit.html";
    }
}
