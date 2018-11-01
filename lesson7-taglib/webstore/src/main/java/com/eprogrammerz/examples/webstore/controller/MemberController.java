package com.eprogrammerz.examples.webstore.controller;

import com.eprogrammerz.examples.webstore.domain.Member;
import com.eprogrammerz.examples.webstore.service.MemberService;
import com.eprogrammerz.examples.webstore.validator.MemberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping({"/members"})
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping
    public String listMembers(Model model) {
        model.addAttribute("members", memberService.findAll());
        return "members";
    }

    @RequestMapping("/{memberNumber}")
    public String getMemberById(@PathVariable("memberNumber") int memberNumber, Model model) {
        Member member = memberService.findByMemberNumber(memberNumber);
        model.addAttribute("member", member);
        return "member";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewMemberForm(@ModelAttribute("newMember") Member newMember) {
        return "addMember";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewMemberForm(@Valid @ModelAttribute("newMember") Member memberToBeAdded, BindingResult result) {

        // Manual Validation - either do it here OR activate in InitBinder
        MemberValidator memberValidator = new MemberValidator();
        memberValidator.validate(memberToBeAdded, result);

        if (result.hasErrors()) {
            return "addMember";
        }

        //  Error caught by ControllerAdvice
        memberService.save(memberToBeAdded);

        return "redirect:/members";

    }

    /*
     * If using @Valid INSTEAD of calling validator inline
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
//	        binder.setValidator(new MemberValidator());
    }


}
