package me.choiseungmin.springbootdeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public ResponseEntity<List<?>> test(Member member) {
        List<Member> members = testService.getAllMembers();
        return ResponseEntity.status(HttpStatus.OK).body(members);
    }

}
