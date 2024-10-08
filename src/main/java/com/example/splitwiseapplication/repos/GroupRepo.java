package com.example.splitwiseapplication.repos;

import com.example.splitwiseapplication.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<Group, Long> {

}
