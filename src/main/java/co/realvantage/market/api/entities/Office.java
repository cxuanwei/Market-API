package co.realvantage.market.api.entities;

import java.util.List;

import lombok.Data;

@Data
public class Office {
	List<OfficeKI> kiList;
	List<OfficeKD> kdList;
}
