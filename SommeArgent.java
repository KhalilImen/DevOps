package monprojet;
public class SommeArgent {
    private int quantite;
    private String unite;

    public SommeArgent(int amount, String currency) {
        quantite = amount;
        unite = currency;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getUnite() {
        return unite;
    }

    public SommeArgent add(SommeArgent m) throws UniteDistincteException {
        if (!m.getUnite().equals(this.getUnite())) {
            throw new UniteDistincteException(this, m);
        }
        else return new SommeArgent(getQuantite()+m.getQuantite(), getUnite());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SommeArgent other = (SommeArgent) obj;
        return quantite == other.quantite && unite.equals(other.unite);
    }
    @Override
    public String toString() {
        return quantite + " " + unite;
    }
}
