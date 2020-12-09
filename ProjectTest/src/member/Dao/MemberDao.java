package member.Dao;

import member.MemberBean;

public interface MemberDao {
	
	boolean isDup(String acc);

	int insertregister(MemberBean mb);

	int updateregister(MemberBean mb);

}