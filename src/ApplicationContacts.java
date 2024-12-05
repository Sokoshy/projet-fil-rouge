import java.util.Scanner;

import contacts.Contact;
import contacts.GestionnaireContacts;

public class ApplicationContacts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuerProgramme = true;

        GestionnaireContacts gestionnaire = new GestionnaireContacts();

        while (continuerProgramme) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Ajouter un contact");
                System.out.println("2. Supprimer un contact");
                System.out.println("3. Afficher tous les contacts");
                System.out.println("4. Modifier les informations d'un contact");
                System.out.println("5. Quitter l'application");

                System.out.print("Entrez votre choix: ");
                // Lecture de l'entrée comme une chaîne, puis conversion
                String entree = scanner.nextLine();
                int choix = Integer.parseInt(entree); // Conversion sécurisée

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

                        // Vérifie si le numéro existe déjà
                        if (gestionnaire.contientContactExistant(numeroTelephone)){
                            System.out.println("Un contact avec ce numéro existe déjà");
                        }else {
                            Contact contact = new Contact( nom,prenom, email, numeroTelephone);
                            gestionnaire.ajouterContact(contact);
                        }
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
            } catch (NumberFormatException e) {
                System.out.println("Erreur : Veuillez entrer un chiffre valide.");
            }
            
        }

        scanner.close();
    }
}
