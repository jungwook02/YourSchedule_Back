package com.example.mobile_programming.Repository;

import com.example.mobile_programming.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findAllByBoardId(Long boardId);
}