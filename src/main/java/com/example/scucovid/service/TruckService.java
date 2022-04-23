package com.example.scucovid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.scucovid.entity.Truck;
import com.example.scucovid.reop.TruckRepo;


@Service
public class TruckService {
	@Autowired
	private TruckRepo truckrepo;
	
	public Truck addTrack(@RequestBody Truck truck) {
		return truckrepo.saveAndFlush(truck);
	}
	public List<Truck> listTrack() {
		return truckrepo.findAll();
	}
	public List<Truck> findbycode(String code){
		return truckrepo.findbycode(code);
	}
	public void delbyid(String id){
		truckrepo.deleteById(id);
	}
}
