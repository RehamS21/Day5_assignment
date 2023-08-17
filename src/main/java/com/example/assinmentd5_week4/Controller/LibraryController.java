package com.example.assinmentd5_week4.Controller;

import com.example.assinmentd5_week4.Api.ApiResponse;
import com.example.assinmentd5_week4.Model.Library;
import com.example.assinmentd5_week4.Service.LibraryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/lib")
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;

    @GetMapping("/get")
    public ResponseEntity getAllLibraries(){

        return ResponseEntity.status(200).body(libraryService.getAllLibrary());
    }

    @PostMapping("/add")
    public ResponseEntity addNewLibrary(@RequestBody @Valid Library library){
        libraryService.addLibrary(library);
        return ResponseEntity.status(200).body(new ApiResponse("New library added successfully"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateLibrary(@PathVariable Integer id, @RequestBody @Valid Library library){

        libraryService.updateLibrary(id, library);

        return ResponseEntity.status(200).body(new ApiResponse("Updated the library successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrary(@PathVariable Integer id){
        libraryService.deleteLibrary(id);
        return ResponseEntity.status(200).body(new ApiResponse("The library deleted successfully"));
    }

    @GetMapping("/oneLibrary/{id}")
    public ResponseEntity getOneLibrary(@PathVariable Integer id){

        return ResponseEntity.status(200).body(libraryService.getLibraryId(id));
    }

    @GetMapping("/check/{username}/{password}")
    public ResponseEntity getCoffeeCategory(@PathVariable String username, @PathVariable String password){
        return ResponseEntity.status(200).body(libraryService.checkLogin(username,password));
    }

    @GetMapping("/account/{email}")
    public ResponseEntity getLibAccount(@PathVariable String email){
        return ResponseEntity.status(200).body(libraryService.librarian_Account(email));
    }


}
