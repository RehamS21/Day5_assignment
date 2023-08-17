package com.example.assinmentd5_week4.Repository;


import com.example.assinmentd5_week4.Model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Library,Integer> {

    Library findLibraryById(Integer id);
    Library findLibraryByEmail(String email);

    @Query("select l from Library l where l.username = ?1 and l.password = ?2")
    Library login(String username, String password);
}
