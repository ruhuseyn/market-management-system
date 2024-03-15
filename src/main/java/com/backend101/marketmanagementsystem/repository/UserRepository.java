package com.backend101.marketmanagementsystem.repository;

import com.backend101.marketmanagementsystem.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, String> {

}
