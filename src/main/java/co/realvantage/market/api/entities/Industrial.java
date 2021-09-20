package co.realvantage.market.api.entities;

import java.util.List;

import lombok.Data;

@Data
public class Industrial {
	List<IndustrialKI> kiList;
	List<IndustrialKD> kdList;
}
