package com.myboard.board.controller;

import com.myboard.board.dto.BoardDto;
import com.myboard.board.service.BoardService;
import com.myboard.board.utils.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.net.MalformedURLException;

import static com.myboard.type.Category.COMMON;
import static com.myboard.type.Category.PRO;

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
            @Valid @ModelAttribute("board") BoardDto.CreateRequest dto,
            BindingResult bindingResult,
            @RequestParam MultipartFile thumbnail
    ) {
        if (bindingResult.hasErrors()) {
            return "board/createForm";
        }
        Long boardId = boardService.save(dto, thumbnail);

        return "redirect:/board/" + boardId;
    }

    @GetMapping("/common")
    public String commonBoardList(
            Model model,
            @PageableDefault(size = 6, sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<BoardDto.ListResponse> boards = boardService.findAllByCategory(COMMON, pageable);
        model.addAttribute("boards", boards);
        model.addAttribute("categoryTitle", "새싹 회원");
        model.addAttribute("category", "common");
        model.addAttribute("maxPage", 5);

        return "board/boards";
    }
    @GetMapping("/pro")
    public String proBoardList(
            Model model,
            @PageableDefault(size = 6, sort = "id", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<BoardDto.ListResponse> boards = boardService.findAllByCategory(PRO, pageable);
        model.addAttribute("boards", boards);
        model.addAttribute("categoryTitle", "우수 회원");
        model.addAttribute("category", "pro");
        model.addAttribute("maxPage", 5);

        return "board/boards";
    }

    @ResponseBody
    @GetMapping("/image/{filename}")
    public Resource thumbnailImage(@PathVariable String filename) throws MalformedURLException {
        String fullPath = ImageUtils.getFullPath(filename);

        return new UrlResource("file:" + fullPath);
    }
}
