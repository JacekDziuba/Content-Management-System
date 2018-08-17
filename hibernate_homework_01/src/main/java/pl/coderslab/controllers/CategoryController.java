package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.beans.Category;
import pl.coderslab.repositories.CategoryRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/addcategory", method = RequestMethod.GET)
    public String showAddCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "addForms/addNewCategory";
    }

    @RequestMapping(value = "/addcategory", method = RequestMethod.POST)
    public String receiveCategoryForm(@Valid Category category, BindingResult result, HttpServletRequest request) {
        if(result.hasErrors()) {
            return "addForms/addNewCategory";
        }
        categoryRepository.save(category);
        return "redirect:/homePage";
    }

    @RequestMapping(value = "/updateCategory/{id}", method = RequestMethod.GET)
    public String showUpdateCategoryForm(Model model, @PathVariable Long id) {
        Category categoryToUpdate = categoryRepository.getOne(id);
        model.addAttribute("categoryToUpdate", categoryToUpdate);
        return "updateForms/updateCategory";
    }

    @RequestMapping(value = "/updateCategory/{id}", method = RequestMethod.POST)
    public String receiveUptadeCategoryForm(@ModelAttribute Category categoryToUpdate, HttpServletRequest request) {
        categoryRepository.save(categoryToUpdate);
        return "redirect:/homePage";
    }

    @RequestMapping("/deletecategorytoconfirm/{id}")
    public String deletecategorytoconfirm(@PathVariable Long id, Model model) {
        model.addAttribute("categoryId", id);
        return "deleteForms/deleteCategoryToConfirm";
    }

    @RequestMapping("/deletecategory/{id}")
    public String deleteAuthor(@PathVariable Long id, HttpServletRequest request) {
        Category categoryToDelete = categoryRepository.getOne(id);
        categoryRepository.delete(categoryToDelete);
        return "redirect:/homePage";
    }

    @RequestMapping("/getAllCategories")
    public String getAuthors(Model model) {
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categories", categoryList);
        return "lists/allCategories";
    }

}
