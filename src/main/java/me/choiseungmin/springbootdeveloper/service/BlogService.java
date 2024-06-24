package me.choiseungmin.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.choiseungmin.springbootdeveloper.domain.Article;
import me.choiseungmin.springbootdeveloper.dto.AddArticleRequest;
import me.choiseungmin.springbootdeveloper.dto.UpdateArticleRequest;
import me.choiseungmin.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // 글 전체 조회
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // 글 단일 조회
    public Article findById(long id) {
        return blogRepository.findById(id) // 없으면 IllegalArgumentException 발생
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id));
    }

    // 글 삭제
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    // 글 수정
    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
