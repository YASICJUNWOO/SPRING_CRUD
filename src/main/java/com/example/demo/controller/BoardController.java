package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.domain.BoardRepository;
import com.example.demo.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    private BoardRepository boardRepository = BoardRepository.getInstance();

    @RequestMapping("/form")
    public String board() {
        return "response/board/form";
    }

    @RequestMapping("/save")
    public String save(@RequestParam Integer authId,@RequestParam String authName,
    @RequestParam String title, @RequestParam String content) {
        Board board = new Board(authId, authName, title, content);
        boardRepository.save(board);
        return "redirect:list";
    }

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("boards",boardRepository.findAll());
        return "response/board/list";
    }

}
