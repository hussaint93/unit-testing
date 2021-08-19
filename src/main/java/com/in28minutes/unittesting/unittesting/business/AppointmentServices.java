package com.in28minutes.unittesting.unittesting.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.unittesting.unittesting.data.AppointmentRepository;
import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Appointment;
import com.in28minutes.unittesting.unittesting.model.Item;

@Component
public class AppointmentServices {

	@Autowired
	private AppointmentRepository repository;

	public List<Appointment> retrieveAllAppointments() {
		List<Appointment> appointments = repository.findAll();
		
		for(Appointment app:appointments) {
			app.setAmount(100);
		}
		return appointments;	
	}

	public Appointment savedAppointment(Appointment a1) {
		
		return repository.save(a1);
	}

	public Appointment updateItem(int id) {
		Optional<Appointment> app = repository.findById(id);
		return new Appointment(app.get().getId(),"mu","m@gmail.com","mumbai",50L,500f);
	}
	
	
}
