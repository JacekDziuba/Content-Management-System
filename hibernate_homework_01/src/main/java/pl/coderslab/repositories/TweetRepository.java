package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.beans.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}
