package ys.mp.board_ys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ys.mp.board_ys.entitiy.CommentEntity;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findAllByBoardId(Long boardId);
}
