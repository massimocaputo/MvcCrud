package com.acn.nemo.repository;

import com.acn.nemo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Short> {
}