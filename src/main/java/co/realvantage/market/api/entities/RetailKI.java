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
@Table(name="RetailKI")
public class RetailKI {

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
	@Column(name="dept_store_rent_gross_low")
	private long dept_store_rent_gross_low;
	
	@Column(name="dept_store_rent_gross_high")
	private long dept_store_rent_gross_high;
	
	@Column(name="dds_rent_gross_low")
	private long dds_rent_gross_low;
	
	@Column(name="dds_rent_gross_high")
	private long dds_rent_gross_high;
	
	@Column(name="supermarket_rent_gross_low")
	private long supermarket_rent_gross_low;
	
	@Column(name="supermarket_rent_gross_high")
	private long supermarket_rent_gross_high;
	
	@Column(name="mini_major_rent_low")
	private long mini_major_rent_low;
	
	@Column(name="mini_major_rent_high")
	private long mini_major_rent_high;
	
	@Column(name="specialty_tenant_rent_gross_low")
	private float specialty_tenant_rent_gross_low;
	
	@Column(name="specialty_tenant_rent_gross_high")
	private float specialty_tenant_rent_gross_high;
	
	@Column(name="yield_market_low")
	private float yield_market_low;
	
	@Column(name="yield_market_high")
	private float yield_market_high;
	
	@Column(name="irr_low")
	private float irr_low;
	
	@Column(name="irr_high")
	private float irr_high;
	
	@Column(name="outgoings_operating_low")
	private long outgoing_operating_low;
	
	@Column(name="outgoings_operating_high")
	private long outgoing_operating_high;
	
	@Column(name="outgoings_statutory_low")
	private long outgoing_statutory_low;
	
	@Column(name="outgoings_statutory_high")
	private long outgoing_statutory_high;
	
	@Column(name="outgoings_total_low")
	private long outgoings_total_low;
	
	@Column(name="outgoings_total_high")
	private long outgoings_total_high;
	
	@Column(name="captial_values_low")
	private long captial_values_low;
	
	@Column(name="captial_values_high")
	private long captial_values_high;
	*/
}
