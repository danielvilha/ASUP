package com.danielvilha.infra.util;

/**
 * Created by danielvilha.
 *
 * Define a prioridade da tela.
 */

public enum PriorityEnum {
    /**
     * Priority lowest <p>
     * Value: 0 from 0-5 scale
     */
    LESSER,

    /**
     * Priority low <p>
     * Value: 1 from 0-5 scale
     */
    LOW,

    /**
     * Priority normal <p>
     * Value: 2 from 0-5 scale
     */
    NORMAL,

    /**
     * Priority high <p>
     * Value: 3 from 0-5 scale
     */
    HIGH,

    /**
     * Priority very high <p>
     * Value: 4 from 0-5 scale
     */
    BOSS,

    /**
     * Priority defeat all priorities <p>
     * Value: 5 from 0-5 scale
     */
    SPARTAIN
}
