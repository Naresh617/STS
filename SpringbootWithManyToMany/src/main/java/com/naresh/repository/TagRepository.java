package com.naresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naresh.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {

}
