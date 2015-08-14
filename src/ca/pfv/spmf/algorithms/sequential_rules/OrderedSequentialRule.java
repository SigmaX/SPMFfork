package ca.pfv.spmf.algorithms.sequential_rules;

import ca.pfv.spmf.algorithms.sequentialpatterns.BIDE_and_prefixspan.SequentialPattern;
import java.util.Objects;

/**
 * A sequential rule of the form A => B, where A and B are patterns.
 * 
 * @author Eric O. Scott
 */
public class OrderedSequentialRule {
    private final SequentialPattern antecedent;
    private final SequentialPattern consequent;
    private final double support;
    private final double confidence;
    
    public OrderedSequentialRule(final SequentialPattern antecedent, final SequentialPattern consequent, final double support, final double confidence) {
        assert(antecedent != null);
        assert(consequent != null);
        this.antecedent = antecedent.cloneSequence();
        this.consequent = consequent.cloneSequence();
        this.support = support;
        this.confidence = confidence;
        assert(repOK());
    }
    
    public double getSupport() {
        return support;
    }
    
    public double getConfidence() {
        return confidence;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Standard Methods">
    public final boolean repOK() {
        return antecedent != null
                && consequent != null
                && Double.isFinite(support)
                && Double.isFinite(confidence)
                && support >= 0
                && support <= 1.0
                && confidence >= 0
                && confidence <= 1.0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.antecedent);
        hash = 23 * hash + Objects.hashCode(this.consequent);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.support) ^ (Double.doubleToLongBits(this.support) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.confidence) ^ (Double.doubleToLongBits(this.confidence) >>> 32));
        return hash;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (!(o instanceof OrderedSequentialRule))
            return false;
        final OrderedSequentialRule ref = (OrderedSequentialRule)o;
        return Math.abs(support - ref.support) < 0.000001
                && Math.abs(confidence - ref.confidence) < 0.000001
                && antecedent.equals(ref.antecedent)
                && consequent.equals(ref.consequent);
    }
    
    public String toStriong() {
        return String.format("%s => %s", antecedent, consequent);
    }
    // </editor-fold>
}
