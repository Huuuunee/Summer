package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service
public class        MemberService {

    private final MemberRepository memberRepository;

    //@Autowired  // 멤버 리포지토리를 주입해줌 시작할때
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
    * 회원가입
     */
    public Long join(Member member){
        validateDuplicateMember(member);//중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 있는 유저입니다");
                });
    }

    /**
     * 전체 유저 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
