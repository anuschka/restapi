package com.anuschka.dog.mutator;

import com.anuschka.dog.entity.Dog;
import com.anuschka.dog.exception.BreedNotFoundExceptionGraphQL;
import com.anuschka.dog.exception.DogNotFoundExceptionGraphQL;
import com.anuschka.dog.repository.DogRepository;
import com.anuschka.dog.service.BreedNotFoundException;
import com.anuschka.dog.service.DogNotFoundException;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed){

        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        //Loop through all dogs to check their breed
        for(Dog d:allDogs){
            if(d.getBreed().equals(breed)){
                //Delete if the breed is found
                dogRepository.delete(d);
                deleted = true;
            }

        }
        if(!deleted){
            throw new BreedNotFoundExceptionGraphQL("Breed not found", breed);
        }
        return deleted;

    }

    public Dog updateDogName(String name, Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if(optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(name);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundExceptionGraphQL("Dog Not Found", id);

        }


    }


}
