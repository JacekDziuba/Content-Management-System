package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.beans.Article;
import pl.coderslab.beans.Author;
import pl.coderslab.beans.Category;
import pl.coderslab.repositories.ArticleRepository;
import pl.coderslab.repositories.AuthorRepository;
import pl.coderslab.repositories.CategoryRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/addarticle", method = RequestMethod.GET)
    public String showAddArticleForm(Model model) {
        Article article = new Article();
        model.addAttribute("article", article);
        return "addForms/addNewArticle";
    }

    @RequestMapping(value = "/addarticle", method = RequestMethod.POST)
    public String receiveArticleForm(@Valid Article article, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addForms/addNewArticle";
        }
        articleRepository.save(article);
        return "redirect:/homePage";
    }

    @RequestMapping(value = "/updateArticle/{id}", method = RequestMethod.GET)
    public String showUpdateArticleForm(Model model, @PathVariable Long id) {
        Article articleToUpdate = articleRepository.getOne(id);
        model.addAttribute("articleToUpdate", articleToUpdate);
        return "updateForms/updateArticle";
    }

    @RequestMapping(value = "/updateArticle/{id}", method = RequestMethod.POST)
    public String receiveUptadeArticleForm(@ModelAttribute Article articleToUpdate, HttpServletRequest request) {
        articleRepository.save(articleToUpdate);
        return "redirect:/homePage";
    }

    @RequestMapping("/deletearticletoconfirm/{id}")
    public String deletearticletoconfirm(@PathVariable Long id, Model model) {
        model.addAttribute("articleId", id);
        return "deleteForms/deleteArticleToConfirm";
    }

    @RequestMapping("/deletearticle/{id}")
    public String deleteArticle(@PathVariable Long id, HttpServletRequest request) {
        Article articleToDelete = articleRepository.getOne(id);
        articleRepository.delete(articleToDelete);
        return "redirect:/homePage";
    }

    @RequestMapping("/getAllArticles")
    public String getArticles(Model model) {
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articles", articleList);
        return "lists/allArticles";
    }

    @ModelAttribute ("authors")
    public List<Author> getAuthorList() {
        return authorRepository.findAll();
    }

    @ModelAttribute ("categories")
    public List<Category> getCategoryList() {
        return categoryRepository.findAll();
    }

    @RequestMapping("/homePage")
    public String welcomePage() {
        return "homePage";
    }

}
