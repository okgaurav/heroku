package com.example.heroku;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
    public User createUser(User user){
        return userRepository.save(user);
    }
    public User updateUser(User user){
        Optional<User> user1= userRepository.findById(user.getId());
        User user2 = user1.isPresent()?user1.get():null;
        user2.setName(user.getName());
        userRepository.save(user2);
        return user2;
    }
    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }
}
