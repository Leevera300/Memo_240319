package com.memo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemoController {

	@GetMapping("/user/sign-in-view")
	public String signIn() {
		return "user/signIn";
	}
}
