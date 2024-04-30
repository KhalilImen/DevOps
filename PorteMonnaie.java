package monprojet;
import java.util.HashMap;

public class PorteMonnaie {
    private HashMap<String, Integer> contenu;

    public HashMap<String, Integer> getContenu() {
        return contenu;
    }

    public PorteMonnaie() {
        contenu = new HashMap<String, Integer>();
    }

    public void ajouteSomme(SommeArgent sa) {
        String unite = sa.getUnite();
        int quantite = sa.getQuantite();

        // Si l'unité est déjà présente dans le porte-monnaie
        if (contenu.containsKey(unite)) {
            int ancienneQuantite = contenu.get(unite);
            contenu.put(unite, ancienneQuantite + quantite);
        } else {
            // Si l'unité n'est pas encore présente dans le porte-monnaie
            contenu.put(unite, quantite);
        }
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Contenu du porte-monnaie :\n");

        for (String unite : contenu.keySet()) {
            int quantite = contenu.get(unite);
            SommeArgent somme = new SommeArgent(quantite, unite);
            result.append(somme.toString()).append("\n");
        }

        return result.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        PorteMonnaie that = (PorteMonnaie) obj;
        return this.contenu.equals(that.contenu);
    }

}
