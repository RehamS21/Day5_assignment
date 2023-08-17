package com.example.assinmentd5_week4.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title must not null")
    @Column(columnDefinition = "varchar(40) not null")
    private String title;

    @NotEmpty(message = "author must not null")
    @Column(columnDefinition = "varchar(20) not null")
    private String author;

    @NotEmpty(message = "category must not null")
    @Column(columnDefinition = "varchar(20) not null, check ( category = 'academic' or category = 'mystery' or category = 'novel' )")
    private String category;

    @NotNull(message = "ISBN must not null")
    @Column(columnDefinition = "int(30) not null")
    private Integer ISBN;

    @NotNull(message = "num of pages must not null")
    @Min(51)
    @Column(columnDefinition = "int(255) not null, check( numOfPages > 50 )")
    private Integer numOfPages;
}
