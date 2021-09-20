package co.realvantage.market.api.entities;

import java.util.List;

import lombok.Data;

@Data
public class Retail {
	List<RetailKI> kiList;
	List<RetailKD> kdList;
}
