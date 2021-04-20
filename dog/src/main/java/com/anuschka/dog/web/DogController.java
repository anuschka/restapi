package com.anuschka.dog.web;

import com.anuschka.dog.entity.Dog;
import com.anuschka.dog.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/*
 *This marks a class as a REST API. @RestController is a convenience annotation that combines @Controller and @ResponseBody.
 */
@RestController
public class DogController {

    private DogService dogService;

    /* It allows Spring to resolve and inject collaborating beans into our bean.
     *
     */

    @Autowired
    public void setDogService(DogService dogService){
        this.dogService = dogService;
    }

    /*
     * This annotation handles HTTP GET requests and acts as a shortcut for @RequestMapping (method = RequestMethod.GET).
     */
    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs(){
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/breeds")
    public ResponseEntity<List<String>> getAllBreeds() {
        List<String> list = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);

    }

    @GetMapping("/dogs/names")
    public ResponseEntity<List<String>> getAllNames() {
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);

    }

    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getBreedById(@PathVariable Long id) {
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);

    }

}
