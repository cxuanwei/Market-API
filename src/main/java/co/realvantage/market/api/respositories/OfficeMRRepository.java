package co.realvantage.market.api.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.realvantage.market.api.entities.OfficeMR;

@Repository
public interface OfficeMRRepository extends JpaRepository<OfficeMR, Long> {

}
