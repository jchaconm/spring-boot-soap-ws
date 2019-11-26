package com.jchm.soapwsapp.service;

import com.jchm.soapwsapp.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;


@Service
public class UserService {

    private static final HashMap<String, User> users = new HashMap<>();

    @PostConstruct
    public void initialize(){

        User baby = new User();
        baby.setName("Baby");
        baby.setEmpId(1);
        baby.setSalary(4000);

        User roger = new User();
        roger.setName("Roger");
        roger.setEmpId(2);
        roger.setSalary(300.7);


        User sora = new User();
        roger.setName("Sora");
        roger.setEmpId(3);
        roger.setSalary(999);

        users.put(roger.getName(), roger);
        users.put(sora.getName() , sora);
        users.put(baby.getName() , baby);
    }

    public User getUsers(String name){
      return users.get(name);
    }

}
