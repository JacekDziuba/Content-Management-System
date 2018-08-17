package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.beans.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
