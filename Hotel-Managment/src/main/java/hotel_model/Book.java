package hotel_model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Book {
	@Id
	private int bId;
	@ManyToOne
	   @JoinColumn(name="gId")
	   private Guest gId;
	@ManyToOne
	   @JoinColumn(name="rId")
	   private Room roomId;
	   private String bookDate;
	   private String checkIn;
	   private String checkOut;
	   @ManyToOne
	   @JoinColumn(name="hId")
	   private Hotel hId;
	
}
