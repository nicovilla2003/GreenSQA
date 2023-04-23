package model;
import java.util.Calendar;
import java.text.SimpleDateFormat;
public class sDate_fDate {
    
    private Calendar sDate;
    private Calendar fDate;
    public sDate_fDate(){

    }

    public String getStartDate() {
        SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy");
		return date.format(sDate);
	}

	public void setStartDate(Calendar sDate) {
		this.sDate = sDate;
	}
    public String getFinishDate() {
		SimpleDateFormat date=new SimpleDateFormat("dd/MM/yyyy");
		return date.format(fDate);
	}

	public void setFinishDate(Calendar fDate) {
		this.fDate = fDate;
	}
	public Calendar getStartCalendarDate() {
		return sDate;
	}
	public Calendar getFinsihCalendarDate() {
		return fDate;
	}
}
