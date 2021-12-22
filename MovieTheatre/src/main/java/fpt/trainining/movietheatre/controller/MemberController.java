package fpt.trainining.movietheatre.controller;

import fpt.trainining.movietheatre.dto.ResponseHandler;
import fpt.trainining.movietheatre.dto.member.MemberReq;
import fpt.trainining.movietheatre.dto.member.MemberRes;
import fpt.trainining.movietheatre.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    @Autowired private MemberService memberService;

    @GetMapping
    public ResponseEntity findAll() {
        List<MemberRes> res = memberService.getAll();
        return ResponseHandler.generateResponse("Find all members successfully!", HttpStatus.OK, res);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody MemberReq req) {
        MemberRes res = memberService.createMember(req);
        return ResponseHandler.generateResponse("Create member successfully!", HttpStatus.CREATED, res);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable String id){
        MemberRes res = memberService.getById(id);
        return ResponseHandler.generateResponse("Find member successfully!", HttpStatus.OK, res);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMember(@PathVariable String id, @RequestBody MemberReq req) {
        MemberRes res = memberService.updateMember(id, req);
        return ResponseHandler.generateResponse("Update member's score successfully!", HttpStatus.OK, res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        memberService.deleteById(id);
        return ResponseHandler.generateResponse("Delete successfully!", HttpStatus.OK, null);
    }
}
