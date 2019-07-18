package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import pageObjects.pageObject.RepaymentPage;

public class Datepicker {
	
	
	//Select any random date, Past, Today, Future
	public String selectDate(String PastFuture) throws ParseException {
		LocalDate timestamp = LocalDate.now();
		Integer randomDays = (int)(365*Math.random());
		LocalDate randomDate = null;
		String randomDate1;
		SimpleDateFormat format2;
		if(PastFuture.equalsIgnoreCase("Past")) {
			randomDate = timestamp.minusDays(randomDays);
		} else if(PastFuture.equalsIgnoreCase("Future")) {
			randomDate = timestamp.plusDays(randomDays);
		} else if(PastFuture.equalsIgnoreCase("Today")) {
			RepaymentPage repaymentPage = new RepaymentPage();
			repaymentPage.getCalendarSelector().click();
			repaymentPage.getTodayDate().click();
		}
		randomDate1 = randomDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	    format2 = new SimpleDateFormat("dd-M-yyyy");
		Date daate = format2.parse(randomDate1);
		if(daate.toString().contains("Sun") || daate.toString().contains("Sat")) {
			date(PastFuture);
		}
		return randomDate1;
	}

	//Select First of the month
	public String selectFirstofthemonth(WebElement element) throws StaleElementReferenceException {
		String selecteddate="";
		int flag = 0;
		List<WebElement> rows = element.findElements(By.tagName("tr"));
		for (int rnum = 0; rnum < rows.size(); rnum++) {
			List<WebElement> columns = rows.get(rnum).findElements(By.tagName("td"));
			//System.out.println("Number of columns:" + columns.size());
			for (int cnum = 0; cnum < columns.size(); cnum++) {
				String yeartext = columns.get(cnum).getText();
				//System.out.println(yeartext);
				if (yeartext.equals("1")) {
					selecteddate = columns.get(cnum).getText();
					//System.out.println("selecteddate"+selecteddate);
					columns.get(cnum).click();
					flag = 1;
					break;
				}
				else {
					//System.out.println("Ho");
				}
			}
			if (flag == 1)
				break;
		}
		return selecteddate;
	}
	
	// From numeric to text
	public String getMonth(String month) {
		if (month.equals("01") || month.equals("1")) {
			return "JAN";
		}
		if (month.equals("02") || month.equals("2")) {
			return "FEB";
		}
		if (month.equals("03") || month.equals("3")) {
			return "MAR";
		}
		if (month.equals("04") || month.equals("4")) {
			return "APR";
		}
		if (month.equals("05") || month.equals("5")) {
			return "MAY";
		}
		if (month.equals("06") || month.equals("6")) {
			return "JUN";
		}
		if (month.equals("07") || month.equals("7")) {
			return "JUL";
		}
		if (month.equals("08") || month.equals("8")) {
			return "AUG";
		}
		if (month.equals("09") || month.equals("9")) {
			return "SEP";
		}
		if (month.equals("10")) {
			return "OCT";
		}
		if (month.equals("11")) {
			return "NOV";
		}
		if (month.equals("12")) {
			return "DEC";
		}else {
			return null;
		}

	}
	
	//Date conversion
	public String dateConversion(String day)
	{
		String ddate = null;
		if(day.equals("1")){
			ddate="01";
		}else if(day.equals("2")){
			ddate="02";
		}else if(day.equals("3")){
			ddate="03";
		}else if(day.equals("4")){
			ddate="04";
		}else if(day.equals("5")){
			ddate="05";
		}else if(day.equals("6")){
			ddate="06";
		}else if(day.equals("7")){
			ddate="07";
		}else if(day.equals("8")){
			ddate="08";
		}else if(day.equals("9")){
			ddate="09";
		}else
		{
			System.out.println("Invalid data given in Date conversion method");
		}
		//System.out.println("DateConversion : "+ddate);
		return ddate;
	}
	
	//Date Conversion
	public String date(String date)
	{
		String[] datesplit = date.split("-");
		String day = datesplit[0];	
		Integer dint = Integer.parseInt(day);
		if(dint<10)
		{
			day = dateConversion(day);
		}
		String month = datesplit[1];
		Integer mint = Integer.parseInt(month);
		if(mint<10)
		{
			month = dateConversion(month);
		}
		String year = datesplit[2];
		String changedformat = day+"-"+month+"-"+year;
		//System.out.println("In Datepicker Date Changed Format"+ changedformat);
		return changedformat;
	}
	
	//Date Conversion
		public String dateupdateEnddate(String date)
		{
			String[] datesplit = date.split("/");
			//System.out.println(datesplit.length);
			String month=datesplit[0];
				Integer mint = Integer.parseInt(month);
				if(mint<10)
				{
					month = "0"+dateConversion(month);
				}
			String day = datesplit[1];
			Integer dint = Integer.parseInt(day);
			if(dint<10)
			{
				day = "0"+dateConversion(day);
				
			}
			String year = datesplit[2];
			String changedformat = year+"-"+month+"-"+day;
			return changedformat;
		
		}
		
		//From / to -
		public String dateupdate(String date)
		{
			String[] datesplit = date.split("/");
			String month=datesplit[0];
			Integer mint = Integer.parseInt(month);
			if(mint<10)
			{
					month = dateConversion(month);
			}
			String day = datesplit[1];
			Integer dint = Integer.parseInt(day);
			if(dint<10)
			{
				day = dateConversion(day);		
			}
			String year = datesplit[2];
			String changedformat = year+"-"+month+"-"+day;
			return changedformat;
		}
		
		//From / to -
		public String newupdate(String date)
		{
			String[] datesplit = date.split("/");
			//System.out.println(datesplit.length);
			String month=datesplit[0];
			String day = datesplit[1];
			String year = datesplit[2];
			String changedformat = year+"-"+month+"-"+day;
			return changedformat;
		
		}
		
		//Customer DOB
		public String customerDOB(String dob)
		{
			String[] sdob=dob.split("/");	
			String month = sdob[0];
			int imonth=0-Integer.parseInt(month);
			String smon = String.valueOf(imonth);
			String day = sdob[1];
			int iday=0-Integer.parseInt(day);
			String sday = String.valueOf(iday);
			String year = sdob[2];	
			int iyr=Integer.parseInt(year.substring(2, 3));
			String syr = String.valueOf(iyr);
			String formatdob = smon+"/"+sday+"/"+syr;
			return formatdob;
		}
		
		
		
		//next date of the System date
		public String currentSystemDateplusone()
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DAY_OF_MONTH, 1); 
			String newDate = sdf.format(c.getTime());  
			System.out.println(newDate);
			return newDate;
		}
		
		public String currentSystemDate()
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Calendar c = Calendar.getInstance();
			String newDate = sdf.format(c.getTime());  
			System.out.println(newDate);
			return newDate;
		}
		
		
		public boolean checkdateformatwithtime(String datec){
			SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy h:mm:ss a");
		    sdfrmt.setLenient(false);
		    try
		    {
				Date javaDate = sdfrmt.parse(datec);
			
		        System.out.println(datec+" is valid date format");
		        return true;
		    }
		    /* Date format is invalid */
		    catch (java.text.ParseException e)
		    {
		        System.out.println(datec+" is Invalid Date format");
		        return false;
		    }
			}
		
		public boolean checkdateformat(String datec){
			SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
		    sdfrmt.setLenient(false);
		    try
		    {
				Date javaDate = sdfrmt.parse(datec);
			
		        System.out.println(datec+" is valid date format");
		        return true;
		    }
		    /* Date format is invalid */
		    catch (java.text.ParseException e)
		    {
		        System.out.println(datec+" is Invalid Date format");
		        return false;
		    }
		}
		    
		    public String currenttimedatestamp(){
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				String formattedDate = sdf.format(date);
				System.out.println(formattedDate);
				return formattedDate;
			}
			}

