package br.com.fullstack.carapi;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="cars", collectionResourceRel="cars")
public interface CarResource extends PagingAndSortingRepository<Car, Integer> {

	List<Car> findByColor(@Param("color") String color);

}
