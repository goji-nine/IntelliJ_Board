package com.jisoo.board.controller;

import com.jisoo.board.dto.BoardDTO;
import com.jisoo.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/save")
    public String save(){
        return "save";
    }

    @PostMapping("/save")
    public String save(BoardDTO boardDTO) throws IOException {
        System.out.println("boardDTO = " + boardDTO);
        boardService.save(boardDTO);
        return "index";
    }

    @GetMapping("/list")
    public String findAll(Model model) {
        List<BoardDTO> boardDDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDDTOList);
        System.out.println("boardDDTOList =" + boardDDTOList);
        return "list";
    }
}
