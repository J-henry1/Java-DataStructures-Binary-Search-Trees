
/**
 * @author Jared Henry
 * 
 * Country class provides constructors, getters, setters, and print methods for Countries4.csv file
 * 
 * version 11/7/2022
 */

public class Country {
	
	public String name
	,capital;
	public double population, GDP,COVIDCases, COVIDDeaths, area;
	public double GDPPC, CFR, CaseRate, DeathRate, PopDensity;
	

	/**
	 * @param name
	 * @param capital
	 * @param population
	 * @param gDP
	 * @param cOVIDCases
	 * @param cOVIDDeaths
	 * @param area
	 * @param gDPPC
	 * @param cFR
	 * @param caseRate
	 * @param deathRate
	 * @param popDensity
	 */
	public Country(String name, double gDPPC) {
		this.name = name;
		this.capital = capital;
		this.population = population;
		this.area = area;
		GDPPC = gDPPC;
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the capital
	 */
	public String getCapital() {
		return capital;
	}

	/**
	 * @param capital the capital to set
	 */
	public void setCapital(String capital) {
		this.capital = capital;
	}

	/**
	 * @return the population
	 */
	public double getPopulation() {
		return population;
	}

	/**
	 * @param population the population to set
	 */
	public void setPopulation(double population) {
		this.population = population;
	}

	/**
	 * @return the gDP
	 */
	public double getGDP() {
		return GDP;
	}

	/**
	 * @param gDP the gDP to set
	 */
	public void setGDP(double gDP) {
		GDP = gDP;
	}

	/**
	 * @return the cOVIDCases
	 */
	public double getCOVIDCases() {
		return COVIDCases;
	}

	/**
	 * @param cOVIDCases the cOVIDCases to set
	 */
	public void setCOVIDCases(double cOVIDCases) {
		COVIDCases = cOVIDCases;
	}

	/**
	 * @return the cOVIDDeaths
	 */
	public double getCOVIDDeaths() {
		return COVIDDeaths;
	}

	/**
	 * @param cOVIDDeaths the cOVIDDeaths to set
	 */
	public void setCOVIDDeaths(double cOVIDDeaths) {
		COVIDDeaths = cOVIDDeaths;
	}

	/**
	 * @return the area
	 */
	public double getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(double area) {
		this.area = area;
	}

	/**
	 * @return the gDPPC
	 */
	public double getGDPPC() {
		return GDPPC;
	}

	/**
	 * @param gDPPC the gDPPC to set
	 */
	public void setGDPPC(double gDPPC) {
		GDPPC = gDPPC;
	}

	/**
	 * @return the cFR
	 */
	public double getCFR() {
		return CFR;
	}

	/**
	 * @param cFR the cFR to set
	 */
	public void setCFR(double cFR) {
		CFR = cFR;
	}

	/**
	 * @return the caseRate
	 */
	public double getCaseRate() {
		return CaseRate;
	}

	/**
	 * @param caseRate the caseRate to set
	 */
	public void setCaseRate(double caseRate) {
		CaseRate = caseRate;
	}

	/**
	 * @return the deathRate
	 */
	public double getDeathRate() {
		return DeathRate;
	}

	/**
	 * @param deathRate the deathRate to set
	 */
	public void setDeathRate(double deathRate) {
		DeathRate = deathRate;
	}

	/**
	 * @return the popDensity
	 */
	public double getPopDensity() {
		return PopDensity;
	}

	/**
	 * @param popDensity the popDensity to set
	 */
	public void setPopDensity(double popDensity) {
		PopDensity = popDensity;
	}
	
	@Override
	public String toString() {
	    return String.format("%-32s %-15.3f ", name, GDPPC);
	}



}//new Country
