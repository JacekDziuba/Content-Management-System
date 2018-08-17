package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.beans.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveCategory(Category entity) {
        entityManager.persist(entity);
    }

    public Category findById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public void update(Category entity) {
        entityManager.merge(entity);
    }

    public void delete(Category entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    public List<Category> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM Category a");
        List<Category> categories = query.getResultList();
        return categories;
    }
}
