package in.myproject.anand.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.myproject.anand.bindings.UnlockAccReq;
import in.myproject.anand.service.UnlockApiServiceImpl;

@RestController
public class UnlockAccRestController {
	
	@Autowired
	private UnlockApiServiceImpl service;
	
	@PostMapping("/unlock")
	public String unlockAcc(@RequestBody UnlockAccReq unlockAccReq)
	{
		String unlockUserAccout = service.unlockUserAccout(unlockAccReq);
		return unlockUserAccout;
	}

}
