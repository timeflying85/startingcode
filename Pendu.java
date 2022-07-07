package labo;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Pendu { 

	public static void main(String[] args) {

		String tabMots[]= {"programmation","animal","planeur","accident","encoder","vodka","biere","vin","explorer","ailes","ecran","participant","apocalypse","baccalaureat","montgolfiere","qualification","printemps","horoscope","accordeon","ascenseur","pomme","poire","mandarine","abricot","billet","bouche","boucle","bronze","corbeau","cortege","crapaud","voiture","abruti","ordinateur","bouteille","verre","sandwich","hamburger","essence","roue","clavier","pantalon","chaussure","helicoptere","camera","television","parachute","formation","cheval","canari","chien"}; // tableau de mot à trouver
		char[]tab2;
		char[]tab3 = new char[9];

		int i; //variable de boucle coucou
		int cpt=8;
		int cpt2=0;

		Random r=new Random(); //pour utiliser nbalea
		int nbalea; //determine nb entre 0 et lg mot
		String Mdeviner; //insert mot à deviner tirer au hasard
		int LongMdeviner; //on stock la lg du mot à deviner
		char tabMdeviner[]; //on crée un tableau de la lg du mot à deviner 

		char lettre; //tab pour la saisie de la lettre

		int nbErreur=0; // nb erreur
		boolean identique=false; //permet de savoir si lettre saisie est dans mot afficher
		int nblettrecorrect=0; // nb lettre correcte
		boolean recommencer=true;



		do {
			System.out.println("Bienvenu(e) dans le jeu du pendu");
			System.out.println("");

			cpt2=0;
			cpt=8;
			tab3 = new char[9];
			nbErreur=0;
			nblettrecorrect=0;

			nbalea=r.nextInt(tabMots.length-1); 
			Mdeviner=tabMots[nbalea]; 
			LongMdeviner=Mdeviner.length(); 
			tabMdeviner=new char[LongMdeviner];

			char [] tabM=Mdeviner.toCharArray();

			for (i=0;i<tabM.length;i++) {
				tabMdeviner[i]=Mdeviner.charAt(i);
				

			}


			tab2=new char[tabM.length];

			for (i=0;i<tab2.length;i++) {
				tab2[i]='_';
				System.out.print(tab2[i]+"\t");
			}
			System.out.println();


			do {
				System.out.println();
				lettre=saisieChar();

				identique=false;
				for (i=0;i<tabM.length;i++) {
					if (lettre==tabMdeviner[i]) {
						identique=true;
						if(tab2[i]==tabMdeviner[i]) {
							System.out.println("Lettre correcte déjà encodée");
							i=tabM.length;
						}
						else
						{
							tab2[i]=tabMdeviner[i];
							nblettrecorrect++;
							//System.out.println(i);
						}
					}
				}


				if (identique==false) {

					System.out.println();
					nbErreur++;
					cpt2++;
					cpt--;
					affiche(nbErreur);
					System.out.println("Il vous reste "+cpt+" erreurs possible");
					System.out.println();
					tab3[cpt2]=lettre;
					System.out.println("vous avez déjà rentré les lettres : ");

					for (int cpt22=0;cpt22<tab3.length;cpt22++) {

						System.out.print(tab3[cpt22]+"\t");

					}
					System.out.println();
				}
				System.out.println();
				for (i=0;i<tab2.length;i++) {
					System.out.print(tab2[i]+"\t");
				}
				System.out.println();
			}
			while (nbErreur<8 && nblettrecorrect!=tab2.length);



			if (nbErreur==8) {
				affiche(nbErreur);
				System.out.println("vous avez perdu");
				System.out.println();
				System.out.println("le mot à trouver était : "+Mdeviner);
				System.out.println();
				System.out.println("Voulez-vous rejouer ? True/false ");

			}
			if (nblettrecorrect==tabMdeviner.length) {
				System.out.println();
				System.out.println("Félicitation, vous avez trouvé le mot après "+(nbErreur+nblettrecorrect)+" tentatives");
				System.out.println();
				System.out.println("Voulez-vous rejouer ? True/false ");
			}

			recommencer=saisieBoolean();
			if (recommencer==false) {
				System.out.println();
				System.out.println("Merci d'avoir jouer, à bientôt");
			}
		}
		while (recommencer==true);

	}




	public static  void affiche (int nbErreur) {
		switch(nbErreur) {
		case 1 : 
			System.out.println();
			System.out.println("__________________");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println();
			break;
		case 2:	
			System.out.println();
			System.out.println("__________________");
			System.out.println("|          |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println();
			break;

		case 3:	
			System.out.println();
			System.out.println("__________________");
			System.out.println("|          |");
			System.out.println("|        (° °)");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println();
			break;

		case 4:	
			System.out.println();
			System.out.println("__________________");
			System.out.println("|          |");
			System.out.println("|        (° °)");
			System.out.println("|         | |");
			System.out.println("|         | |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println();
			break;

		case 5:	
			System.out.println();
			System.out.println("__________________");
			System.out.println("|          |");
			System.out.println("|        (° °)");
			System.out.println("|        /| |");
			System.out.println("|         | |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println();
			break;
		case 6:	
			System.out.println();
			System.out.println("__________________");
			System.out.println("|          |");
			System.out.println("|        (° °)");
			System.out.println("|        /| |\\");
			System.out.println("|         | |");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println();
			break;
		case 7:	
			System.out.println();
			System.out.println("__________________");
			System.out.println("|          |");
			System.out.println("|        (° °)");
			System.out.println("|        /| |\\");
			System.out.println("|         | |");
			System.out.println("|         / ");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println();
			break;
		case 8:	
			System.out.println();
			System.out.println("__________________");
			System.out.println("|          |");
			System.out.println("|        (- -)");
			System.out.println("|        /| |\\");
			System.out.println("|         | |");
			System.out.println("|         / \\");
			System.out.println("|");
			System.out.println("|");
			System.out.println("|");
			System.out.println();
			break;
		}

	}

	public static char saisieChar() {
		char lettre=' ';
		boolean ok;
		do{
			ok=true;
			try{
				System.out.println("Entrez une lettre");
				lettre=(new Scanner(System.in)).nextLine().toLowerCase().charAt(0);
			}
			catch (java.lang.StringIndexOutOfBoundsException e) {  // si String vide débordement de tableau
				System.out.println("on vous a demandé au moins un lettre");
				ok=false;

			}
			if(lettre<61 || lettre>122) { // code ascii de a et de z
				System.out.println("ce n'est pas une lettre");
				ok=false;
			}
		}while (!ok);
		return lettre;
	}

	public static boolean saisieBoolean() {

		boolean ok, recommencer=false;
		do{
			ok=true;
			try{

				recommencer=(new Scanner(System.in)).nextBoolean();
			}
			catch(InputMismatchException e) { 
				System.out.println("On vous a demandé true ou false !!");
				ok=false;

			}

		}while (!ok);
		return recommencer;
	}
}





