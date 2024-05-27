package com.example.mobile_programming.Controller;

import com.example.mobile_programming.Service.BoardService;
import com.example.mobile_programming.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board_ys")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping
    public List<BoardDTO> getAllBoard() {
        return boardService.findAll();
    }


    @PostMapping
    public ResponseEntity<BoardDTO> createBoard(@RequestBody BoardDTO boardDTO) {
        BoardDTO createdBoard = boardService.save(boardDTO);
        return ResponseEntity.ok(createdBoard);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BoardDTO> getBoardById(@PathVariable Long id) {
        BoardDTO boardDTO = boardService.findById(id);
        if (boardDTO != null) {
            return ResponseEntity.ok(boardDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardDTO> updateBoard(@PathVariable Long id, @RequestBody BoardDTO boardDTO) {
        BoardDTO existingBoard = boardService.findById(id);
        if (existingBoard == null) {
            return ResponseEntity.notFound().build();
        }

        boardDTO.setId(id);
        BoardDTO updatedBoard = boardService.update(boardDTO);
        return ResponseEntity.ok(updatedBoard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        BoardDTO boardDTO = boardService.findById(id);
        if (boardDTO == null) {
            return ResponseEntity.notFound().build();
        }
        boardService.delete(id);
        return ResponseEntity.noContent().build();
    }

}