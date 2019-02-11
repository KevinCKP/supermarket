package com.scau.kevin.supermarket.serviceimpl;

import com.scau.kevin.supermarket.dao.MemberDao;
import com.scau.kevin.supermarket.entity.Member;
import com.scau.kevin.supermarket.exception.GlobalException;
import com.scau.kevin.supermarket.result.CodeMessage;
import com.scau.kevin.supermarket.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: kevin
 * @Date: 2019/1/10 13:16
 * @Version 1.0
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDao memberDao;
    @Override
    public boolean insertMember(Member member) {
        if(member.getMemberId() == null){
            // 会员编号为空
            throw new GlobalException(CodeMessage.ID_EMPTY);
        } else if(memberDao.selectByPrimaryKey(member.getMemberId()) != null){
            // 会员编号已存在
            throw new GlobalException(CodeMessage.ID_EXISTS);
        }
        return memberDao.insertSelective(member) >= 1;
    }

    @Override
    public boolean updateMember(Member member) {
        return false;
    }

    @Override
    public boolean deleteMember(Long memberId) {
        return memberDao.deleteByPrimaryKey(memberId) >= 1;
    }

    @Override
    public List<Member> listByFactors(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<Member> listMembers() {
        return null;
    }
}
