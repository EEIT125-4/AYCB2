package member.Service;

import member.MemberBean;

public interface MemberService {
	 boolean isDup(String acc);

	int insertregester(MemberBean mb);

	int updateregister(MemberBean mb);
	
	boolean identify(String account ,String password);
}