package baemin.service;

import baemin.entity.Member;
import baemin.exception.MemberException;
import baemin.repository.MemberRepository;
import baemin.dto.MemberDto;
import jakarta.transaction.Transactional;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    private final JavaMailSender mailSender;

    // 이메일 내용
    public MimeMessage createMessage(String to, String authKey) throws MessagingException, UnsupportedEncodingException {

        log.info("보낼 사용자 : "+to);

        //msg 내용
        String msg = "";
        msg += "<h2>안녕하세요.</h2>";
        msg += "<h2>Dooophin 입니다.</h2>";
        msg += "<br>";
        msg += "<p>아래 인증코드를 페이지에 입력해주세요.</p>";
        msg += "<br>";
        msg += "<br>";
        msg += "<div align='center' style='border:1px solid black'>";
        msg += "<h3 style='color:BlueViolet'>인증코드 입니다.</h3>";
        msg += "<div style='font-size:130%'>";
        msg += "<strong>" + authKey + "</strong></div><br/>" ;

        MimeMessage message = mailSender.createMimeMessage();
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  //메일 받을 사용자
        message.setFrom(new InternetAddress("ohi2262@naver.com", "Dooolphin_Admin"));
        message.setSubject("[Dooolphin] 이메일 인증을 위한 인증코드 입니다.");
        message.setText(msg, "utf-8", "html");

        return message;
    }

    // 랜덤 인증코드 생성
    public String createAuthKey() {
        int leftLimit = 48; // num '0'
        int rightLimit = 122; // letter 'z'
        int targetLength = 10;
        Random random = new Random();
        String authKey = random.ints(leftLimit, rightLimit + 1)
                                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)) // 아스키코드 범위 지정
                                .limit(targetLength)
                                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append) // StringBuiler 객체 생성
                                .toString();

        log.info("생성된 랜덤 인증코드 : "+authKey);
        return authKey;
    }

    // 이메일 발송
    public String emailConfirm(String to) throws UnsupportedEncodingException, MessagingException {
        String authKey = createAuthKey(); // 인증코드 생성
        MimeMessage message = createMessage(to, authKey); // 메일 발송

        mailSender.send(message);

        return authKey;
    }

    // 회원가입
    public String join(MemberDto memberDto) {
        Member member = modelMapper.map(memberDto, Member.class);

        validateDuplicateMember(member.getId());//중복 회원 검증

        return memberRepository.save(member).getId();
    }

    // 중복 회원 검증
    private void validateDuplicateMember(String id) {
        memberRepository.findById(id)
            .ifPresent(m -> {
                throw new MemberException(HttpStatus.CONFLICT, "이미 존재하는 회원입니다. -> "+id);
            });
    }

    // 회원 정보보기
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
