package in.laptop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.laptop.entity.Product;

public interface ProdRepository extends JpaRepository<Product, Integer>{

	public List<Product> findByActiveSW(String status);
}
