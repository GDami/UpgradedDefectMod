package upgradeddefectmod.powers;

import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.defect.DecreaseMaxOrbAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class LoseOrbSlotsNextTurnPower extends UpgradedDefectPower {

    private static final String POWER_ID = "UpgradedDefect:LoseOrbSlotsNextTurn";

    public LoseOrbSlotsNextTurnPower(AbstractCreature owner, int slotDecrease) {
        super(POWER_ID, owner, slotDecrease);
        this.type = PowerType.DEBUFF;
    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.amount += stackAmount;
    }

    @Override
    public void updateDescription() {
        if (this.amount == 1) {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
        } else {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[2];
        }
    }

    @Override
    public void atStartOfTurnPostDraw() {
        AbstractDungeon.actionManager.addToBottom(new DecreaseMaxOrbAction(this.amount));
        AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, POWER_ID));
    }

}
