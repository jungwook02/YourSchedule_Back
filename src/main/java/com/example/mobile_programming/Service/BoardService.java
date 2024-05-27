package com.example.mobile_programming.Service;

import com.example.mobile_programming.Entity.BoardEntity;
import com.example.mobile_programming.Repository.BoardRepository;
import com.example.mobile_programming.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<BoardDTO> findAll() {
        return boardRepository.findAll().stream()
                .map(BoardDTO::toBoardDTO)
                .collect(Collectors.toList());
    }

    public BoardDTO save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        BoardEntity savedEntity = boardRepository.save(boardEntity);
        return BoardDTO.toBoardDTO(savedEntity);
    }

    public BoardDTO findById(Long id) {
        return boardRepository.findById(id)
                .map(BoardDTO::toBoardDTO)
                .orElse(null);
    }

    public BoardDTO update(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toUpdateEntity(boardDTO);
        BoardEntity updatedEntity = boardRepository.save(boardEntity);
        return BoardDTO.toBoardDTO(updatedEntity);
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}