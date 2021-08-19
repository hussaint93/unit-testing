package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.unittesting.data.AppointmentRepository;
import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Appointment;
import com.in28minutes.unittesting.unittesting.model.Item;

@ExtendWith(MockitoExtension.class)
class AppointmentServiceTest {

	@Mock
	AppointmentRepository repo;

	@InjectMocks
	AppointmentServices appointments;

	@Test
	void testRetrieveAllAppointmrnts() {
		when(repo.findAll()).thenReturn(Arrays.asList(new Appointment(1,"hu","h@gmail.com","mumbai",1234567890L,120f)));
		appointments.retrieveAllAppointments();
	}
	
	void testSavedAppointments() {
		Appointment  a1= new Appointment(2,"mu","m@gmail.com","delhi",1234567890L,67f);
		when(repo.save(a1)).thenReturn(a1);
		Appointment saved = appointments.savedAppointment(a1);
		assertEquals(a1.getId(), saved.getId());
	}
	
	void testUpdateAppoinments() {
		Optional<Appointment> a1 = Optional.of(new Appointment(2,"mu","m@gmail.com","delhi",1234567890L,67f));
		when(repo.findById(2)).thenReturn(a1);
		Appointment app=appointments.updateItem(2);
		assertNotEquals(a1.get().getId(), app.getId());
	}
}