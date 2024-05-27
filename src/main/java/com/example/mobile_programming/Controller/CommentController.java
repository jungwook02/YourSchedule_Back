package com.example.mobile_programming.Controller;

import com.example.mobile_programming.Service.CommentService;
import com.example.mobile_programming.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board_ys/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{boardId}")
    public ResponseEntity<List<CommentDTO>> getAllCommentsByBoardId(@PathVariable Long boardId) {
        List<CommentDTO> comments = commentService.findAllByBoardId(boardId);
        return ResponseEntity.ok(comments);
    }

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO) {
        CommentDTO createdComment = commentService.save(commentDTO);
        return ResponseEntity.ok(createdComment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {
        CommentDTO updatedComment = commentService.update(id, commentDTO);
        if (updatedComment != null) {
            return ResponseEntity.ok(updatedComment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}