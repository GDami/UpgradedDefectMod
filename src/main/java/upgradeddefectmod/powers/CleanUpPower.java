package upgradeddefectmod.powers;

import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.ArrayList;

public class CleanUpPower extends UpgradedDefectPower {

    private static final String POWER_ID = "UpgradedDefect:CleanUp";

    public CleanUpPower(AbstractCreature owner, int amount) {
        super(POWER_ID, owner, amount);
    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
    }

    public void updateDescription() {
        if (this.amount == 1) {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
        } else {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[2];
        }
    }

    @Override
    public void afterMonstersTurn() {
        ArrayList<AbstractPower> tmpZizi = new ArrayList();
        for (AbstractPower p : this.owner.powers) {
            if (p.type == PowerType.DEBUFF) {
                tmpZizi.add(p);
            }
        }
        if (!tmpZizi.isEmpty()) {
            this.flash();
            int removeIndex = AbstractDungeon.cardRng.random(0, tmpZizi.size() - 1);
            AbstractDungeon.actionManager.addToTop(new RemoveSpecificPowerAction(this.owner, this.owner, tmpZizi.get(removeIndex).ID));
        }
    }
}
