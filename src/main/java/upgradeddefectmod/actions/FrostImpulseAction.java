package upgradeddefectmod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;
import com.megacrit.cardcrawl.orbs.Frost;
import com.megacrit.cardcrawl.vfx.combat.OrbFlareEffect;
import upgradeddefectmod.UpgradedDefect;


public class FrostImpulseAction extends AbstractGameAction {

    private boolean isPriority = false;

    public FrostImpulseAction() {
        this.duration = Settings.ACTION_DUR_FAST;
    }

    public FrostImpulseAction(boolean first) {
        this.duration = Settings.ACTION_DUR_FAST;
        this.isPriority = first;
    }

    public void onEndOfTurn(AbstractOrb o) {
        float speedTime = 0.6F / (float)AbstractDungeon.player.orbs.size();
        if (Settings.FAST_MODE) {
            speedTime = 0.0F;
        }

        AbstractDungeon.actionManager.addToTop(new VFXAction(new OrbFlareEffect(o, OrbFlareEffect.OrbFlareColor.FROST), speedTime));
        AbstractDungeon.actionManager.addToTop(new GainBlockAction(AbstractDungeon.player, AbstractDungeon.player, o.passiveAmount, true));
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST && !AbstractDungeon.player.orbs.isEmpty()) {

            for (AbstractOrb o : AbstractDungeon.player.orbs) {
                if (o instanceof Frost) {
                    if (isPriority) {
                        onEndOfTurn(o);
                    } else {
                        o.onEndOfTurn();
                    }
                }
            }

            if (AbstractDungeon.player.hasRelic("Cables") && !(AbstractDungeon.player.orbs.get(0) instanceof EmptyOrbSlot) && AbstractDungeon.player.orbs.get(0) instanceof Frost) {
                if (isPriority) {
                    onEndOfTurn(AbstractDungeon.player.orbs.get(0));
                } else {
                    (AbstractDungeon.player.orbs.get(0)).onEndOfTurn();
                }
        }
            UpgradedDefect.logger.info(AbstractDungeon.player.currentBlock);

        }

        this.tickDuration();
    }

}
