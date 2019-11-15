package upgradeddefectmod.cards.blue;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DrawReductionPower;
import upgradeddefectmod.UpgradedDefect;

public class CustomSkim extends CustomCard {

    public static final String ID = "UpgradedDefect:Skim";
    private static final String IMG_NAME = UpgradedDefect.makeCardPath(ID.split(":")[1]);
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    private static final String NAME = cardStrings.NAME;
    private static final String DESCRIPTION = cardStrings.DESCRIPTION;
    private static final int COST = 0;

    public CustomSkim() {
        super(ID, NAME, IMG_NAME, COST, DESCRIPTION, CardType.SKILL, CardColor.BLUE, CardRarity.COMMON, CardTarget.NONE);
        this.baseMagicNumber = 2;
        this.magicNumber = this.baseMagicNumber;
    }

    public AbstractCard makeCopy() {
        return new CustomSkim();
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeMagicNumber(1);
            this.upgradeName();
        }
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new DrawCardAction(p, this.magicNumber, false));
        AbstractPower po = new DrawReductionPower(p, 1);
        AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, po, 1));
        po.atEndOfRound();
    }
}
