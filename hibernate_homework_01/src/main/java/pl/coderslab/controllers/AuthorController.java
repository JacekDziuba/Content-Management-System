package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.beans.Author;
import pl.coderslab.repositories.AuthorRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(value = "/addauthor", method = RequestMethod.GET)
    public String showAddAuthorForm(Model model) {
        Author author = new Author();
        model.addAttribute("author", author);
        return "addForms/addNewAuthor";
    }

    @RequestMapping(value = "/addauthor", method = RequestMethod.POST)
    public String receiveAuthorForm(@Valid Author author, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addForms/addNewAuthor";
        }
        authorRepository.save(author);
        return "redirect:/homePage";
    }

    @RequestMapping(value = "/updateAuthor/{id}", method = RequestMethod.GET)
    public String showUpdateAuthorForm(Model model, @PathVariable Long id) {
        Author authorToUpdate = authorRepository.getOne(id);
        model.addAttribute("authorToUpdate", authorToUpdate);
        return "updateForms/updateAuthor";
    }

    @RequestMapping(value = "/updateAuthor/{id}", method = RequestMethod.POST)
    public String receiveUptadeCategoryForm(@ModelAttribute Author authorToUpdate, HttpServletRequest request) {
        authorRepository.save(authorToUpdate);
        return "redirect:/homePage";
    }

    @RequestMapping("/deleteauthortoconfirm/{id}")
    public String deleteauthortoconfirm(@PathVariable Long id, Model model) {
        model.addAttribute("authorId", id);
        return "deleteForms/deleteAuthorToConfirm";
    }

    @RequestMapping("/deleteauthor/{id}")
    public String deleteAuthor(@PathVariable Long id, HttpServletRequest request) {
        Author authorToDelete = authorRepository.getOne(id);
        authorRepository.delete(authorToDelete);
        return "redirect:/homePage";
    }

    @RequestMapping("/getAllAuthors")
    public String getAuthors(Model model) {
        List<Author> authorList = authorRepository.findAll();
        model.addAttribute("authors", authorList);
        return "lists/allAuthors";
    }

}
