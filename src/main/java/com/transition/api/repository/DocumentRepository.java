package com.transition.api.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.transition.api.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
	List<Document> findAllByUserUserId(long userId);
}
