package upgradeddefectmod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import upgradeddefectmod.cards.tags.CustomCardTags;

import java.util.Iterator;

public class ClawAction extends AbstractGameAction {

    private AbstractCard card;

    public ClawAction(AbstractCard card){

        this.duration = Settings.ACTION_DUR_FAST;
        this.card = card;
        this.amount = 1;
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST) {
            AbstractCard var10000 = this.card;
            var10000.baseDamage += this.amount;
            this.card.applyPowers();
            Iterator var1 = AbstractDungeon.player.discardPile.group.iterator();

            AbstractCard c;
            while(var1.hasNext()) {
                c = (AbstractCard)var1.next();
                if (c.tags.contains(CustomCardTags.CLAW)) {
                    c.baseDamage += this.amount;
                    c.applyPowers();
                }
            }

            var1 = AbstractDungeon.player.drawPile.group.iterator();

            while(var1.hasNext()) {
                c = (AbstractCard)var1.next();
                if (c.tags.contains(CustomCardTags.CLAW)) {
                    c.baseDamage += this.amount;
                    c.applyPowers();
                }
            }

            var1 = AbstractDungeon.player.hand.group.iterator();

            while(var1.hasNext()) {
                c = (AbstractCard)var1.next();
                if (c.tags.contains(CustomCardTags.CLAW)) {
                    c.baseDamage += this.amount;
                    c.applyPowers();
                }
            }
        }

        this.tickDuration();
    }

}
