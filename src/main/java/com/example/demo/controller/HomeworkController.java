package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("homework")
public class HomeworkController {

    @GetMapping("getSomething")
    public ResponseEntity<String> getSomething(@PathVariable String string) {
        return ResponseEntity.ok(string);
    }

    @GetMapping(value = "/getSomething", params = {"string"})
    public ResponseEntity<String> getSomethingElse(@RequestParam String string) {
        return ResponseEntity.ok(string);
    }

    @PutMapping("putSomething")
    public ResponseEntity<String> method() {return ResponseEntity.ok("To do");}


}
