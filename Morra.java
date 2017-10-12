/*
Morra.java
@author Craig Sullivan
21/04/17
*/

public class Morra {

//Variables
	public String name;
	boolean isRunning;
	public String options;
	public String winner;
	public String even;
	public String odd;
	public int evens;
	public int odds;
	public int evensNumber;
	public int oddsNumber;
	public int totalNumber;
	public int roundAccum;
	public int evensPoint;
	public int oddsPoint;
	public int roundOddsLost=0;
	public int roundEvensLost=0;
	public int roundEvens=0;
	public int roundOdds=0;
	public int evensExtra;
	public int oddsExtra;


		public Morra(String n){
			name = n;
			options = "";
			roundAccum = (int)1;
		}

//Getter/Setters/Returns to app class

		public void setEvens(int evens) {
			this.evens = evens;
		}

		public int getTotalNumber() {
			return totalNumber;
		}

		public void setOdds(int odds) {
			this.odds = odds;
		}

		public int getOdds() {
			return odds;
		}

		public int getEvens() {
			return evens;
		}

		public void setEven(String even) {
			this.even = even;
		}

		public void setOdd(String odd) {
			this.odd = odd;
		}

		public String getOdd() {
			return odd;
		}

		public int getRoundOdds() {
			return roundOdds;
		}

		public int getRoundEvensLost() {
			return roundEvensLost;
		}

		public int getRoundOddsLost(){
			return roundOddsLost;
		}


		public int getRoundEvens() {
			return roundEvens;
		}


		public String getEven() {
			return even;
		}

		public int getOddsNumber() {
			return oddsNumber;
		}

		public int getEvensNumber() {
			return evensNumber;
		}

		public void setOddsNumber(int oddsNumber) {
			this.oddsNumber = oddsNumber;
		}

		public void setEvensNumber(int evensNumber) {
			this.evensNumber = evensNumber;
		}


		public void setRoundOdds(int roundOdds) {
			this.roundOdds = roundOdds;
		}

		public void setRoundEvens(int roundEvens) {
			this.roundEvens = roundEvens;
		}


		void computeTotal() {
			totalNumber = evensNumber + oddsNumber;
		}

 		public void compute(){
		if((getTotalNumber() & 1) == 0){
			evensPoint += 2;
			roundEvens +=1;
			roundOddsLost = roundAccum - roundOdds;
			winner = "Evens";
			}
		else{
			oddsPoint += 2;
			roundOdds += 1;
			roundEvensLost = roundAccum - roundEvens;
			winner = "Odds";
			}

			if (getEvensNumber() > getOddsNumber()) {
				evensPoint += 1;
				evensExtra +=1;
				System.out.println("One bonus point to: " + getEven());
				}
			else if (getEvensNumber() < getOddsNumber()) {
				oddsPoint += 1;
				oddsExtra +=1;
				System.out.println("One bonus point to: " + getName());
				}
			else if (getOddsNumber() == getEvensNumber()) {
				oddsPoint += 1;
				oddsExtra +=1;
				evensExtra+=1;
				evensPoint += 1;
				System.out.println("One bonus point to each!\n\n");
				}
		 }

		 public void computeEvens(){
			System.out.println("\n\nCURRENT SCORES\nRound: " + getRoundAccum());
			System.out.println((getName() + ": Bonus points awarded in this game: " + getEvensExtra()));
			System.out.println((getOdd() + ": Bonus points awarded in this game: " + getOddsExtra()));
			System.out.println((getName()+ ": Total points awarded in this game: " + getEvensPoint()));
			System.out.println((getOdd() + ": Total points awarded in this game: " + getOddsPoint()));
			System.out.println(("Round: " + getRoundAccum() + " Winner of round: " + getWinner() + "\n\n"));
			System.out.println("________________________________");
			roundAccum++;
		}

		public void computeOdds() {
			System.out.println("\n\nCURRENT SCORES:\nRound: " + getRoundAccum());
			System.out.println((getName() + ": Bonus points awarded in this game: ") + getOddsExtra());
			System.out.println((getEven() + ": Bonus points awarded in this game: ") + getEvensExtra());
			System.out.println(getName()+ ": Total points awarded in this game: " + getOddsPoint());
			System.out.println((getEven() + ": Total points awarded in this game: ") + getEvensPoint());
			System.out.println(("Round: " + getRoundAccum()) + " Winner: " + getWinner() + "\n\n");
			System.out.println("________________________________");
			roundAccum++;
		}


		public void setOddsPoint(int oddsPoint) {
		 	this.oddsPoint = oddsPoint;
		}

		public void setOddsExtra(int oddsExtra) {
			this.oddsExtra = oddsExtra;
		}

		public void setEvensExtra(int evensExtra) {
			this.evensExtra = evensExtra;
		}

		public void setEvensPoint(int evensPoint) {
			this.evensPoint = evensPoint;
		}

		public int getOddsPoint() {
			return oddsPoint;
		}

		public int getOddsExtra() {
			return oddsExtra;
		}

		public int getEvensExtra() {
			return evensExtra;
		}

		public int getEvensPoint() {
			return evensPoint;
		}

		public void setRoundAccum(int roundAccum) {
			this.roundAccum = roundAccum;
		}

		public int getRoundAccum() {
			return roundAccum;
		}


		public String getName() {
			name = name.substring(0, 1).toUpperCase() + name.substring(1);
			return name;
		}


		public void getOptions() {
			System.out.println(getName() + ", please pick an option:\n");

			System.out.println("[1] Odds");
			System.out.println("[2] Evens");
			System.out.println("[3] Quit");
			System.out.println("________________________________");
	   	}

		public String getWinner(){
			return winner;
		}

	   	public static void print(String msg) {
			System.out.println(msg);
	   	}

	   	public void getPlayAgain() {
			System.out.println("\n\nWould you like to play another game of Morra?\n[1] Yes\n[2] No\n");
		}

		public void getPlayReset() {
				setEvensNumber(0);
				setOddsNumber(0);
				setRoundAccum(1);
				setRoundOdds(0);
				setRoundEvens(0);
				setEvensExtra(0);
				setOddsExtra(0);
				setEvensNumber(0);
				setOddsNumber(0);
				setEvensPoint(0);
				setOddsPoint(0);
				}
		}