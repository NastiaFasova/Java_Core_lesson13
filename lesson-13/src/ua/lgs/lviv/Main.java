package ua.lgs.lviv;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		VerkhovnaRada verkhovnaRada=new VerkhovnaRada();
		
		Faction faction=new Faction();
		int choice=0;
		while(true) {
			System.out.println("Enter a num of your choice: ");
			System.out.println("1. To add a faction;");
			System.out.println("2. To remove a faction;");
			System.out.println("3. To print all factions;");
			System.out.println("4. To remove all the deputies from the faction;");
			System.out.println("5. To print the information about faction;");
			System.out.println("6. To add a deputy to the faction;");
			System.out.println("7. To remove a deputy from the faction;");
			System.out.println("8. To print the list of barrators;");
			System.out.println("9. To print the greatest barrator;");
			System.out.println("10. To print the list of barrators of the faction;");
			System.out.println("11. To print the greatest barrator of the faction;");
			try {
				choice=scan.nextInt();
			} catch(Exception e) {
				System.err.println("Wrong input!!!");
				e.printStackTrace();
			}
			switch(choice) {
				case 1:{
					verkhovnaRada.addFaction();
					break;
				}
				case 2:{
					verkhovnaRada.removeFaction();
					break;
				}
				case 3:{
					verkhovnaRada.printAllFactions();
					break;
				}
				case 4:{
					Scanner scan4=new Scanner(System.in);
					System.out.println("Enter a name of a faction. All the deputies of this faction will be removed");
					String factionName=scan.next();
					for(int i=0; i<verkhovnaRada.getFactions().size(); i++) {
						if(verkhovnaRada.getFactions().get(i).getName().equalsIgnoreCase(factionName)) {
							verkhovnaRada.getFactions().get(i).removeAll();
						}
					}
					break;
				}
				case 5:{
					Scanner scan5=new Scanner(System.in);
					System.out.println("Enter a name of a faction. All the deputies of this faction will be printed");
					String factionName=scan.next();
					for(int i=0; i<verkhovnaRada.getFactions().size(); i++) {
						if(verkhovnaRada.getFactions().get(i).getName().equalsIgnoreCase(factionName)) {
							verkhovnaRada.getFactions().get(i).printAllDeputies();;
						}
					}
					break;
				}
				case 6:{
					verkhovnaRada.addDeputyToFraction();
					break;
				}
				case 7:{
					verkhovnaRada.removeDeputy();
					break;
				}
				case 8:{
					for(int i=0; i<verkhovnaRada.getFactions().size(); i++) {
						for(int j=0; j<verkhovnaRada.getFactions().get(i).getDeputy().size(); j++) {
							if(verkhovnaRada.getFactions().get(i).getDeputy().get(j).isBarrator()) {
								System.out.println(verkhovnaRada.getFactions().get(i).getDeputy().get(j));
							}
						}
					}
					System.out.println();
					break;
				}
				case 9:{
					int greatestBribe=verkhovnaRada.getFactions().get(0).getDeputy().get(0).getBribe_qty();
					Deputy greatestBarrator=verkhovnaRada.getFactions().get(0).getDeputy().get(0);
					for(int i=0; i<verkhovnaRada.getFactions().size(); i++) {
						for(int j=0; j<verkhovnaRada.getFactions().get(i).getDeputy().size(); j++) {
							if(verkhovnaRada.getFactions().get(i).getDeputy().get(j).getBribe_qty()>greatestBribe) {
								greatestBribe=verkhovnaRada.getFactions().get(i).getDeputy().get(j).getBribe_qty();
								greatestBarrator=verkhovnaRada.getFactions().get(i).getDeputy().get(j);
							}
						}
					}
					System.out.println(greatestBarrator);
					break;
				}
				case 10:{
					Scanner scan10=new Scanner(System.in);
					System.out.println("Enter a name of a faction. All the barrators of this faction will be printed");
					String factionName=scan.next();
					for(int i=0; i<verkhovnaRada.getFactions().size(); i++) {
						if(verkhovnaRada.getFactions().get(i).getName().equalsIgnoreCase(factionName)) {
							verkhovnaRada.getFactions().get(i).printBarrator();
						}
					}
					break;
				}
				case 11:{
					Scanner scan11=new Scanner(System.in);
					System.out.println("Enter a name of a faction.The greatest barrator of this faction will be printed");
					String factionName=scan.next();
					for(int i=0; i<verkhovnaRada.getFactions().size(); i++) {
						if(verkhovnaRada.getFactions().get(i).getName().equalsIgnoreCase(factionName)) {
							verkhovnaRada.getFactions().get(i).printGreatestBarrator();
						}
					}
					break;
				}
			}
		}
	}

}
