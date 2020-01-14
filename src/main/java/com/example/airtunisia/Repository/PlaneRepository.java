package com.example.airtunisia.Repository;

import com.example.airtunisia.Model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane, Integer> {

    Plane findById(int id);
}
