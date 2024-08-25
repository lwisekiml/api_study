package springtest.demo.testproject_serverBox.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springtest.demo.testproject_serverBox.dto.MemberDTO;

@RestController
@RequestMapping("/api/server")
public class TestController {

    private final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test-hub")
    public String getTest1() {
        LOGGER.info("getTest1 호출!");
        return "Hello. getTest1";
    }

    @GetMapping("/name")
    public String getTest2(@RequestParam String name) {
        LOGGER.info("getTest2 호출!");
        return "Hello. " + name + "!!!";
    }

    @GetMapping("/path-variable/{name}")
    public String getTest3(@PathVariable String name) {
        LOGGER.info("getTest3 호출!");
        return "Hello. " + name + "!!!";
    }

    @PostMapping("/member")
    public ResponseEntity<MemberDTO> getMember(
            @RequestBody MemberDTO memberDTO,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization
    ) {

        LOGGER.info("getMember 호출!");

        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);

//        MemberDTO memberDTO1 = new MemberDTO();
//        memberDTO1.setName(name);
//        memberDTO1.setEmail(email);
//        memberDTO1.setOrganization(organization);
//
//        return ResponseEntity.status(HttpStatus.OK).body(memberDTO1);
    }

    @PostMapping("/add-header")
    public ResponseEntity<MemberDTO> addHeader(@RequestHeader("test-header") String header, @RequestBody MemberDTO memberDTO) {

        LOGGER.info("add-header 호출!");
        LOGGER.info("header 값 : {}", header);

//        return memberDTO.getName() + " " + memberDTO.getEmail() + " " + memberDTO.getOrganization();
        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
    }
}
