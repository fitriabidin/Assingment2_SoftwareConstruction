package com.assingment2.springboot.assingment2flavorshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assingment2.springboot.assingment2flavorshop.model.Flavor;

@Repository
public interface FlavorRepository extends JpaRepository <Flavor, Long>{

}
