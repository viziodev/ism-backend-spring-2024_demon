package com.ism.ecom.services.impl;

import com.ism.ecom.data.entities.Article;
import com.ism.ecom.data.repositories.ArticleRepository;
import com.ism.ecom.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    @Override
    public List<Article> getArticlesFormComande() {
        return articleRepository.findAllByActiveTrue();
    }
}
