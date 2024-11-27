package hotel_model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Hotel {
	@Id
	private int hId;
	 private String hName;
	 private String hCity;
	 private int tRoom;
	 private int aRoom;
	

}
