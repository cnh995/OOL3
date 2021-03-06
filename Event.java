/**
 *
 *@author Moses Ilunga - Manual Sorting
 *@author Ben Delzer - 
 *@author Christian Hansen - Comparator
 *@author Tim Dusek -
 */
import java.util.*;

/**
 * Event represents an Olympic Event that has Athletes compeating, Fan's observing, and residing within a Venue. Event primarily assigns medals to Athletes based off of focused random generation.
 * 
 *  String name holds the name of the Event
 *  Venue loc is the location that the Event will be hosted
 *  enum Status holdes the current status of each Event
 *  double pop represents the popularity of this Event
 *  ArrayList<Athtlete> aths holds all the Athletes that will be performing in this Event
 *  Status status holds the enum value from Status to show the current Status of this Event
 *  String results holds the finished results of the Event including the Athletes and the medals they have won, along with if they fainted or cheated
 *  Venue.VenueType myType holds the enum value of the kind of Venue is needed to hold this Event
 *  int heat holds how many stages there are in this Event
 *  int count holds what stage this Event is currently on
 *  int fanCount holds the running total of how many Fans have seen this Event
 */
public class Event implements Comparable<Event>
{
    //Using an enum...You could have used a String instead
    public enum Status {SCHEDULED, ACTIVE, COMPLETED}
  
    private String name = "";
    private Venue loc;
    private double pop = 0.0;
    private ArrayList<Athlete> aths = new ArrayList<Athlete>();
    private Status status;
    private String results = "TBD";
    private Venue.VenueType myType = null;
    private int heat = 0;
    private int count = 1;
    private int fanCount = 0;
  
    /**
     * compareTo takes in an Event and compares the popularity of the two Events so see which has the higher popularity
     * 
     * @param inEvent is the Event being used to compare against this Event
     */
    public int compareTo(Event inEvent)
    {
	if(this.getPopularity() > inEvent.getPopularity())
	    {
		return 1;
	    }
	else if(this.getPopularity() < inEvent.getPopularity())
	    {
		return -1;
	    }
	else
	    {
		return 0;
	    }
    }
  
    /**
     * getFanCount returns the running total of how many Fans have seen this event
     * 
     * @return fanCount holds the running total of how many Fans have seen this Event
     */
    public int getFanCount()
    {
	return fanCount;
    }
  
    /**
     * addFanCount is a running total of how many fans
     */
    public void addFanCount()
    {
	fanCount++;
    }

    /**
     *The getVenueType method will return the venue type that the event is being held at
     *
     *@return Venue.VenueType This is the venue type that the event is being held at
     */
    public Venue.VenueType getVenueType()
    {
	return myType;
    }

    /**
     *The setVenueType method will set the venue type to the input
     *
     *@param input This is the venue type that is holding the event
     */
    public void setVenueType(Venue.VenueType input)
    {
	myType = input;
    }
  
    /**
     *toString returns all the relivant information about event
     *
     *@return String that holds all relivant information about event
     */
    public String toString()
    {
	String athletes = "\n-----\n";
	for (Athlete a:aths)
	    athletes = athletes + a + "\n-----\n";
	return "Event "+getName()+":\n\tVenue:\n-----\n"+getLoc()+"\n-----\n\tVenue Type:"+getVenueType()+"\n\tPopuluarity:\t"+getPopularity()+"\n\tStatus: "+getStatus()+"\n\tResults:\t"+getResults()+ "\n\tAttendace:\t" + getFanCount() +  "\n\tAtheletes:\n" + athletes;
    }

    /**
     *This constructor will take inputs and set the corresponding variables to these values
     *
     *@param inName This is the name of the event
     *@param inPop This is the popularity rating of the event
     *@param inVen This is the type of venue holding the event
     */
    //Leaving status and results out of full parameter constructor since:
    //--Status will always start as SCHEDULED
    //--Results won't be known until Event concludes
    public Event(String inName, double inPop, Venue.VenueType inVen)
    {
	setName(inName);
	setPopularity(inPop);
	setVenueType(inVen);
	status = Status.SCHEDULED;
    }
  
    /**
     *This constructor is to be used when there are multiple stages to an Event
     * 
     *@param inName holds the Name of the Event
     *@param inPop holds the popularity rating for this Event
     *@param inVen holds the enum value for the kind of Event
     *@param heat uses the array.size to represent the number of stages this Event needs to go throughle
     */
    public Event(String inName, double inPop, Venue.VenueType inVen, ArrayList<String> inHeat)
    {
	setName(inName);
	setPopularity(inPop);
	setVenueType(inVen);
	status = Status.SCHEDULED;
	setHeat(inHeat.size());
    }
  
    /**
     *setHeat sets the number of stages this Event needs to go through in order to fully complete
     * 
     *@param inHeat holds the number of stages this Event needs to do hold in order to complete
     */
    public void setHeat(int inHeat)
    {
	heat = inHeat;
    }
  
    /**
     *getHeat returns the number of stages there are in this Event
     * 
     *@return int This is the number of stages this Event needs to hold in order to complete
     */
    public int getHeat()
    {
	return heat;
    }

    /**
     *The setName method sets the name of the event to the input
     *
     *@param inName This is the name of the event
     */
    public void setName(String inName)
    {
	name = inName;
    }

    /**
     *The getName method returns the name of the event
     *
     *@return String This is the name of the event
     */
    public String getName()
    {
	return name;
    }

    /**
     *The setLoc method sets the location of the event to the input
     *
     *@param inLoc This is the location of the event
     */
    public void setLoc(Venue inLoc)
    {
	if (inLoc.getType().equals(getVenueType()))
	    loc = inLoc;
    }

    /**
     *The getLoc method returns the location of the event
     *
     *@return Venue This is the location that the event is being held at
     */
    public Venue getLoc()
    {
	return loc;
    }

    /**
     *The setPopularity method sets the popularity to the input
     *
     *@param inPop This is the popularity rating for this event
     */
    public void setPopularity(double inPop)
    {
	if (inPop >= 0.0 && inPop <= 1.0)
	    {
		pop = inPop;
	    }
    }

    /**
     *The getPopularity method returns the popularity rating
     *
     *@return double This is the popularity rating of the event
     */
    public double getPopularity()
    {
	return pop;
    }

    /**
     *The setAthList method sets the list of attending athletes to the input
     *
     *@param inAths This is the list of athlets attending the event
     */
    public void setAthList(ArrayList<Athlete> inAths)
    {
	if (inAths.size() <= getLoc().getMaxAths())
	    {
		aths.clear();
		aths.addAll(inAths);
	    }
    }

    /**
     *The addAthlete method adds an athlete to those who are participating in the event
     *
     *@param inAth This is the athlete being added to the participants
     *
     *@throws TooManyAthletesException This is thrown when too many athletes are trying to be added to the list of participants
     */
    public void addAthlete(Athlete inAth) throws TooManyAthletesException
    {
	if (aths.size() + 1 <= getLoc().getMaxAths())
	    {
		aths.add(inAth);
	    }
	else 
	    throw new TooManyAthletesException();
    }

    /**
     *The removeAthlete method will remove the athlete given by the input from the list of participants
     *
     *@param inAth This is the athlete being removed
     */
    public void removeAthlete(Athlete inAth)
    {
	aths.remove(inAth);
    }

    /**
     *The getAthList method will return the list of athletes participating in the event
     *
     *@return ArrayList<Athlete> This is the list of participating athletes
     */
    public ArrayList<Athlete> getAthList()
    {
	return aths;
    }

    /**
     *The advanceStatus method advances the status of the current event
     */
    private void advanceStatus()
    {
	if(status == Status.SCHEDULED)
	    {
		status = Status.ACTIVE;
	    }
	else if (status == Status.ACTIVE)
	    {
		status = Status.COMPLETED;
	    }
    }

    /**
     *The getStatus method will return the current status of the event
     *
     *@return Status This is the status of the event
     */
    public Status getStatus()
    {
	return status;
    }


    /**
     *The setResults method sets the resultes of the event to the input
     *
     *@param inResults This is the results of the event
     */
    private void setResults(String inResults)
    {
	results = inResults;
    }

    /**
     *The getResults method will return the results of the event
     *
     *@return String This is the results of the event
     */
    public String getResults()
    {
	return results;
    }
  
    /**
     * runEvent hosts the Event and allows the Athletes to compete against eachother a Gold, Silver, and Bronze medalist will be generated from this method
     * 
     *@return boolean This is whether or not the event has been run
     *
     * @throws CaughtCheatingException 
     */
    public boolean runEvent() throws CaughtCheatingException, NotEnoughAthletesException
    {
	if (aths.size() < 3)
	    {
		throw new NotEnoughAthletesException();
      
	    }
    
	//advance status
	advanceStatus();
	Random rng = new Random();
	//Clone Athlete List so I have a copy I can play with
	ArrayList<Athlete> tmp = new ArrayList<Athlete>();
	ArrayList<Athlete> cheaters = new ArrayList<Athlete>();
	ArrayList<Athlete> fainters = new ArrayList<Athlete>();
	ArrayList<Athlete> skippers = new ArrayList<Athlete>();
    
	do
	    {
		for (Athlete t : aths)
		    {
			try
			    {
				if (getVenueType().equals(t.getFav()))
				    {
					int rnd = ((rng.nextInt(10) + 1) * -1);
					if(t.getStam() + rnd <= 0 && rng.nextInt(9) + 1 < t.getSkill())
					    {
						skippers.add(t);
					    }
					else
					    {
						t.changeStam(rnd);
					    }
				    }
				else
				    {
					int rnd = ((rng.nextInt(16) + 5) * -1);
					if(t.getStam() + rnd <= 0 && rng.nextInt(9) + 1 < t.getSkill())
					    {
						skippers.add(t);
					    }
					else
					    {
						t.changeStam(rnd);
					    }
				    }
          
				if (t.getCheater())
				    {
					if ( rng.nextInt(20)==0)
					    {
						throw new CaughtCheatingException();
					    }
					else
					    {
						t.setScore(rng.nextInt(16) + 5 + t.getSkill());
					    }
				    }
				else
				    t.setScore(rng.nextInt(20) + 1 + t.getSkill());
          
				if (t.getStam() > 0)
				    tmp.add(t);
			    }
			catch (CaughtCheatingException e)
			    {
				t.strip();
				cheaters.add(t);
			    }
			catch (AthleteFaintedException e)
			    {
				fainters.add(t);
			    }
		    }
      
		for (Athlete c : cheaters)
		    tmp.remove(c);
		for (Athlete f : fainters)
		    tmp.remove(f);
		for (Athlete s : skippers)
		    tmp.remove(s);
		count++;
      
		while (tmp.size() > 5)
		    {
			tmp.remove(tmp.size()-1);
			System.out.println("derpEvent1");
		    }
      
		int excS=0;
		while (tmp.size() < 5 && excS==0)
		    {
        
			if(skippers.size() > 0)
			    {
				tmp.add(skippers.remove(0));
			    }
			else
			    {
				excS=1;
			    }
		    }
      
		int excF=0;
		while (tmp.size() < 5 && excF==0)
		    {
        
			if(fainters.size() > 0)
			    {
				tmp.add(fainters.remove(0));
			    }
			else
			    {
				excF=1;
			    }
		    }
		aths = tmp;
	    }
	while(count <= getHeat());
    
	setResults("Results:\n");
	boolean noMedal = false;
	Athlete placed = max(tmp);
	if (placed != null)
	    {
		setResults(getResults() + "\t\tGOLD:\t#" + placed.getNumber() + "\n");
		placed.addMedal(1);
		if (getLoc().getCurrFans() > 0)
		    placed.addEndorsements((int)(getPopularity() * (rng.nextInt(getLoc().getCurrFans()-1) + 2)));
		tmp.remove(placed);
	    }
	else 
	    {
		Athlete.vacated();
		noMedal = true;
	    }
	placed = max(tmp);
	if (placed != null)
	    {
		setResults(getResults() + "\t\tSILVER:\t#" + placed.getNumber() + "\n");
		placed.addMedal(2);
		if (getLoc().getCurrFans() > 0)
		    placed.addEndorsements((int)(getPopularity() * (rng.nextInt(getLoc().getCurrFans()-1) + 2) * .5));
		tmp.remove(placed);
	    }
	else 
	    {
		Athlete.vacated();
		noMedal = true;
	    }
	placed = max(tmp);
	if (placed != null)
	    {
		setResults(getResults() + "\t\tBRONZE:\t#" + placed.getNumber() + "\n");
		placed.addMedal(3);
		if (getLoc().getCurrFans() > 0)
		    placed.addEndorsements((int)(getPopularity() * (rng.nextInt(getLoc().getCurrFans()-1) + 2) * .25));
	    }
	else 
	    {
		Athlete.vacated();
		noMedal = true;
	    }
	//advance status
	advanceStatus();
	if (noMedal)
	    throw new NotEnoughAthletesException(cheaters);
	if (cheaters.size() > 0)
	    throw new CaughtCheatingException(cheaters);
	return true;
    }

    /**
     *The max method will find the max score out of the input list of athletes
     *
     *@return Athlete This is the athlete with the highest score
     */
    private Athlete max(ArrayList<Athlete> list)
    {
	if (list.size() == 0)
	    return null;
	Athlete max = list.get(0);
	for (Athlete a : list)
	    {
		if (max.getScore() < a.getScore())
		    max = a;
	    }
    
	for(Athlete t: aths)
	    {
		t.setScore(-(t.getScore()));
	    }
    
	return max;
    }
  
}
