package com.in28minutes.unittesting.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.unittesting.unittesting.model.Appointment;
import com.in28minutes.unittesting.unittesting.model.Item;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

}
