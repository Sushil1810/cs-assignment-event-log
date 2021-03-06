package com.sushil.cs.repo;

import com.sushil.cs.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Event repository.
 */
@Repository
public interface EventRepository extends CrudRepository<EventEntity, String>{
}
