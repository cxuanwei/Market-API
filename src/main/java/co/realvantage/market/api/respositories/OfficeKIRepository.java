package co.realvantage.market.api.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.realvantage.market.api.entities.OfficeKI;

@Repository
public interface OfficeKIRepository extends JpaRepository<OfficeKI, Long> {

}
