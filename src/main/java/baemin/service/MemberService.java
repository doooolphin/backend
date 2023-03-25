package baemin.service;

import baemin.entity.Member;
import baemin.repository.MemberRepository;
import baemin.vo.MemberVo;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Transactional
@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public Boolean save(MemberVo memberVo) {

        Member member = new Member();
        member.setName(memberVo.getName());
        try {
            memberRepository.save(member);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }

        return true;
    }

}
