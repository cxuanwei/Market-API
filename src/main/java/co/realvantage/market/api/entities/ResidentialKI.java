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
@Table(name="ResidentialKI")
public class ResidentialKI {

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
	@Column(name="population")
	private long population;
	
	@Column(name="population_growth")
	private long population_growth;
	
	@Column(name="projected_population_growth")
	private long projected_population_growth;
	
	@Column(name="economic_growth")
	private long economic_growth;
	
	@Column(name="unemployment")
	private long unemployment;
	
	@Column(name="loan_commitments")
	private long loan_commitments;
	
	@Column(name="first_home_buyers")
	private long first_home_buyers;
		
	@Column(name="building_approvals")
	private long building_approvals;
		
	@Column(name="total_residential_vacancy")
	private double retail_trade_growth_dept_stores;
	
	@Column(name="auction_clearance_rate")
	private double auction_clearance_rate;

	@Column(name="auction")
	private long auction;
	
	@Column(name="captial_growth_house")
	private double captial_growth_house;
	
	@Column(name="median_value_house")
	private double median_value_house;
	
	@Column(name="volume_of_sales_house")
	private double volume_of_sales_house;
	
	@Column(name="average_days_on_market_house")
	private double average_days_on_market_house;
	
	@Column(name="gross_rental_yields_house")
	private double gross_rental_yields_house;
	
	@Column(name="rents_house")
	private double rents_house;
	
	@Column(name="captial_growth_apartment")
	private double captial_growth_apartment;
	
	@Column(name="median_value_apartment")
	private double median_value_apartment;
	
	@Column(name="volume_of_sales_apartment")
	private double volume_of_sales_apartment;
	
	@Column(name="average_days_on_market_apartment")
	private double average_days_on_market_apartment;
	
	@Column(name="gross_rental_yields_apartment")
	private double gross_rental_yields_apartment;
	
	@Column(name="rents_apartment")
	private double rents_apartment;
	*/
}
