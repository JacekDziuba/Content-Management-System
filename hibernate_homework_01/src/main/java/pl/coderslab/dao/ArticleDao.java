package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.beans.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveArticle(Article entity) {
        entityManager.persist(entity);
    }

    public Article findById(Long id) {
        return entityManager.find(Article.class, id);
    }

    public void update(Article entity) {
        entityManager.merge(entity);
    }

    public void delete(Article entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public List<Article> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM Article a");
        List<Article> articles = query.getResultList();
        return articles;
    }
}
