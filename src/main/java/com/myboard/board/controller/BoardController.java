package com.myboard.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {

    public String boardCreateForm(Model model) {
        model.addAttribute("board", new BoardDto.CreateRequest());

        return "board/createForm";
    }
}
