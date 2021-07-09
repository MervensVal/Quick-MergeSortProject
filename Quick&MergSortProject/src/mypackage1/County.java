package mypackage1;

public class County {

	// fields created for each category
	private String countyName;
	private String population2015;
	private String population2016;
	private String population2017;
	private String population2018;
	private String population2019;

	/* Constructor created for each field
	 * takes each field in as a parameter
	 * sets each field equal to parameter
	 * that is passed in by object.
	 */
	
	public County(String countyName, String population2015, String population2016, String population2017, String population2018, String population2019 ) 
	{
		this.countyName = countyName;
		this.population2015 = population2015;
		this.population2016 = population2016;
		this.population2017 = population2017;
		this.population2018 = population2018;
		this.population2019 = population2019;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getPopulation2015() {
		return population2015;
	}

	public void setPopulation2015(String population2015) {
		this.population2015 = population2015;
	}

	public String getPopulation2016() {
		return population2016;
	}

	public void setPopulation2016(String population2016) {
		this.population2016 = population2016;
	}

	public String getPopulation2017() {
		return population2017;
	}

	public void setPopulation2017(String population2017) {
		this.population2017 = population2017;
	}

	public String getPopulation2018() {
		return population2018;
	}

	public void setPopulation2018(String population2018) {
		this.population2018 = population2018;
	}

	public String getPopulation2019() {
		return population2019;
	}

	public void setPopulation2019(String population2019) {
		this.population2019 = population2019;
	}
}
