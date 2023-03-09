package board.project.repository;

import board.project.entity.Board;
import board.project.entity.BoardLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardLikeRepository extends JpaRepository<BoardLike,Long> {
}
