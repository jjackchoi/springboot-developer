package me.choiseungmin.springbootdeveloper.repository;

import me.choiseungmin.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
