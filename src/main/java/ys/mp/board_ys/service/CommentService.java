package ys.mp.board_ys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ys.mp.board_ys.dto.CommentDTO;
import ys.mp.board_ys.entitiy.CommentEntity;
import ys.mp.board_ys.repository.CommentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<CommentDTO> findAllByBoardId(Long boardId) {
        return commentRepository.findAllByBoardId(boardId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CommentDTO save(CommentDTO commentDTO) {
        CommentEntity commentEntity = convertToEntity(commentDTO);
        CommentEntity savedEntity = commentRepository.save(commentEntity);
        return convertToDTO(savedEntity);
    }

    public CommentDTO update(Long id, CommentDTO commentDTO) {
        CommentEntity existingEntity = commentRepository.findById(id).orElse(null);
        if (existingEntity == null) {
            return null; // or throw an exception
        }
        existingEntity.setContent(commentDTO.getContent());
        CommentEntity updatedEntity = commentRepository.save(existingEntity);
        return convertToDTO(updatedEntity);
    }

    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    private CommentDTO convertToDTO(CommentEntity commentEntity) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(commentEntity.getId());
        commentDTO.setBoardId(commentEntity.getBoardId());
        commentDTO.setContent(commentEntity.getContent());
        commentDTO.setCreatedAt(commentEntity.getCreatedAt());
        return commentDTO;
    }

    private CommentEntity convertToEntity(CommentDTO commentDTO) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setBoardId(commentDTO.getBoardId());
        commentEntity.setContent(commentDTO.getContent());
        return commentEntity;
    }
}