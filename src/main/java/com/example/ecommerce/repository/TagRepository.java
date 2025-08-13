package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
