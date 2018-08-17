package pl.coderslab.beans;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tweeter_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Nullable
    @Email
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tweet> tweetList = new ArrayList<>();

    //GETTERS_and_SETTERS
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Nullable
    public String getEmail() {
        return email;
    }
    public void setEmail(@Nullable String email) {
        this.email = email;
    }
    public List<Tweet> getTweetList() {
        return tweetList;
    }
    public void setTweetList(List<Tweet> tweetList) {
        this.tweetList = tweetList;
    }
}
