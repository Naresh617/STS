package com.naresh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.naresh.model.Post;
import com.naresh.model.Tag;
import com.naresh.repository.PostRepository;
import com.naresh.repository.TagRepository;

@SpringBootApplication
public class SpringbootWithManyToManyApplication implements CommandLineRunner {

	@Autowired
    private TagRepository tagRepository;

    @Autowired
    private PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWithManyToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		postRepository.deleteAllInBatch();
        tagRepository.deleteAllInBatch();

		Post post = new Post("Hibernate Many to Many Example with Spring Boot",
                "Learn how to map a many to many relationship using jpa",
                "Entire Post content with Sample code");
		
		Tag tag1 = new Tag("Spring Boot");
        Tag tag2 = new Tag("jpa");
        
        post.getTags().add(tag1);
        post.getTags().add(tag2);
        
        tag1.getPosts().add(post);
        tag2.getPosts().add(post);
        
        postRepository.save(post);
        
	}

}
