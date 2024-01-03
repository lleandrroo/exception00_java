package fundamentos.excecoes.model.entities;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import fundamentos.excecoes.model.exception.DomainException;

public class Reservation {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static Date now = new Date();
	
	private Integer roomNumber;
	private Date check_in;
	private Date check_out;
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if (check_in.before(now) || check_out.before(now)) {
			throw new DomainException("Error in reservation: Reservation dates for update must be future");
		}
		if (!check_out.after(check_in)) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.check_in = checkIn;
		this.check_out = checkOut;
	}

	public Integer getRooNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer rooNumber) {
		this.roomNumber = rooNumber;
	}

	public Date getCheckIn() {
		return check_in;
	}

	public Date getCheckOut() {
		return check_out;
	}	
	
	public long duration() {
		long diff = check_out.getTime() - check_in.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDate(Date checkIn, Date checkOut) {
		this.check_in = checkIn;
		this.check_out = checkOut;
	}
	
	public String updateDate2(Date check_in, Date check_out) {
		if (check_in.before(now) || check_out.before(now)) {
			return "Error in reservation: Reservation dates for update must be future";
		}
		if (!check_out.after(check_in)) {
			return "Error in reservation: Check-out date must be after check-in date";
		}
		
		this.check_in = check_in;
		this.check_out = check_out;
		return  null;
	}
	
	public void updateDate3(Date check_in, Date check_out) throws DomainException {
		if (check_in.before(now) || check_out.before(now)) {
			throw new DomainException("Error in reservation: Reservation dates for update must be future");
		}
		if (!check_out.after(check_in)) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
		
		this.check_in = check_in;
		this.check_out = check_out;
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(check_in)
				+ "\ncheck-out: "
				+ sdf.format(check_out)
				+ "\n "
				+ duration()
				+ " nights";
	}
}
