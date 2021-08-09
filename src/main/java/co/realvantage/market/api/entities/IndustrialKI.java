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
@Table(name="IndustrialKI")
public class IndustrialKI {

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

	@Column(name="rental_net_face_low")
	private long rental_net_face_low;
	
	@Column(name="rental_net_face_high")
	private long rental_net_face_high;
	
	@Column(name="incentives_low")
	private long incentives_low;
	
	@Column(name="incentives_high")
	private long incentives_high;
	
	@Column(name="yield_market_low")
	private long yield_market_low;
	
	@Column(name="yield_market_high")
	private long yield_market_high;
	
	@Column(name="irr_low")
	private long irr_low;
	
	@Column(name="irr_high")
	private long irr_high;
	
	@Column(name="outgoings_total_low")
	private float outgoings_total_low;
	
	@Column(name="outgoings_total_high")
	private float outgoings_total_high;
	
	@Column(name="captial_values_low")
	private float captial_values_low;
	
	@Column(name="captial_values_high")
	private float captial_values_high;
	
	@Column(name="land_values_3000_5000_low")
	private float land_values_3000_5000_low;
	
	@Column(name="land_values_3000_5000_high")
	private float land_values_3000_5000_high;
	
	@Column(name="land_values_10000_50000_low")
	private float land_values_10000_50000_low;
	
	@Column(name="land_values_10000_50000_high")
	private float land_values_10000_50000_high;
}
