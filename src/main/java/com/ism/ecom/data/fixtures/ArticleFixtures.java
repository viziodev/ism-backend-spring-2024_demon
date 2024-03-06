package com.ism.ecom.data.fixtures;


import com.ism.ecom.data.entities.Article;

import com.ism.ecom.data.entities.Categorie;
import com.ism.ecom.data.repositories.ArticleRepository;
import com.ism.ecom.data.repositories.CategorieRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
@Order(2)
public class ArticleFixtures implements CommandLineRunner {
    private final ArticleRepository articleRepository;
    private final CategorieRepository categorieRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Article> articleList=new ArrayList<Article>();
        for (int i = 1; i <= 5; i++) {
            Categorie categorie = categorieRepository.findById(Long.valueOf(i)).get();
            for (int j = 0; j < 5; j++) {
                Random random = new Random();
                int randomNumber = random.nextInt(100) + j;
                Article article = new Article(String.format("Article %d", randomNumber), 10000.0, 8000.0, false, i * j, "", null);
                article.setActive(j%2==0);
                articleList.add(article);
            }
        }
        articleRepository.saveAllAndFlush(articleList);
    }
}
