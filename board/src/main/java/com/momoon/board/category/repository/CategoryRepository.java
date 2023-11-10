package com.momoon.board.category.repository;

import com.momoon.board.category.domain.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
public interface CategoryRepository {

    Optional<Category> findById(@Param("id") Long id);

}
