package com.anuschka.dog.resolver;

import com.anuschka.dog.entity.Dog;
import com.anuschka.dog.exception.DogNotFoundExceptionGraphQL;
import com.anuschka.dog.repository.DogRepository;
import com.anuschka.dog.service.DogNotFoundException;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    private DogRepository dogRepository;

    public Query(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        } else {
            throw new DogNotFoundExceptionGraphQL("Dog not found", id);
        }
    }

}
