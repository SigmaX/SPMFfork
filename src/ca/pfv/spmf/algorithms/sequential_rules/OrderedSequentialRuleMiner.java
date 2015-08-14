package ca.pfv.spmf.algorithms.sequential_rules;

import ca.pfv.spmf.input.sequence_database_list_integers.SequenceDatabase;
import java.util.List;

/**
 *
 * @author Eric O. Scott
 */
public interface OrderedSequentialRuleMiner {
    public List<OrderedSequentialRule> runAlgorithm(double minSupport, double minConfidence, SequenceDatabase input);
}
