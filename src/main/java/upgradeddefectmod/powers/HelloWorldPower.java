package upgradeddefectmod.powers;

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.orbs.AbstractOrb;

public class HelloWorldPower extends UpgradedDefectPower {

    private static final String POWER_ID = "UpgradedDefect:HelloWorld";

    public HelloWorldPower(AbstractCreature owner, int amount) {
        super(POWER_ID, owner, amount);
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
    public void onChannel(AbstractOrb o) {
        for (int i=0 ; i < this.amount ; i++) {
            o.onStartOfTurn();
            o.onEndOfTurn();
        }
    }
}
