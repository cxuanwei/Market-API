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
@Table(name="IndustrialKD")
public class IndustrialKD {

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
	
	@Column(name="driver")
	private String driver;
	
	@Column(name="value")
	private double value;
	
	/*
	@Column(name="gdp_sfd_growth")
	private long gdp_sfd_growth;
	
	@Column(name="population_growth")
	private long population_growth;
	
	@Column(name="employment_growth")
	private long employment_growth;
	
	@Column(name="unemployment_growth")
	private long unemployment_growth;
	
	@Column(name="inflation")
	private double inflation;
	
	@Column(name="retail_trade_growth")
	private double retail_trade_growth;
	
	@Column(name="job_ad_growth_total")
	private long job_ad_growth_total;
	
	@Column(name="job_ad_growth_industrial")
	private long job_ad_growth_industrial;
	
	@Column(name="house_price_growth")
	private long house_price_growth;
	
	@Column(name="apartment_price_growth")
	private long apartment_price_growth;
	
	@Column(name="da_approvals_industrial")
	private double da_approvals_industrial;
	
	@Column(name="earnings_growth")
	private double earnings_growth;
	*/
}
