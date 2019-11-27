package com.jchm.soapwsapp.service;

import com.jchm.soapwsapp.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;


@Service
public class UserService {

    private static final HashMap<String, User> users = new HashMap<>();

    @PostConstruct
    public void initialize(){

        ArrayList<Object> directories = listAllFolders("C:/Users/Consultor2015/Documents/test");

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
/*
    public void listAllFiles(String path){
        try(Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    try {
                        readContent(filePath);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

*/
    public ArrayList<Object>  listAllFolders(String path){

        Object[] arrayTest = new Object[100];
        ArrayList<Object> newObj = new ArrayList<Object>(Arrays.asList(arrayTest));


        try(Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths.forEach(filePath -> {
                if (Files.isDirectory(filePath)) {
                    try {
                        newObj.add(filePath);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return newObj;
    }

}
