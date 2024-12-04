package contacts;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireContacts {
    private List<Contact> contacts;

    // contructeur
    public GestionnaireContacts() {
        this.contacts = new ArrayList<>();
    }

    // Ajouter un contact
    public void ajouterContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Conctact ajouté: " + contact.getNom() + " " + contact.getPrenom());
    }

    // Supprimer un contact par son numero de tel
    public boolean supprimerContact(String numeroTelephone) {
        for (Contact contact : contacts) {
            if (contact.getNumeroTelephone().equals(numeroTelephone)) {
                contacts.remove(contact);
                System.out.println("Contact Supprimé: " + contact.getNom() + " " + contact.getPrenom());
                return true;
            }
        }
        System.out.println("Aucun contact trouvé avec ce numéro de téléphone");
        return false;
    }

    // Afficher tous les contacts
    public void afficherContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Aucun contact à afficher");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println("Nom: " + contact.getNom());
            System.out.println("Prénom: " + contact.getPrenom());
            System.out.println("Email: " + contact.getEmail());
            System.out.println("Téléphone: " + contact.getNumeroTelephone());
            System.out.println("-------------");
        }
    }


    // Rechercher et modifier un contact par numéro de téléphone
    public boolean modifierContact(String numeroTelephone, String nouveauNom, String nouveauPrenom, String nouvelEmail, String nouveauNumero) {
        for (Contact contact : contacts) {
            if (contact.getNumeroTelephone().equals(numeroTelephone)) {
                contact.setNom(nouveauNom);
                contact.setPrenom(nouveauPrenom);
                contact.setEmail(nouvelEmail);
                contact.setNumeroTelephone(nouveauNumero);
                System.out.println("Contact modifié: " + contact.getNom() + " " + contact.getPrenom());
                return true;
            }
        }
        System.out.println("Aucun contact trouvé avec ce numéro");
        return false;
    }
}
