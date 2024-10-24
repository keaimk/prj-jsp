package com.example.prjjsp.service;

import com.example.prjjsp.dto.Member;
import com.example.prjjsp.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper mapper;

    public void addMember(Member member) {
        mapper.insert(member);
    }
}