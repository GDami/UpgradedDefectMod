package upgradeddefectmod.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.Frost;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import upgradeddefectmod.UpgradedDefect;

public class Stalactite extends CustomRelic {

    private static final String ID = "Stalactite";
    //private static final RelicStrings relicStrings = CardCrawlGame.languagePack.getRelicStrings(ID);
    //private static final String name = relicStrings.NAME;
    //private static final String[] DESCRIPTIONS = relicStrings.DESCRIPTIONS;

    public Stalactite() {
        super(ID, new Texture(UpgradedDefect.makeRelicPath(ID)), RelicTier.UNCOMMON, LandingSound.CLINK);
        }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0] + 3 + this.DESCRIPTIONS[1];
    }

    public void atTurnStart() {
        this.counter = 0;
    }

    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.type == AbstractCard.CardType.ATTACK) {
            ++this.counter;
            if (this.counter % 3 == 0) {
                this.counter = 0;
                this.flash();
                AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
                AbstractDungeon.actionManager.addToBottom(new ChannelAction(new Frost()));
            }
        }

    }

    public void onVictory() {
        this.counter = -1;
    }

    public AbstractRelic makeCopy() {
        return new Stalactite();
    }

}
