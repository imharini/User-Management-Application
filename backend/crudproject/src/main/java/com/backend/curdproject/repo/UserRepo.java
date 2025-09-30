package com.backend.curdproject.repo;

import com.backend.curdproject.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Model,Long> {
}
