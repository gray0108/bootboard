package com.gray.bootboard.domain.repository;

import com.gray.bootboard.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
    /* 데이터 조작을 담당하며, JpaRepository를 상속받는다 <Board,Long>은 매핑할 Entity와 Id의 타입 */
}
