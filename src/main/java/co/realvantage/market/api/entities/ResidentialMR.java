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
@Table(name="ResidentialMR")
public class ResidentialMR {

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

	@Column(name="median_value_house")
	private long median_value_house;
	
	@Column(name="captial_growth_annual_house")
	private long captial_growth_annual_house;
	
	@Column(name="sales_volume_annual_house")
	private long sales_volume_annual_house;
	
	@Column(name="sales_turnover_annual_house")
	private long sales_turnover_annual_house;
	
	@Column(name="ave_days_on_market_house")
	private long ave_days_on_market_house;
	
	@Column(name="gross_rental_yield_house")
	private long gross_rental_yield_house;
	
	@Column(name="median_weekly_rent_house")
	private double median_weekly_rent_house;
		
	@Column(name="rental_growth_annual_house")
	private double rental_growth_annual_house;

	@Column(name="median_value_apartment")
	private long median_value_apartment;
	
	@Column(name="captial_growth_annual_apartment")
	private long captial_growth_annual_apartment;
	
	@Column(name="sales_volume_annual_apartment")
	private long sales_volume_annual_apartment;
	
	@Column(name="sales_turnover_annual_apartment")
	private long sales_turnover_annual_apartment;
	
	@Column(name="ave_days_on_market_apartment")
	private long ave_days_on_market_apartment;
	
	@Column(name="gross_rental_yield_apartment")
	private long gross_rental_yield_apartment;
	
	@Column(name="median_weekly_rent_apartment")
	private double median_weekly_rent_apartment;
		
	@Column(name="rental_growth_annual_apartment")
	private double rental_growth_annual_apartment;
}
