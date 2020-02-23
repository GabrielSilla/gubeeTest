package com.gubee.gubee.service.stack;

import com.gubee.gubee.model.entity.stack.Stack;
import com.gubee.gubee.repository.stack.StackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StackService {

    final StackRepository stackRepository;

    @Autowired
    public StackService(StackRepository stackRepository) {
        this.stackRepository = stackRepository;
    }

    public List<Stack> getAll() { return stackRepository.findAll(); }
    public List<Stack> saveAll(List<Stack> stack) { return stackRepository.saveAll(stack); }
}
