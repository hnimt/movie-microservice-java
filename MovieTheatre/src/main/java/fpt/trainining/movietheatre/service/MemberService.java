package fpt.trainining.movietheatre.service;

import fpt.trainining.movietheatre.dto.member.MemberReq;
import fpt.trainining.movietheatre.dto.member.MemberRes;
import fpt.trainining.movietheatre.entity.Account;
import fpt.trainining.movietheatre.entity.Member;

import java.util.List;

public interface MemberService {
    List<MemberRes> getAll();
    MemberRes getById(String id);
    Member findById(String id);
    //    MemberRes findMemberByName();

    Member save(Member member);
    MemberRes createMember(MemberReq req);
    MemberRes updateMember(String id, MemberReq req);
    void deleteById(String id);

    Member findByAccount(Account account);
}
