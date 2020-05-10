package tutoringWebsite.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tutoringWebsite.controllers.AnnouncementController;
import tutoringWebsite.model.Announcement;
import tutoringWebsite.model.Session;
import tutoringWebsite.persist.DerbyDatabase;

public class CreateAnnouncementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("\nCreateAnnouncementServlet: doGet");

		req.getRequestDispatcher("/_view/createAnnouncement.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("Announcement Servlet: doPost");
		Announcement model = new Announcement();
		AnnouncementController controller = new AnnouncementController();
		String errorMessage = null;
		String date = null;
		String time = null;
		String message = null;
		int announcementType = -1;
		int typeId = -1;
		String temp = null;
		
		LocalDate aDate = LocalDate.now();
		LocalTime aTime = LocalTime.now();
		
		date = req.getParameter("date");
		time = req.getParameter("time");
		message = req.getParameter("message");
		temp = req.getParameter("announcementType");
		
		String session, studyGroup;
		session= "Session";
		studyGroup = "Study Group";
		if(temp.contains(session)) {
			announcementType=1;
			System.out.print("\ntrue");
		}else if(temp.contentEquals(studyGroup)){
			announcementType = 2;
		}
		else {
			errorMessage = "Incorrect Announcement Type";
		}
		
		//controller.create(date, time, message, announcementType, typeId);
		req.setAttribute("errorMessage", errorMessage);
		
		req.getRequestDispatcher("/_view/announcement.jsp").forward(req, resp);
	}
}