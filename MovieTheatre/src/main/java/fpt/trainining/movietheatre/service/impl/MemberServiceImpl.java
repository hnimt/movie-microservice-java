package fpt.trainining.movietheatre.service.impl;

import fpt.trainining.movietheatre.dto.account.AccountInfoRes;
import fpt.trainining.movietheatre.dto.account.AccountUpdateReq;
import fpt.trainining.movietheatre.dto.member.MemberReq;
import fpt.trainining.movietheatre.dto.member.MemberRes;
import fpt.trainining.movietheatre.entity.Account;
import fpt.trainining.movietheatre.entity.Member;
import fpt.trainining.movietheatre.entity.common.Roles;
import fpt.trainining.movietheatre.exception.ResourceNotFoundException;
import fpt.trainining.movietheatre.repository.MemberRepository;
import fpt.trainining.movietheatre.service.AccountService;
import fpt.trainining.movietheatre.service.MemberService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final ModelMapper mapper;
    private final MemberRepository memberRepository;
    private final AccountService accountService;

    private MemberRes memberToMemberRes(Member member) {
        MemberRes memberRes = mapper.map(member,MemberRes.class);
        AccountInfoRes accountInfoRes = mapper.map(member.getAccount(), AccountInfoRes.class);
        memberRes.setAccountInfoRes(accountInfoRes);
        return memberRes;
    }

    @Override
    public Member findById(String id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot found member"));
    }

    @Override
    public List<MemberRes> getAll() {
        return memberRepository.findAll()
                .stream()
                .map((member -> {
                    MemberRes memberRes = memberToMemberRes(member);
                    return memberRes;
                }))
                .collect(Collectors.toList());
    }


    @Override
    public MemberRes getById(String id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot found member"));
        return memberToMemberRes(member);
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    @Transactional
    public MemberRes createMember(MemberReq req) {
        Account account = accountService.updateRole(req.getAccountId(), Roles.MEMBER.roleName);
        Member member = mapper.map(req, Member.class);
        member.setAccount(account);
        member = memberRepository.save(member);
        MemberRes res = memberToMemberRes(member);
        return res;
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cannot found this member"));
        accountService.deleteById(member.getAccount().getAccountId());
        memberRepository.deleteById(id);
    }

    @Override
    @Transactional
    public MemberRes updateMember(String id, MemberReq req) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cannot found this member"));
        mapper.map(req, member);
        return memberToMemberRes(member);
    }

    @Override
    public Member findByAccount(Account account) {
        return memberRepository.findByAccount(account)
                .orElseThrow(() -> new ResourceNotFoundException("Cannot found this member"));
    }
}
