package com.cactusli.springframework.tx.transaction.interceptor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cactusli on 2023/1/5 15:06
 */
public class RuleBasedTransactionAttribute extends DefaultTransactionAttribute implements Serializable {

    private List<RollbackRuleAttribute> rollbackRules;

    public RuleBasedTransactionAttribute() {
        super();
    }

    public void setRollbackRules(List<RollbackRuleAttribute> rollbackRules) {
        this.rollbackRules = rollbackRules;
    }
}
