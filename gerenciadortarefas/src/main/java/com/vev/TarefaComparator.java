package com.vev;

import java.util.Comparator;

public class TarefaComparator implements Comparator<Tarefa> {
    @Override
    public int compare(Tarefa t1, Tarefa t2) {
        int dataComparison = t1.getDataVencimento().compareTo(t2.getDataVencimento());

        if (dataComparison == 0) {
            return t1.getprioridade().compareTo(t2.getprioridade());
        }

        return dataComparison;
    }
}
