package com.pacoworks.rxsealedunions.tennis;

public class PlayerTwo {
    public boolean equals(Object o) {
        return o == this || o instanceof PlayerTwo;
    }
}
