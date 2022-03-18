package isi.com.Qatar2022.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isi.com.Qatar2022.Entities.ChaiseStade;

@Repository
public interface ChaiseStadeRepository extends JpaRepository<ChaiseStade, Long> {

}
