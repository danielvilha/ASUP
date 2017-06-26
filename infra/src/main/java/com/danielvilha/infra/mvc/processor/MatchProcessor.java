package com.danielvilha.infra.mvc.processor;

import java.util.Collection;

/**
 * Created by danielvilha.
 */

public class MatchProcessor {

    private Collection<IMatchProcessor> processors;
    private Object object;

    /**
     * Construtor
     *
     * @param processors
     */
    public MatchProcessor(Object object, Collection<IMatchProcessor> processors){
        this.object = object;
        this.processors = processors;
    }

    /**
     * Efetua o processamento dos objetos solicitados
     */
    public Object process() {
        return executeProcess(true);
    }

    /**
     * Executa o processamento de todos que fizeram match
     */
    public void processAllMatch(){
        executeProcess(false);
    }

    private Object executeProcess(boolean returnFirstMatch){
        for (IMatchProcessor processor : processors) {
            if (processor.match(object)){
                Object result = processor.execute();

                if(returnFirstMatch){
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * Executa todos os processos,
     * independente se fez match
     */
    public void processAll() {
        for (IMatchProcessor processor : processors) {
            processor.execute();
        }
    }
}
