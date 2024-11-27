package hotel_model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Room {
	@Id
	private int rId;
	   private String rType;
	   private int rPrize;
	   private String rStatus="available";
	   @ManyToOne
	   @JoinColumn(name="hId")
	   private Hotel hId;
	
	
	   
}
