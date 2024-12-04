import java.util.Scanner;

import contacts.Contact;
import contacts.GestionnaireContacts;

public class ApplicationContacts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuerProgramme = true;

        GestionnaireContacts gestionnaire = new GestionnaireContacts();

        while (continuerProgramme) {
            System.out.println("\nMenu:");
            System.out.println("1. Ajouter un contact");
            System.out.println("2. Supprimer un contact");
            System.out.println("3. Afficher tous les contacts");
            System.out.println("4. Modifier les informations d'un contact");
            System.out.println("5. Quitter l'application");

            System.out.print("Entrez votre choix: ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case  1:
                    // Ajouter un contact
                    System.out.print("Entrez un nom: ");
                    String nom = scanner.nextLine();

                    System.out.print("Entrez un prenom: ");
                    String prenom = scanner.nextLine();

                    System.out.print("Entrez un email: ");
                    String email = scanner.nextLine();

                    System.out.print("Entrez un numero de telephone: ");
                    String numeroTelephone = scanner.nextLine();

                    Contact contact = new Contact( nom,prenom, email, numeroTelephone);

                    // GestionnaireContacts gestionnaire = new GestionnaireContacts();
                    gestionnaire.ajouterContact(contact);

                    
                    break;
                case  2:
                    //Supprimer un contact existant
                    System.out.print("Entrez le numero de telephone du contact a supprimer: ");
                    String contactSupprimer = scanner.nextLine();

                    gestionnaire.supprimerContact(contactSupprimer);
                    break;
                case  3:
                    // Afficher la liste de tous les contacts
                    gestionnaire.afficherContacts();

                    break;
                case  4:
                    // Modifier les informations d'un contact par son numéro de téléphone.
                    System.out.print("Entrez le numero de telephone du contact a modifier: ");
                    String contactModifier = scanner.nextLine();

                    System.out.print("Entrez le nouveau nom: ");
                    String nouveauNom = scanner.nextLine();

                    System.out.print("Entrez le nouveau prenom: ");
                    String nouveauPrenom = scanner.nextLine();

                    System.out.print("Entrez le nouvelle email: ");
                    String nouvelleEmail = scanner.nextLine();

                    System.out.print("Entrez le nouveau numero de telephone: ");
                    String nouveauNumeroTelephone = scanner.nextLine();

                    gestionnaire.modifierContact(contactModifier, nouveauNom, nouveauPrenom, nouvelleEmail, nouveauNumeroTelephone);
                    break;
                case  5:
                    System.out.println("Au revoir !");
                    continuerProgramme = false;
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer un chiffre entre 1 et 5");
                    break;
            }
        }

        scanner.close();
    }
}