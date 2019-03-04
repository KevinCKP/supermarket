package com.scau.kevin.supermarket.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scau.kevin.supermarket.entity.Member;
import com.scau.kevin.supermarket.result.Result;
import com.scau.kevin.supermarket.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: kevin
 * @Date: 2019/1/7 16:34
 * @Version 1.0
 */
@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    //添加会员信息
    @RequestMapping("/add")
    @ResponseBody
    public Result<Member> insertMember(Member member){
        memberService.insertMember(member);
        return Result.success(member);
    }

    // 修改会员信息
    @RequestMapping("/update")
    @ResponseBody
    public Result<Member> updateMember(Member member){
        memberService.updateMember(member);
        return Result.success(null);
    }

    //删除会员信息
    @RequestMapping("/delete/{memberId}")
    @ResponseBody
    public Result<Object> deleteMember(@PathVariable("memberId") Long memberId){
        memberService.deleteMember(memberId);
        return Result.success(true);
    }
    //查询会员信息
    @RequestMapping("/to_list")
    @ResponseBody
    public Result<PageInfo> toList(int pageNum, int pageSize, String orderby){
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<Member> members = memberService.listMembers();
        PageInfo<Member> memberPageInfo = new PageInfo<>(members);
        return Result.success(memberPageInfo);
    }

}
