package com.gubee.gubee.resource.stack;

import com.gubee.gubee.service.stack.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stack")
public class StackResource {

    final StackService stackService;

    @Autowired
    public StackResource(StackService stackService) {
        this.stackService = stackService;
    }

    @GetMapping
    public ResponseEntity<?> getAllStacks() {
        return ResponseEntity.ok(stackService.getAll());
    }
}
