package com.anuschka.dog.service;

import com.anuschka.dog.entity.Dog;
import com.anuschka.dog.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    DogRepository dogRepository;

    public List<Dog> retrieveDogs(){
        return (List<Dog>)dogRepository.findAll();
    }

    public List<String> retrieveDogBreed(){return (List<String>)dogRepository.findAllBreed();};

    public String retrieveDogBreedById(Long id){

        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));

        if(!optionalBreed.isPresent()){
            throw new DogNotFoundException();
        }
        String breed = dogRepository.findBreedById(id);
        return breed;

    };

    public List<String> retrieveDogNames(){return (List<String>)dogRepository.findAllName();};


}
