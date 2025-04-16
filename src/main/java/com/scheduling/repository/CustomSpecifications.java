package com.scheduling.repository;

import org.springframework.data.jpa.domain.Specification;

public class CustomSpecifications {
	
	public static <T> Specification<T> like(String columnName, String value) {
        return (root, query, builder) -> 
        	builder.like(
    			builder.lower(root.get(columnName)),
    			"%" + value.toLowerCase() + "%"
			);
    }

	public static <T> Specification<T> equal(String columnName, Object value) {
        return (root, query, builder) -> 
        	builder.equal(
    			root.get(columnName),
    			value
			);
    }
	
}
