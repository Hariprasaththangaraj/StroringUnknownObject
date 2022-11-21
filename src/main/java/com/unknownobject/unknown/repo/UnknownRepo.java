package com.unknownobject.unknown.repo;

import com.unknownobject.unknown.entity.UnknownEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnknownRepo extends JpaRepository<UnknownEntity, String> {
}
