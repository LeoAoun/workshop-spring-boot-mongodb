package com.leoaoun.workshopmongo.config;

import com.leoaoun.workshopmongo.domain.Post;
import com.leoaoun.workshopmongo.domain.User;
import com.leoaoun.workshopmongo.dtos.AuthorDTO;
import com.leoaoun.workshopmongo.dtos.CommentDTO;
import com.leoaoun.workshopmongo.repositories.PostRepository;
import com.leoaoun.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... arg0) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        //Instantiation User
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        //Instantiation Post with author associated
        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abracos", new AuthorDTO(maria.getId(), maria.getName()));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje", new AuthorDTO(maria.getId(), maria.getName()));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex.getId(), alex.getName()));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob.getId(), bob.getName()));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(alex.getId(), alex.getName()));

        //Associated
        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }

}