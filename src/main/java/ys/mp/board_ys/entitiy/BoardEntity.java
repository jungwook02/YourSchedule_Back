package ys.mp.board_ys.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import ys.mp.board_ys.dto.BoardDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="boardTable")
public class BoardEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String boardWriter;

        @Column
        private String boardTitle;

        @Column(length = 500)
        private String boardContents;

        @CreatedDate
        @Column(name = "created_at", updatable = false)
        private LocalDateTime createdAt;

        @LastModifiedDate
        @Column(name = "updated_at")
        private LocalDateTime updatedAt;

        public static BoardEntity toSaveEntity(BoardDTO boardDTO) {

            BoardEntity boardEntity = new BoardEntity();
            boardEntity.setBoardWriter(boardDTO.getBoardWriter());
            boardEntity.setBoardTitle(boardDTO.getBoardTitle());
            boardEntity.setBoardContents(boardDTO.getBoardContents());
            return boardEntity;
        }

        public static BoardEntity toUpdateEntity(BoardDTO boardDTO) {
            BoardEntity boardEntity = new BoardEntity();
            boardEntity.setId(boardDTO.getId());
            boardEntity.setBoardWriter(boardDTO.getBoardWriter());
            boardEntity.setBoardTitle(boardDTO.getBoardTitle());
            boardEntity.setBoardContents(boardDTO.getBoardContents());
            return boardEntity;
        }
    }