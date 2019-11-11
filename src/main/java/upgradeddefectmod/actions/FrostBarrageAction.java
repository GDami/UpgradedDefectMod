package upgradeddefectmod.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.Frost;

public class FrostBarrageAction extends AbstractGameAction {

    private DamageInfo info;
    private AbstractCreature target;

    public FrostBarrageAction(AbstractCreature m, DamageInfo info) {
        this.duration = Settings.ACTION_DUR_FAST;
        this.info = info;
        this.target = m;
    }

    @Override
    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST) {
            for(int i = 0; i < AbstractDungeon.player.orbs.size(); ++i) {
                if (AbstractDungeon.player.orbs.get(i) instanceof Frost) {
                    AbstractDungeon.actionManager.addToTop(new DamageAction(this.target, this.info, AttackEffect.BLUNT_LIGHT, true));
                }
            }
        }

        this.tickDuration();
    }
}
