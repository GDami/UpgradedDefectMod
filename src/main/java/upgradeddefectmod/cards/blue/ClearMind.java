package upgradeddefectmod.cards.blue;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.FocusPower;
import upgradeddefectmod.UpgradedDefect;

public class ClearMind extends CustomCard {


    public static final String ID = "UpgradedDefect:ClearMind";
    private static final String IMG_NAME = UpgradedDefect.makeCardPath(ID.split(":")[1]);
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    private static final String NAME = cardStrings.NAME;
    private static final String DESCRIPTION = cardStrings.DESCRIPTION;
    private static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    private static final int COST = 1;

    public ClearMind() {
        super(ID, NAME, IMG_NAME, COST, DESCRIPTION, CardType.SKILL, CardColor.BLUE, CardRarity.UNCOMMON, CardTarget.ENEMY);
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
        this.exhaust = true;
    }

    public AbstractCard makeCopy() {
        return new ClearMind();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.exhaust = false;
            this.upgradeName();
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        if (m != null && m.getIntentBaseDmg() >= 0) {
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new FocusPower(p, this.magicNumber)));
        }
    }
}
