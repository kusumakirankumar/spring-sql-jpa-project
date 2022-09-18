package curd.h2.spring.sercvice;

import curd.h2.spring.entity.User;
import curd.h2.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User addUser(User user){
        return userRepository.save(user);
    }
    public List<User> addUsers(List<User> users){
        return userRepository.saveAll(users);
    }
    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User updateUser(User user){
        User oldUser = userRepository.findById(user.getId()).orElse(null);
        if (oldUser!=null){
            oldUser.setName(user.getName());
            oldUser.setAddress(user.getAddress());
            oldUser.setNumber(user.getNumber());
            oldUser.setEmail(user.getEmail());
            return userRepository.save(user);
        }else {
            return userRepository.save(new User());
        }
    }
    public String deleteUser(int id){
        userRepository.deleteById(id);
        return "USER DELETED..";
    }
}
