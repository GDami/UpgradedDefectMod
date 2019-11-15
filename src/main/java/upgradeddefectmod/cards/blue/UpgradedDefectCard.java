package upgradeddefectmod.cards.blue;

import basemod.abstracts.CustomCard;

public abstract class UpgradedDefectCard extends CustomCard {

    public int baseSecondNumber;
    public int secondNumber;
    public boolean isSecondNumberModified = false;
    public boolean upgradedSecondNumber = false;

    UpgradedDefectCard(String id, String name, String img, int cost, String rawDescription, CardType type, CardColor color, CardRarity rarity, CardTarget target) {
        super(id, name, img, cost, rawDescription, type, color, rarity, target);
    }

    void upgradeSecondNumber(int amount) {
        this.baseSecondNumber += amount;
        this.secondNumber = this.baseSecondNumber;
        this.upgradedSecondNumber = true;
    }


}
