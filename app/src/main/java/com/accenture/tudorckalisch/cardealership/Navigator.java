package com.accenture.tudorckalisch.cardealership;

import java.util.List;

/**
 * Created by tudor.c.kalisch on 6/30/2017.
 */

public interface Navigator {
    public void navListFragment();
    public void navListFragment(Car[] cars);
    public void navDetailsFragment(Car car);
}
