package com.example.service;

import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository repo;
    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }
    public void save(User user) {
        repo.save(user);
    }


    public User get(Integer id) throws UserNotFoundException{
        //chequea si el usuario esta o no
        Optional<User> result= repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("could not find any users with ID"+ id);
    }

    public void delete(Integer id) throws UserNotFoundException{
        Long count = repo.countById(id);
        if(count==null || count==0){
            throw new UserNotFoundException("could not find any users with ID"+ id);

        }
        repo.deleteById(id);
    }

}
