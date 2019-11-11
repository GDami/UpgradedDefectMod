package upgradeddefectmod.cards.blue;

import basemod.abstracts.CustomCard;
import basemod.abstracts.CustomUnlockBundle;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import upgradeddefectmod.UpgradedDefect;
import upgradeddefectmod.actions.FrostBarrageAction;

public class FrostBarrage extends CustomCard {

    public static final String ID = "UpgradedDefect:FrostBarrage";
    private static final String IMG_NAME = UpgradedDefect.makeCardPath(ID.split(":")[1]);
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
    private static final String NAME = cardStrings.NAME;
    private static final String DESCRIPTION = cardStrings.DESCRIPTION;
    private static final int COST = 1;

    public FrostBarrage() {
        super(ID, NAME, IMG_NAME, COST, DESCRIPTION, CardType.ATTACK, AbstractCard.CardColor.BLUE, AbstractCard.CardRarity.COMMON, CardTarget.ENEMY);
        this.baseDamage = 5;
    }

    public AbstractCard makeCopy() {
        return new FrostBarrage();
    }


    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(3);
        }
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(new FrostBarrageAction(m, new DamageInfo(p, this.damage, DamageInfo.DamageType.NORMAL)));
    }
}
