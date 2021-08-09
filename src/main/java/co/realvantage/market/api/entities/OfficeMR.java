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
@Table(name="OfficeMR")
public class OfficeMR {

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

	@Column(name="total_stock")
	private long total_stock;
	
	@Column(name="total_vacancy")
	private long total_vacancy;
	
	@Column(name="net_adsorption")
	private long net_adsorption;
	
	@Column(name="stock_additions")
	private long stock_additions;
	
	@Column(name="stock_withdrawal")
	private long stock_withdrawal;
	
	@Column(name="net_additions")
	private long net_additions;
	
	@Column(name="vacancy_precent")
	private double vacancy_precent;
		
	@Column(name="netAbsorption_precent")
	private double netAbsorption_precent;
		
	@Column(name="netAdditions_precent")
	private double netAdditions_precent;
	
}
