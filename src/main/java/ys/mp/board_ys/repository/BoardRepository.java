package ys.mp.board_ys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ys.mp.board_ys.entitiy.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity,Long> {
}
