package upgradeddefectmod.cards.blue;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.defect.DarkImpulseAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.orbs.Dark;
import com.megacrit.cardcrawl.orbs.EmptyOrbSlot;
import com.megacrit.cardcrawl.vfx.ThoughtBubble;
import upgradeddefectmod.UpgradedDefect;
import upgradeddefectmod.actions.ReplaceOrbAction;

public class DarkWave extends CustomCard {


    public static final String ID = "UpgradedDefect:DarkWave";
    private static final String IMG_NAME = UpgradedDefect.makeCardPath(ID.split(":")[1]);
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    private static final String NAME = cardStrings.NAME;
    private static final String DESCRIPTION = cardStrings.DESCRIPTION;
    private static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    private static final int COST = 2;

    public DarkWave() {
        super(ID, NAME, IMG_NAME, COST, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCard.CardColor.BLUE, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.NONE);
        this.exhaust = true;
    }

    public AbstractCard makeCopy() {
        return new DarkWave();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (!p.orbs.isEmpty()) {
            for (int i=0 ; i < p.orbs.size() ; i++) {
                AbstractOrb o = p.orbs.get(i);
                if (!(o instanceof EmptyOrbSlot) && !(o instanceof Dark)) {
                    UpgradedDefect.logger.info(i);
                    AbstractDungeon.actionManager.addToBottom(new ReplaceOrbAction(i, new Dark()));
                    UpgradedDefect.logger.info("tt " + i);
                }
            }
            if (this.upgraded) {
                AbstractDungeon.actionManager.addToBottom(new DarkImpulseAction());
            }
        } else {
            AbstractDungeon.effectList.add(new ThoughtBubble(p.dialogX, p.dialogY, 3.0F, "I don't have any orb channeled...", true));
        }
    }
}
