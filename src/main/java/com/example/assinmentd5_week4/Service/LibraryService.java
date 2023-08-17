package com.example.assinmentd5_week4.Service;


import com.example.assinmentd5_week4.Api.ApiException;
import com.example.assinmentd5_week4.Model.Library;
import com.example.assinmentd5_week4.Repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public List<Library> getAllLibrary(){
        return libraryRepository.findAll();
    }

    public void addLibrary(Library library){
        libraryRepository.save(library);
    }

    public void updateLibrary(Integer id, Library library){
        Library oldLibrary = libraryRepository.findLibraryById(id);

        if (oldLibrary == null)
            throw new ApiException("library not found");

        oldLibrary.setName(library.getName());
        oldLibrary.setUsername(library.getUsername());
        oldLibrary.setPassword(library.getPassword());
        oldLibrary.setEmail(library.getEmail());

        libraryRepository.save(oldLibrary);

    }

    public void deleteLibrary(Integer id){
        Library deleteLibrary = libraryRepository.findLibraryById(id);

        if (deleteLibrary == null)
            throw new ApiException("library not found");

        libraryRepository.delete(deleteLibrary);
    }

    public Library getLibraryId(Integer id){
        Library library = libraryRepository.findLibraryById(id);

        if (library == null )
            throw new ApiException("library not found");

        return library;
    }

    public Library checkLogin(String username, String password){
        Library library = libraryRepository.login(username,password);

        if (library == null)
            throw new ApiException("can't login something wrong in username or password");

        return library;
    }

    public Library librarian_Account (String email){
        Library libraryAccount = libraryRepository.findLibraryByEmail(email);

        if (libraryAccount == null)
            throw new ApiException("Account not found");

        return libraryAccount;
    }

}
