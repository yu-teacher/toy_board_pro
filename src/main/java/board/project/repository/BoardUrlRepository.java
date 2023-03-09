package board.project.repository;

import board.project.entity.BoardUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardUrlRepository extends JpaRepository<BoardUrl,Long> {
}
