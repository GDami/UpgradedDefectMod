package upgradeddefectmod.variables;

import basemod.abstracts.DynamicVariable;
import com.megacrit.cardcrawl.cards.AbstractCard;
import upgradeddefectmod.cards.blue.UpgradedDefectCard;

public class SecondNumber extends DynamicVariable {


    @Override
    public String key() {
        return "UpgradedDefect:SN";
    }

    @Override
    public boolean isModified(AbstractCard card) {
        return ((UpgradedDefectCard)card).isSecondNumberModified;
    }

    @Override
    public int value(AbstractCard card) {
        return ((UpgradedDefectCard)card).secondNumber;
    }

    @Override
    public int baseValue(AbstractCard card) {
        return ((UpgradedDefectCard)card).baseSecondNumber;
    }

    @Override
    public boolean upgraded(AbstractCard card) {
        return ((UpgradedDefectCard)card).upgradedSecondNumber;
    }
}
