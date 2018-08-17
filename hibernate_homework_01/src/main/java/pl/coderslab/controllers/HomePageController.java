package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.beans.Article;
import pl.coderslab.beans.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Controller
public class HomePageController {

    @PersistenceContext
    EntityManager entityManager;

    @RequestMapping("/lastfive")
    public String action(Model model) {
//        Query query = entityManager.createQuery("SELECT title, SUBSTRING(content,1,200), created FROM Article a");
        Query query = entityManager.createQuery("SELECT a FROM Article a");
        query.setMaxResults(5);
        List<Article> articles = query.getResultList();
        model.addAttribute("articles", articles);

        //spróbuj dodać GROUP BY
        Query query1 = entityManager.createQuery("SELECT c FROM Category c");
        List<Category> categories = query1.getResultList();
        model.addAttribute("categories", categories);
        return "homepage";
    }

    @RequestMapping("/Dark Comedy")
    public String action1(Model model) {
        Query query = entityManager.createQuery("SELECT c FROM Category c WHERE name =:name");
        query.setParameter("name", "Dark Comedy");
        List<Category> darkComedies = query.getResultList();
        model.addAttribute("darkComedies", darkComedies);
        return "Dark Comedy";
    }

    @RequestMapping("/Short stories")
    public String action2(Model model) {
        Query query = entityManager.createQuery("SELECT c FROM Category c WHERE name =:name");
        query.setParameter("name", "Short stories");
        List<Category> shortStories = query.getResultList();
        model.addAttribute("shortStories", shortStories);
        return "Short stories";
    }

    @RequestMapping("/Fantasy")
    public String action3(Model model) {
        Query query = entityManager.createQuery("SELECT c FROM Category c WHERE name =:name");
        query.setParameter("name", "Fantasy");
        List<Category> fantasy = query.getResultList();
        model.addAttribute("Fantasy", fantasy);
        return "Fantasy";
    }
}
