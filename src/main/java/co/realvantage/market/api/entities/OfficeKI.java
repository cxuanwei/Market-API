package co.realvantage.market.api.entities;

import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="OfficeKI")
public class OfficeKI {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="quarter")
	private long quarter;
	
	@Column(name="year")
	private Year year;
	
	@Column(name="country")
	private String country;
	
	@Column(name="state")
	private String state;
	
	@Column(name="suburb")
	private String suburb;
	
	@Column(name="grade")
	private String grade;
	
	@Column(name="indicator")
	private String indicator;
	
	@Column(name="low")
	private double low;
	
	@Column(name="high")
	private double high;
	

    /*
	@Column(name="rental_grossface_low")
	private long rental_grossface_low;
	
	@Column(name="rental_grossface_high")
	private long rental_grossface_high;
	
	@Column(name="rental_netface_low")
	private long rental_netface_low;
	
	@Column(name="rental_netface_high")
	private long rental_netface_high;
	
	@Column(name="incentive_level_gross_low")
	private float incentive_level_gross_low;
	
	@Column(name="incentive_level_gross_high")
	private float incentive_level_gross_high;
	
	@Column(name="rental_net_effective_low")
	private long rental_net_effective_low;
	
	@Column(name="rental_net_effective_high")
	private long rental_net_effective_high;
	
	@Column(name="outgoings_operating_low")
	private long outgoings_operating_low;
	
	@Column(name="outgoings_operating_high")
	private long outgoings_operating_high;
	
	@Column(name="outgoings_statutory_low")
	private long outgoings_statutory_low;
	
	@Column(name="outgoings_statutory_high")
	private long outgoings_statutory_high;
	
	@Column(name="outgoings_total_low")
	private long outgoings_total_low;
	
	@Column(name="outgoings_total_high")
	private long outgoings_total_high;
	
	@Column(name="typical_lease_term_low")
	private long typical_lease_term_low;
	
	@Column(name="typical_lease_term_high")
	private long typical_lease_term_high;
	
	@Column(name="yield_market_low")
	private float yield_market_low;
	
	@Column(name="yield_market_high")
	private float yield_market_high;
	
	@Column(name="irr_low")
	private float irr_low;
	
	@Column(name="irr_high")
	private float irr_high;
	
	@Column(name="cars_perm_reserved_low")
	private long cars_perm_reserved_low;
	
	@Column(name="cars_perm_reserved_high")
	private long cars_perm_reserved_high;
	
	@Column(name="office_captial_values_low")
	private long office_captial_values_low;
	
	@Column(name="office_captial_values_high")
	private long office_captial_values_high;
	*/
}
