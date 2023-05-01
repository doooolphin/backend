package baemin.service;

import baemin.entity.Member;
import baemin.repository.MemberRepository;
import baemin.dto.MemberDto;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
    }

    // 회원가입
    public String join(MemberDto memberDto) {
        Member member = modelMapper.map(memberDto, Member.class);

        validateDuplicateMember(member.getId());//중복 회원 검증
        Member returnMember = memberRepository.save(member);

        return returnMember.getId();
    }

    // 중복 회원 검증
    private void validateDuplicateMember(String id) {
        memberRepository.findById(id)
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    // 정보보기
    public MemberDto findOne(String id) {
        Member member = memberRepository.findById(id).orElseThrow();
        return modelMapper.map(member, MemberDto.class);
    }

    public MemberDto findById(Integer id) {
        MemberDto memberDto = new MemberDto();

        Member member = memberRepository.findById(id).orElseThrow();
        memberDto.setId(member.getId());
        memberDto.setName(member.getName());

        return memberDto;
    }


}
