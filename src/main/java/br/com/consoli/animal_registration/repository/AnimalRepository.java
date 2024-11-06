package br.com.consoli.animal_registration.repository;

import br.com.consoli.animal_registration.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL AND a.tipo = :tipo ORDER BY a.dataEntrada")
    List<Animal> findNotAdoptedByType(@Param("tipo") String tipo);

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL AND a.tipo = :tipo")
    List<Animal> findAdoptedByType(@Param("tipo") String tipo);

    @Query("SELECT a.nomeRecebedor, COUNT(a) FROM Animal a WHERE a.dataEntrada BETWEEN :startDate AND :endDate GROUP BY a.nomeRecebedor")
    List<Object[]> getRescuedAnimalsCount(String startDate, String endDate);

    @Query("SELECT a.nomeRecebedor, COUNT(a) FROM Animal a WHERE a.dataEntrada BETWEEN :startDate AND :endDate GROUP BY a.nomeRecebedor")
    List<Object[]> countAnimalsRescuedByEmployee(LocalDate startDate, LocalDate endDate);
}
