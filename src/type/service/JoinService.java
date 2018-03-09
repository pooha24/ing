package type.service;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

	@Autowired
	SqlSessionTemplate template;
	
	public boolean memberJoin(Map map) {
		
		int r= template.insert("member.join",map);
		if(r==1) {
			return true;
		}else {
			return false;
		}
	}
}
