package mum.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mum.edu.domain.Member;
import mum.edu.service.MemberService;

@Controller
@RequestMapping({"/members"})
public class MemberController {
	
	@Autowired
	private MemberService  memberService;

	@RequestMapping
	public String listMembers(Model model) {
		model.addAttribute("members", memberService.findAll());
		return "members";
	}
	
  	@RequestMapping("/{memberNumber}")
	public String getMemberById(@PathVariable("memberNumber") int memberNumber,Model model) {
		Member member = memberService.findByMemberNumber(memberNumber);
		model.addAttribute("member", member);

 		return "member";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
  	@PreAuthorize("hasRole('ROLE_ADMIN')")    // If global-method-security enabled in Dispatcher config
	public String getAddNewMemberForm(@ModelAttribute("newMember") Member newMember) {
	   return "addMember";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewMemberForm(@ModelAttribute("newMember") @Valid Member memberToBeAdded, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "addMember";
		}

			 //  Error caught by ControllerAdvice IF no authorization...
			memberService.saveFull(memberToBeAdded);

	   	return "redirect:/members";
 
	}
	
 
}
