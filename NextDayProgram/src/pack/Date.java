package pack;

public class Date {
    private int month;
    private int day;
    private int year;
    
    public Date() {
        month = 1;
        day = 1;
        year =2006;
    }

    public Date (int m, int d, int y){
        month = m;
        day = d;
        year =y;  
    }

    public static boolean isLegitimate(int mon, int day, int year){   		
    	boolean status = true;
    	if(mon > 0 && mon <= 12 && year >0 && day > 0 && day <= 31){    //checking to make sure no negative or extreme values for day or month
    			if((mon== 4 || mon == 6 || mon == 9 || mon == 11) && day >= 31){ //checks for days ending in 30 days cannot have 31 days
    				status = false;
    			}	
    			if(mon == 2 && day >29){    //only allows February to have a total of 29 days
    				status = false;
    			}
    	}else{
    		status= false;
    	}
    	
    	if(mon == 2 && day == 29){            //checks to see if it is leap year to allow a Feb 29th date. 
    			if((!(year%100 == 0) || (year%400 == 0)) && year%4 == 0){
    			}else
    			{
    				status = false;
    			}	
    			} 
    	
        return status;
    }

    public static void advanceDate(Date aDate) {
    	aDate.day +=1;
    	if(aDate.month == 4 || aDate.month == 6 || aDate.month == 9 || aDate.month == 11 && aDate.day ==31) 
    	{
    		aDate.day = 1;							//if statement to check for overflow of months ending with 31 days
    		aDate.month +=1;
    		
    		} else if(aDate.month == 1 || aDate.month == 3|| aDate.month == 5 ||aDate.month == 7 || aDate.month == 8 || 
    			aDate.month == 10 || aDate.month == 12 && aDate.day == 32)
    	{
    		aDate.day = 1;
    		aDate.month += 1;			//if statement to check for over of months ending with 31 days
    		
    		if(aDate.month == 13){      //if statement to check for month overflow, reseting the year after 12 months
    			aDate.month = 1;
    			aDate.year +=1;
    		}
    	} else if(aDate.month == 2 && ((!(aDate.year%100 == 0) || (aDate.year%400 == 0)) && aDate.year%4 == 0))
    	{
    		if(aDate.day == 30)			//statement to check that if it is leap year, to allow February
    		{							//to advance to the 29th day
    			aDate.day = 1;
    			aDate.month += 1;
    		}
    	} else if(aDate.month ==2 && aDate.day == 29) 		//statement to advance from February 28th to march if it is not leap year
    		{
    			aDate.day = 1;         //results day and adds one to the month
    			aDate.month +=1;
    		}
    }

	public void display(String s){
        System.out.println(s + month + "/" + day + "/" + year);
    }
}
