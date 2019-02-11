package com.scau.kevin.supermarket.service;

import com.scau.kevin.supermarket.entity.Member;

import java.util.List;
import java.util.Map;

/**
 * @Author: kevin
 * @Date: 2018/12/29 15:34
 * @Version 1.0
 */
public interface MemberService {
    //添加会员信息
    boolean insertMember(Member member);

    //修改会员信息
    boolean updateMember(Member member);

    //删除会员信息
    boolean deleteMember(Long memberId);

    //查询会员信息
    List<Member> listByFactors(Map<String,Object> map);

    List<Member> listMembers();
}
