package com.myboard.board.controller;

import com.myboard.board.dto.BoardDto;
import com.myboard.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping("/board")
@Controller
public class BoardController {

    private final BoardService boardService;

    public String boardCreateForm(Model model) {
        model.addAttribute("board", new BoardDto.CreateRequest());

        return "board/createForm";
    }

    @PostMapping
    public String createBoard(
            @ModelAttribute BoardDto.CreateRequest dto,
            @RequestParam MultipartFile thumbnail
    ) {
        Long boardId = boardService.save(dto, thumbnail);

        return "redirect:/board/" + boardId;
    }
}
