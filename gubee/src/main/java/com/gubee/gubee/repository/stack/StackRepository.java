package com.gubee.gubee.repository.stack;

import com.gubee.gubee.model.entity.stack.Stack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StackRepository extends JpaRepository<Stack, Integer> {
}
