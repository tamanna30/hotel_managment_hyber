package hotel_model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Guest {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int gId;
	   private String gName;
	   private String gPhone;
	   private String gEmail;
	   private String gAdd;
}
