package com.otuzikibit.finance_portal.model.enums;

/** Fiyat alarmı tetikleme koşulu. */
public enum AlarmCondition {
    /** Fiyat threshold değerine ulaşır veya geçerse (>= threshold) tetiklenir. */
    ABOVE,
    /** Fiyat threshold değerine düşer veya altına inerse (<= threshold) tetiklenir. */
    BELOW
}
