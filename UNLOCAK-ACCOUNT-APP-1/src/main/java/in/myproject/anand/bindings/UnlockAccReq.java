package in.myproject.anand.bindings;

import lombok.Data;

@Data
public class UnlockAccReq {

	private String Email;
	private String tempPass;
	private String newPass;
	private String confirmPass;
	
}
