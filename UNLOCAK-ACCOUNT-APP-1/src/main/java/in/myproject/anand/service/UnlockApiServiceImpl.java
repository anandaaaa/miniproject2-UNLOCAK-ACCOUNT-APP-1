package in.myproject.anand.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.myproject.anand.bindings.UnlockAccReq;
import in.myproject.anand.constants.MyAppConstants;
import in.myproject.anand.entities.UserEntity;
import in.myproject.anand.prop.AppProperties;
import in.myproject.anand.repositires.UserRepository;

@Service
public class UnlockApiServiceImpl implements UnLockApiService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AppProperties appProperties;
	
	@Override
	public String unlockUserAccout(UnlockAccReq unlockAccReq) {
		Map<String, String> messages = appProperties.getMessages();
		UserEntity findByUserEmailAndUserPwd = userRepository.findByUserEmailAndUserPwd(unlockAccReq.getEmail(), unlockAccReq.getTempPass());
		if(findByUserEmailAndUserPwd!=null)
		{
			findByUserEmailAndUserPwd.setUserAccStatus(MyAppConstants.UNLOCKED);
			findByUserEmailAndUserPwd.setUserPwd(unlockAccReq.getNewPass());
			userRepository.save(findByUserEmailAndUserPwd);
			return messages.get(MyAppConstants.USER_ACCUNLOCKSUCEE);
		}
		return messages.get(MyAppConstants.INVALIDPWD); 
	}

}
