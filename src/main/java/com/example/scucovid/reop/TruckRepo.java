package com.example.scucovid.reop;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.scucovid.entity.Truck;

public interface TruckRepo extends JpaRepository<Truck,String>{
	@Query(value="select * from scu_truck t where t.user_code=:code",nativeQuery=true)
	public List<Truck> findbycode(String code);
}
