package upgradeddefectmod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import upgradeddefectmod.UpgradedDefect;

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
            AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, tmpZizi.get(removeIndex).ID));
        }
    }
}
