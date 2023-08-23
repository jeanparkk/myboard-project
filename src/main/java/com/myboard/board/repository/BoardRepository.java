package com.myboard.board.repository;


import com.myboard.board.domain.Board;
import com.myboard.type.Category;
import com.myboard.type.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Page<Board> findAllByCategoryAndStatus(Category category, Status status, Pageable pageable);
}
