package upgradeddefectmod.powers;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import upgradeddefectmod.UpgradedDefect;

public class UpgradedDefectPower extends AbstractPower {

    private static PowerStrings powerStrings;
    protected static String[] DESCRIPTIONS;

    UpgradedDefectPower(String POWER_ID, AbstractCreature owner, int amount) {
        this.ID = POWER_ID;
        powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
        this.name = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
        this.owner = owner;
        this.amount = amount;
        this.updateDescription();
        this.img = new Texture(UpgradedDefect.makePowerPath(POWER_ID.split(":")[1]));
    }

    public void afterMonstersTurn() {}

}
