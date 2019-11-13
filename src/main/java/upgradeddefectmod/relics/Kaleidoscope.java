package upgradeddefectmod.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.Dark;
import com.megacrit.cardcrawl.orbs.Frost;
import com.megacrit.cardcrawl.orbs.Lightning;
import com.megacrit.cardcrawl.powers.FocusPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import upgradeddefectmod.UpgradedDefect;

public class Kaleidoscope extends UpgradedDefectRelic {

    public static final String ID = "Kaleidoscope";
    private static final String IMG_NAME = UpgradedDefect.makeRelicPath(ID);

    public Kaleidoscope() {
        super(ID, new Texture(IMG_NAME), RelicTier.UNCOMMON, LandingSound.MAGICAL);
        this.counter = 0;
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.type == AbstractCard.CardType.SKILL) {
            ++this.counter;
            if (this.counter == 15) {
                this.counter = 0;
                this.flash();
                AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
                AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Lightning()));
                AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Frost()));
                AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Dark()));
            }
        }

    }

    public AbstractRelic makeCopy() {
        return new Kaleidoscope();
    }

}
