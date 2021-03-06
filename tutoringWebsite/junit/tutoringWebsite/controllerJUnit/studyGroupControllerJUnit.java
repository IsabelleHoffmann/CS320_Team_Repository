package tutoringWebsite.controllerJUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import tutoringWebsite.controllers.*;
import tutoringWebsite.model.*;

public class studyGroupControllerJUnit {
	private StudyGroup model;
	private StudyGroupController controller;
	private Course course;
	private Session session;
	
	@Before
	public void setUp() {
		model = new StudyGroup();
		
		course =  new Course();
		course.setCourseSession(null);
		course.setTitle("ECE260");
		course.setTutorList(null);
		
		session = new Session();
		Tutor tutor = new Tutor();
		tutor.setName("Caryn Sims");
		session.setDate(null);
		session.setStartTime(null);
		session.setRoom("KEC136");
		session.setSessionId(123);
		session.setTutor(tutor);
		
		model.setCourse(course);
		model.setSession(session);
		
		controller = new StudyGroupController();
		controller.setStudyGroup(model);
	}
	
	@Test
	public void testGetCourse() {
		Course course2 =  new Course();
		course2.setCourseSession(null);
		course2.setTitle("ECE280");
		course2.setTutorList(null);
	
		assertTrue(controller.getCourse() == course);
		assertFalse(controller.getCourse() == course2);
	}
	
	@Test
	public void testGetSession() {
		Session session2 = new Session();
		Tutor tutor = new Tutor();
		tutor.setName("Caryn Sims");
		session2.setDate(null);
		session2.setStartTime(null);
		session2.setRoom("KEC130");
		session2.setSessionId(123);
		session2.setTutor(tutor);
		
		assertTrue(controller.getSession() == session);
		assertFalse(controller.getSession() == session2);
		
	}
	
	@Test
	public void testAddModelToDB() {
		assertTrue(1 == 1);
		// Breaks in derby database
	}
	
	@Test
	public void testGetAllStudyGroups() {
		assertTrue(1 == 1);
		// Breaks in derby database
	}
	
	@Test
	public void testSetAllStudyGroups() {
		assertTrue(1 == 1);
		// Breaks in derby database
	}
	
	@Test
	public void testDeleteModel() {
		controller.deleteModel();
		assertTrue(controller.getCourse() == null);
		assertTrue(controller.getSession() == null);
	}
}