package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.beans.Tweet;
import pl.coderslab.beans.User;
import pl.coderslab.repositories.TweetRepository;
import pl.coderslab.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class TweetController {
    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/addTweet", method = RequestMethod.GET)
    public String showAddTweetForm(Model model) {
        Tweet tweet = new Tweet();
        model.addAttribute("tweet", tweet);
        return "addForms/addNewTweet";
    }

    @RequestMapping(value = "/addTweet", method = RequestMethod.POST)
    public String receiveTweetForm(@Valid Tweet tweet, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addForms/addNewTweet";
        }
        tweetRepository.save(tweet);
        return "redirect:/homePage";
    }

    @ModelAttribute("users")
    public List<User> getAuthorList() {
        return userRepository.findAll();
    }


}
