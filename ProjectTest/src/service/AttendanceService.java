package service;

import java.util.List;

import model.Attendance;

public interface AttendanceService {

	boolean isDup(String id);

	int save(Attendance a);

	List<Attendance> getAllAttendance();

	int deleteAttendance(Integer MemberID);

	int updateAttendance(Attendance a);

	Attendance getAttendance(Integer MemberID);


}