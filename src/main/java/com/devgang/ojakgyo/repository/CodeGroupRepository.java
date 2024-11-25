package com.devgang.ojakgyo.repository;

import com.devgang.ojakgyo.model.CodeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupRepository extends JpaRepository<CodeGroup, String> {
}
